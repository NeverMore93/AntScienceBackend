package com.as.backend.antscience.controller;

import com.as.backend.antscience.entity.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class AccountController {
    @PostMapping("/register")
    public User register(@RequestBody @Valid User user){

        return null;
    }

}
