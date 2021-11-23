package com.restaran.restaran.controller;


import com.restaran.restaran.model.DishesModel;
import com.restaran.restaran.service.serviceinterface.IServiceDishesDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("dishes-rest")
public class DishesController {

    @Autowired
    private IServiceDishesDb serviceDishesDb;


    @GetMapping(value = "/getUser")
    public ResponseEntity<Object> getUser(@RequestParam long id ) {
        Iterable<DishesModel> all = serviceDishesDb.findAll();
        return null;
    }
}
