package com.restaran.restaran.controller.dishes;

import com.restaran.restaran.model.DishesModel;
import com.restaran.restaran.service.serviceinterface.IServiceDishes;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequestMapping("dishes-rest")
public class DishesController {

    @Autowired
    private IServiceDishes serviceDishes;

    @ApiOperation(value = "Получаем нужное на блюдо чере GET запрос с его id номером ")
    @PreAuthorize("hasRole('USER')")
    @GetMapping(value = "/getDishes")
    public ResponseEntity<Object> getDishes(@RequestParam long id ) {
        return serviceDishes.findByIdTWeb(id);
    }


    @ApiOperation(value = "Добавляем блюдо и его ингредиенты ")
    @PreAuthorize("hasRole('USER')")
    @PostMapping(path  = "/addDishes" , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> createDidhes(@Valid @RequestBody DishesModel newDishes) {
        return serviceDishes.addDishesWeb(newDishes);
    }


    @PreAuthorize("hasRole('USER')")
    @PostMapping(path  = "/updDishes" , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> updDidhes(@Valid @RequestBody DishesModel newDishes) {
        return serviceDishes.updDishesWeb(newDishes);
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping(value = "/delDishes")
    public ResponseEntity<Object> delDishes(@RequestParam long id ) {
        return serviceDishes.delDishesWeb(id);
    }

}
