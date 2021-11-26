package com.restaran.restaran.service.serviceinterface.dbinterface;

import com.restaran.restaran.model.DishesModel;
import com.restaran.restaran.model.UserModel;

import java.util.List;

public interface IServiceDishesDb {

    Iterable<DishesModel> findAll();
    boolean findExistByname(String name);
    boolean saveDishes(DishesModel dishesm);
    DishesModel findByName(String name);
    DishesModel findByDishesId(long dishes_Id);
}
