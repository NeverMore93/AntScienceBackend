package com.as.backend.antscience.controller;

@RestController
public class BaseController {
    @GetMapping("/")
    public String hello(){
        return "Hello World";
    }
}
