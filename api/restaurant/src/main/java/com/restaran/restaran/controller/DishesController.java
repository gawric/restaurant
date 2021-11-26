package com.restaran.restaran.controller;


import com.restaran.restaran.model.DishesModel;
import com.restaran.restaran.model.UserModel;
import com.restaran.restaran.service.serviceinterface.IServiceDishes;
import com.restaran.restaran.service.serviceinterface.dbinterface.IServiceDishesDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("dishes-rest")
public class DishesController {

    @Autowired
    private IServiceDishes serviceDishes;


    @GetMapping(value = "/getDishes")
    public ResponseEntity<Object> getDishes(@RequestParam long id ) {

        return serviceDishes.findByIdTWeb(id);
    }


    @PostMapping(path  = "/addDishes" , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> createDidhes(@Valid @RequestBody DishesModel newDishes) {
        return serviceDishes.addDishesWeb(newDishes);
    }

    @PostMapping(path  = "/updDishes" , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> updDidhes(@Valid @RequestBody DishesModel newDishes) {
        return serviceDishes.updDishesWeb(newDishes);
    }

}
