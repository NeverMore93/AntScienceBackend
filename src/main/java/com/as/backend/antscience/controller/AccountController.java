package com.as.backend.antscience.controller;

import com.as.backend.antscience.dto.LoginUser;
import com.as.backend.antscience.entity.User;
import com.as.backend.antscience.enums.Authority;
import com.as.backend.antscience.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "http://localhost:8102", maxAge = 3600)
public class AccountController{

    @Resource(name = "userService")
    private UserService userService;

    String[] authorities = {Authority.GENERAL.toString()};

    @PostMapping("/register")
    public User register(@RequestBody @Valid LoginUser loginUser){
        User user  = new User();
        user.setUsername(loginUser.getIdentity());
        user.setPassword(loginUser.getPassword());
        user.setRoles(authorities);
        userService.createUser(user);
        return userService.findUserByUsername(loginUser.getIdentity());
    }


    @GetMapping("/verification/phone/{phone}")
    public User register(@RequestBody @Valid LoginUser loginUser){
        User user  = new User();
        user.setUsername(loginUser.getIdentity());
        user.setPassword(loginUser.getPassword());
        user.setRoles(authorities);
        userService.createUser(user);
        return userService.findUserByUsername(loginUser.getIdentity());
    }



//    @PostMapping("/login")
//    public User login(@RequestBody @Valid LoginUser user){
//
//        return null;
//    }

}
