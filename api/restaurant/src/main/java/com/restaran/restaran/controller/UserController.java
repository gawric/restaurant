package com.restaran.restaran.controller;

import com.restaran.restaran.model.UserModel;

import com.restaran.restaran.service.serviceinterface.IServiceUserDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;


@RestController
@RequestMapping("users-rest")
public class UserController {

    @Autowired
    private IServiceUserDb serviceUserDb;

    @GetMapping(value = "/getUser")
    public ResponseEntity<Object> getUser(@RequestParam long id) {
        return serviceUserDb.findByIdTWeb(id);
    }

    @PostMapping(path  = "/addUser" , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object>  createUser(@Valid @RequestBody UserModel newUser) {
        return serviceUserDb.addUserWeb(newUser);
    }




}
