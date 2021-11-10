package com.restaran.restaran.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloContorller {

    @GetMapping("/")
    private String hello() {

        return "OK";
    }
}
