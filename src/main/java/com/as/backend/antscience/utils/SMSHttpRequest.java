package com.as.backend.antscience.utils;

import com.as.backend.antscience.exceptions.SMSException;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.asynchttpclient.*;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Slf4j
public class SMSHttpRequest {
    private String appid;
    private String to;
    private String project;
    private String signature;
    private String URL;

    @Resource(name = "redisTemplate")
    private RedisTemplate<String, Object> redisTemplate;

    public void execute() {
        String code = RandomCode.generateCode(4);
        redisTemplate.opsForValue().set(to, code);
        AsyncHttpClient asyncHttpClient = new DefaultAsyncHttpClient();
        List<Param> params = new ArrayList<>();
        params.add(new Param("appid", appid));
        params.add(new Param("to", to));
        params.add(new Param("project", project));
        params.add(new Param("signature", signature));
        params.add(new Param("vars", "{\"code\":\"" + code + "\"}"));
        Request request = asyncHttpClient.preparePost(URL).setFormParams(params).build();

        ListenableFuture<String> response = asyncHttpClient.executeRequest(request, new AsyncCompletionHandler<String>() {
            @Override
            public String onCompleted(Response response) {
                log.info(to + "短信发送成功");
                return response.getResponseBody();
            }

            @Override
            public void onThrowable(Throwable t) {
                log.info(to + "短信发送失败", t);
                throw new SMSException(to + "短信发送失败", t);
            }
        });


    }
}
