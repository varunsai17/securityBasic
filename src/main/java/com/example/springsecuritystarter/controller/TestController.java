package com.example.springsecuritystarter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/hi")
    public String hi(){
        return "hi";
    }

    @GetMapping("/bye")
    public String bye(){
        return "bye!!!";
    }
}
