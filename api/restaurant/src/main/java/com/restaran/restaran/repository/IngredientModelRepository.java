package com.restaran.restaran.repository;

import com.restaran.restaran.model.DishesModel;
import com.restaran.restaran.model.IngredientModel;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IngredientModelRepository  extends CrudRepository<IngredientModel, Long> {

    @Modifying
    @Query("delete from IngredientModel i where i.dishes.dishes_id = ?1 ")
    void deleteByDishesId(long ingredient_id);

    @Query(value = "select distinct on (name) * from ingredient order by name" , nativeQuery = true)
    List<IngredientModel> findByAllNameUniq();
}
