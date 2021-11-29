package com.restaran.restaran.service.serviceinterface.dbinterface;

import com.restaran.restaran.model.IngredientModel;

import java.util.List;

public interface IServiceIngredientDb {
    boolean deleteByDishesId(long id);
    List<IngredientModel> findAll();
    List<IngredientModel> findByAllNameUniq();
}
