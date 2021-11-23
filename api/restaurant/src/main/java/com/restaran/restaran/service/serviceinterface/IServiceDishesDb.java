package com.restaran.restaran.service.serviceinterface;

import com.restaran.restaran.model.DishesModel;

import java.util.List;

public interface IServiceDishesDb {

    Iterable<DishesModel> findAll();
}
