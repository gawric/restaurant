package com.restaran.restaran.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RestController
public class HelloController {

    @GetMapping(value="/", produces = MediaType.TEXT_PLAIN_VALUE)
    public String index() {

        return "This is Home page not defender";
    }

    @PreAuthorize("hasAuthority('USER')")
    @GetMapping(value="/hellouser", produces = MediaType.TEXT_PLAIN_VALUE)
    public String sayHelloUser() {

        return "Hello there! defender WWWsW!";
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping(value="/helloadmin", produces = MediaType.TEXT_PLAIN_VALUE)
    public String sayHelloAdmin() {

        return "Hello there! defender WWWsW!";
    }

}
