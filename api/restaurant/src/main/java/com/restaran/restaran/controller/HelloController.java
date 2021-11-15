package com.restaran.restaran.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@RestController
public class HelloController {

    @GetMapping(value="/", produces = MediaType.TEXT_PLAIN_VALUE)
    public String index() {

        return "This is Home page not defender";
    }

    @GetMapping(value="/hello", produces = MediaType.TEXT_PLAIN_VALUE)
    public String sayHello() {

        return "Hello there! defender WWWsW!";
    }

}
