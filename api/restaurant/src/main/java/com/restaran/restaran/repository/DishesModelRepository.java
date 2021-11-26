package com.restaran.restaran.repository;

import com.restaran.restaran.model.DishesModel;
import com.restaran.restaran.model.UserModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DishesModelRepository  extends CrudRepository<DishesModel, String> {

    DishesModel findByName(String name);

    @Query("select p from DishesModel p where dishes_Id = ?1 ")
    DishesModel findByDishesId(long dishes_Id);

    @Query("select count(p) = 1 from DishesModel p where name = ?1")
    boolean findExistByname(String name);
}
