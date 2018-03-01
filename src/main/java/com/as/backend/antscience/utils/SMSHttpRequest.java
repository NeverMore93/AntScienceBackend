package com.as.backend.antscience.utils;

import com.as.backend.antscience.dao.UserDao;
import com.as.backend.antscience.dto.RegisterUserDto;
import com.as.backend.antscience.dto.SMSdto;
import com.as.backend.antscience.dto.UserDto;
import com.as.backend.antscience.entity.User;
import com.as.backend.antscience.exceptions.SMSException;
import com.as.backend.antscience.exceptions.VerificationCodeException;
import com.as.backend.antscience.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.asynchttpclient.*;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

@Data
@NoArgsConstructor
@Slf4j
public class SMSHttpRequest {
    private String appid;
    private String project;
    private String signature;
    private String URL;

    public static final long VERIFICATION_CODE_EXPIRATION_TIME = 5L;

    @Resource(name = "redisTemplate")
    private RedisTemplate<String, Object> redisTemplate;

    @Resource(name = "userDao")
    private UserDao userDao;

    @Resource(name = "userService")
    private UserService userService;

    public SMSdto execute(String phone) {
        SMSdto smSdto = new SMSdto();
        String code = RandomCode.generateCode(4);
        redisTemplate.opsForValue().set(phone, code, VERIFICATION_CODE_EXPIRATION_TIME, TimeUnit.MINUTES);
        AsyncHttpClient asyncHttpClient = new DefaultAsyncHttpClient();
        List<Param> params = new ArrayList<>();
        params.add(new Param("appid", appid));
        params.add(new Param("to", phone));
        params.add(new Param("project", project));
        params.add(new Param("signature", signature));
        params.add(new Param("vars", "{\"code\":\"" + code + "\"}"));
        Request request = asyncHttpClient.preparePost(URL).setFormParams(params).build();
        ListenableFuture<String> response = asyncHttpClient.executeRequest(request, new AsyncCompletionHandler<String>() {
            @Override
            public String onCompleted(Response response) {
                log.info(phone + "短信发送成功");
                return response.getResponseBody();
            }

            @Override
            public void onThrowable(Throwable t) {
                log.info(phone + "短信发送失败", t);
                throw new SMSException(phone + "短信发送失败", t);
            }
        });
        String result = null;
        ObjectMapper mapper = new ObjectMapper();
        try {
            result = response.get();
            smSdto = mapper.readValue(result, SMSdto.class);
        } catch (InterruptedException | ExecutionException | IOException e) {
            log.info(phone + "短信发送失败" + e.getMessage());
            e.printStackTrace();
        }
        return smSdto;
    }

    public UserDto validateVerificationCode(String phone, String code) {
        String cachedCode = (String) redisTemplate.opsForValue().get(phone);
        if (!code.equals(cachedCode)) {
            throw new VerificationCodeException("验证码错误");
        }
        User user = userDao.findUserByPhone(phone);
        if(Objects.isNull(user)){
            RegisterUserDto registerUserDto = new RegisterUserDto();
            registerUserDto.setPhone(phone);
            registerUserDto.setUsername(phone);
            userService.register(registerUserDto);
        }
        user = userDao.findUserByPhone(phone);
        return new UserDto(user.getId(), user.getUsername(), user.getEmail(), user.getPhone(), user.getGender(), null);
    }
}
