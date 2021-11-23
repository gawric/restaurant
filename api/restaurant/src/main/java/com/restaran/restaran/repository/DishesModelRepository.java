package com.restaran.restaran.repository;

import com.restaran.restaran.model.DishesModel;
import com.restaran.restaran.model.UserModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DishesModelRepository  extends CrudRepository<DishesModel, String> {
}
