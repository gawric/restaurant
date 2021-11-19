package com.restaran.restaran.controller;

import com.restaran.restaran.model.UserModel;

import com.restaran.restaran.service.serviceinterface.IServiceUser;
import com.restaran.restaran.service.serviceinterface.IServiceUserDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.time.LocalDateTime;


@RestController
@RequestMapping("users-rest")
public class UserController {

    @Autowired
    private IServiceUser serviceUser;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(value = "/getUser")
    public ResponseEntity<Object> getUser(@RequestParam long id) {
        return serviceUser.findByIdTWeb(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(value = "/delUser")
    public ResponseEntity<Object> delUser(@RequestParam long id) {
        return serviceUser.delUserWeb(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping(path  = "/addUser" , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object>  createUser(@Valid @RequestBody UserModel newUser) {
        return serviceUser.addUserWeb(newUser);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping(path  = "/updUser" , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object>  updateUser(@Valid @RequestBody UserModel newUser) {
        return serviceUser.updUserWeb(newUser);
    }

    //Редактирование себя для юзеров
    @PreAuthorize("hasRole('USER')")
    @PostMapping(path  = "/slfUpdUser" , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object>  selfUpdateUser(@Valid @RequestBody UserModel newUser , Principal principal) {
        String username = principal.getName();
        return serviceUser.selfUpdUserWeb(username,  newUser);

    }




}
