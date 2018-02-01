package com.as.backend.antscience.controller;

import com.as.backend.antscience.dto.LoginUser;
import com.as.backend.antscience.dto.RegisterUserDto;
import com.as.backend.antscience.dto.SMSdto;
import com.as.backend.antscience.dto.UserDto;
import com.as.backend.antscience.entity.User;
import com.as.backend.antscience.service.UserService;
import com.as.backend.antscience.utils.SMSHttpRequest;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
@CrossOrigin(origins = {"http://localhost:8102","*"}, maxAge = 3600)
public class AccountController {

    @Resource(name = "userService")
    private UserService userService;

    @Resource(name = "smsHttpRequest")
    private SMSHttpRequest smsHttpRequest;

    @PostMapping("/auth/register")
    public UserDto register(@RequestBody @Valid RegisterUserDto registerUserDto) {
        return userService.register(registerUserDto);
    }

    @PostMapping("/auth/login")
    public UserDto login(@RequestBody @Valid LoginUser loginUser) {
        return userService.login(loginUser);
    }

    @GetMapping("/auth/verification/phone/{phone}")
    public SMSdto sendVerificationCodeByPhone(@PathVariable("phone") String phone) {
        return smsHttpRequest.execute(phone);
    }

    @GetMapping("/auth/verification/phone/{to}/code/{code}")
    public UserDto validateVerificationCode(@PathVariable("to") String to, @PathVariable("code") String code) {
        return smsHttpRequest.validateVerificationCode(to, code);
    }
}
