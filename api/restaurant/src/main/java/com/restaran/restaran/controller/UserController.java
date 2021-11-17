package com.restaran.restaran.controller;

import com.restaran.restaran.model.UserModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;

@RestController
@RequestMapping("users-rest")
public class UserController {

    @GetMapping(value = "/getUser")
    public ResponseEntity getUser(@RequestParam String id) {
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

    @PostMapping(path  = "/addUser" , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserModel>  createUser(@RequestBody UserModel newUser) {
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }
}
