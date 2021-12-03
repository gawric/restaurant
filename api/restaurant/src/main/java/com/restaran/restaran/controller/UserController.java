package com.restaran.restaran.controller;

import com.restaran.restaran.model.UserModel;

import com.restaran.restaran.service.serviceinterface.IServiceUser;
//import io.swagger.annotations.*;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;


@RestController
@RequestMapping("users-rest")
public class UserController {

    @Autowired
    private IServiceUser serviceUser;

    @ApiOperation(value = "Получаем нужного нам пользователя чере GET запрос с его id номером ")
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(value = "/getUser")
    public ResponseEntity<Object> getUser(@RequestParam long id ) {
        return serviceUser.findByIdTWeb(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(value = "/delUser")
    public ResponseEntity<Object> delUser(@RequestParam long id) {
        return serviceUser.delUserWeb(id);
    }


    @ApiOperation(value = "Админка для блокировки пользователя по id номеру")
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(value = "/blockUser")
    public ResponseEntity<Object>  blockUser(@RequestParam long id) {
        return serviceUser.blockUserWeb(id , true);
    }


    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(value = "/unblockUser")
    public ResponseEntity<Object>  unblockUser(@RequestParam long id) {
        return serviceUser.blockUserWeb(id , false);
    }

    @PostMapping(path  = "/addUser" , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object>  createUser(@Valid @RequestBody UserModel newUser) {
        return serviceUser.addUserWeb(newUser);
    }


    @ApiOperation(value = "Обновляем пользователя из меню администратора ")
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping(path  = "/updUser" , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object>  updateUser(@Valid @RequestBody UserModel newUser) {
        return serviceUser.updUserWeb(newUser);
    }


    @ApiOperation(value = "Обновляем только свои данные из личного кабинета ")
    //Редактирование себя для юзеров
    @PreAuthorize("hasRole('USER')")
    @PostMapping(path  = "/slfUpdUser" , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object>  selfUpdateUser(@Valid @RequestBody UserModel newUser , Principal principal) {
        String username = principal.getName();
        return serviceUser.selfUpdUserWeb(username,  newUser);

    }




}
