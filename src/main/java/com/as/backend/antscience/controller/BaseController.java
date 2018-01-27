package com.as.backend.antscience.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:8102", maxAge = 3600)
public class BaseController {
    @GetMapping("/")
    public String hello(){
        return "Hello World";
    }
}

