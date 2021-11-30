package com.restaran.restaran.service.impl.ingredient;


import com.restaran.restaran.model.IngredientModel;
import com.restaran.restaran.service.serviceinterface.IServiceIngredient;
import com.restaran.restaran.service.serviceinterface.dbinterface.IServiceIngredientDb;
import com.restaran.restaran.variable.ErrorMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service("IServiceIngredient")
public class ServiceIngredient implements IServiceIngredient {

    @Autowired
    private IServiceIngredientDb serviceIngredDb;

    //Добавление проиходит при создании блюда
    //Через точку входа addDishes мы добавляем его ингредиенты в базу записывается блюдо и все его ингредиенты
    @Override
    public ResponseEntity<Object> delIngredWeb(long ingredient_id) {

        if(serviceIngredDb.deleteByDishesId(ingredient_id)) {
            return new ResponseEntity<>("Delete success ingredient id: "+ ingredient_id, HttpStatus.OK);
        }

        return ErrorMessage.getResponceErrorHttpStatus("Not found Ingredient exception", HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<Object> getIngredWebAll() {
       List<IngredientModel> allUniqList = serviceIngredDb.findByAllNameUniq();

        if(allUniqList != null) {
            List<IngredientModel> allUniqListClear  = clearIDient(allUniqList);
            return new ResponseEntity<>(allUniqListClear, HttpStatus.OK);
        }

        return ErrorMessage.getResponceErrorHttpStatus("Not found Ingredient exception", HttpStatus.NOT_FOUND);
    }

    private ArrayList<IngredientModel> clearIDient(List<IngredientModel> listIngDient)
    {
        ArrayList<IngredientModel> newList = (ArrayList<IngredientModel>) listIngDient.stream()
                .filter(Objects::nonNull)
                .peek(f -> f.setDishes(null))
                .collect(Collectors.toList());

        return newList;
    }
}
