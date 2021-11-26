package com.restaran.restaran.service.serviceinterface;

import com.restaran.restaran.model.DishesModel;
import com.restaran.restaran.model.UserModel;
import org.springframework.http.ResponseEntity;

public interface IServiceDishes {
    ResponseEntity<Object> addDishesWeb(DishesModel newDishes);
    ResponseEntity<Object> findByIdTWeb(long id);
    ResponseEntity<Object> updDishesWeb(DishesModel newDishes);

}
