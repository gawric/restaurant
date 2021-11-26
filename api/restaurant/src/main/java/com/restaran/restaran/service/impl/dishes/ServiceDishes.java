package com.restaran.restaran.service.impl.dishes;


import com.restaran.restaran.exception.IncorrectUserNameException;
import com.restaran.restaran.exception.NotFoundUserException;
import com.restaran.restaran.model.DishesModel;
import com.restaran.restaran.model.IngredientModel;
import com.restaran.restaran.model.UserModel;
import com.restaran.restaran.service.serviceinterface.IServiceDishes;
import com.restaran.restaran.service.serviceinterface.dbinterface.IServiceDishesDb;
import com.restaran.restaran.variable.ErrorMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service("IServiceUser)")
public class ServiceDishes implements IServiceDishes {

    //работа с базой
    @Autowired
    private IServiceDishesDb serviceDishesDb;



    //медленное добавление для вебки
    @Override
    public ResponseEntity<Object> addDishesWeb(DishesModel newDishes) {


        try
        {
            sNull(newDishes);
            if(serviceDishesDb.findExistByname(newDishes.getName())) throw new IncorrectUserNameException("Dishesname already in use");
            newDishes.setIngredient(addDidToIDient(newDishes.getIngredient() , newDishes));
            if(serviceDishesDb.saveDishes(newDishes)) return new ResponseEntity("Succes save Dishes" , HttpStatus.OK);
        }
        catch (IncorrectUserNameException e)
        {
            e.printStackTrace();
            return ErrorMessage.getResponceError("Dishesname already in use");
        }
        catch (NotFoundUserException e)
        {
            e.printStackTrace();
            return ErrorMessage.getResponceError("Dishesname found user exception");
        }


        return ErrorMessage.getResponceError("Dishes Unknown error");
    }

    @Override
    public ResponseEntity<Object> findByIdTWeb(long id) {
        try
        {
            DishesModel dModel = serviceDishesDb.findByDishesId(id);
            dModel.setIngredient(clearIDient(dModel.getIngredient(), dModel));
            sNull(dModel);
            return new ResponseEntity<>(dModel, HttpStatus.OK);
        }catch (NotFoundUserException ex)
        {
            ex.printStackTrace();
            return ErrorMessage.getResponceErrorHttpStatus("Not found dishes exception", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<Object> updDishesWeb(DishesModel newDishes) {
        try
        {
            //проверка что указан id номер
            sNullId(newDishes);

            DishesModel user = serviceDishesDb.findByDishesId(newDishes.getDishes_id());
            sNull(newDishes);

            newDishes.setIngredient(addDidToIDient(newDishes.getIngredient() , newDishes));

            serviceDishesDb.saveDishes(newDishes);

            newDishes.setIngredient(clearIDient(newDishes.getIngredient(), newDishes));
            return new ResponseEntity<>(newDishes, HttpStatus.OK);
        }
        catch (NotFoundUserException ex)
        {
            ex.printStackTrace();
            return ErrorMessage.getResponceErrorHttpStatus("Not found user exception", HttpStatus.NOT_FOUND);
        }
    }

    private ArrayList<IngredientModel> addDidToIDient(List<IngredientModel> listIngDient , DishesModel dishesModel)
    {
        ArrayList<IngredientModel> newList = (ArrayList<IngredientModel>) listIngDient.stream()
                .filter(Objects::nonNull)
                .peek(f -> f.setDishes(dishesModel))
                .collect(Collectors.toList());

        return newList;
    }

    private ArrayList<IngredientModel> clearIDient(List<IngredientModel> listIngDient , DishesModel dishesModel)
    {
        ArrayList<IngredientModel> newList = (ArrayList<IngredientModel>) listIngDient.stream()
                .filter(Objects::nonNull)
                .peek(f -> f.setDishes(null))
                .collect(Collectors.toList());

        return newList;
    }

    private void sNull(DishesModel newDishes) throws NotFoundUserException {
        if(newDishes == null) throw new NotFoundUserException("Not found user exception");
    }

    private void sNullId(DishesModel newDishes) throws NotFoundUserException {
        if(newDishes.getDishes_id() == null) throw new NotFoundUserException("id number not defined");
    }


}
