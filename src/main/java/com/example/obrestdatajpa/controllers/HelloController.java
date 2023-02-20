package com.example.obrestdatajpa.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String helloWorld(){
        return "Hello World dev-tools 1.7";
    }
}
