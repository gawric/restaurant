package com.restaran.restaran;

import com.restaran.restaran.model.DishesModel;
import com.restaran.restaran.service.serviceinterface.dbinterface.IServiceDishesDb;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
class DishesDbTest {

	@Autowired
	private IServiceDishesDb serviceDishes;


	@DisplayName("Тест удаления Dishes из базы если мы не нашли в базе записи из Add просто игнорим")
	@Test
	void dishesDelete() {
		DishesModel addModel = serviceDishes.findByName("test name dishes");
		if(addModel != null)
		{
			boolean isdelete = serviceDishes.deleteByDishesId(addModel.getDishes_id());
			assertTrue(isdelete == true);
		}
		//assertTrue(addModel == null);
	}

	@DisplayName("Тест: Поиск  Dishes в базе")
	@Test
	void dishesGetItem() {
		DishesModel dishesModel = serviceDishes.findByDishesId(99);
		assertNull(dishesModel);
	}

	@DisplayName("Тест: Добавление записи в базу")
	@Test
	void dishesAddItem() {
		boolean dishesModel = serviceDishes.saveDishes(getModel());
	}

	private DishesModel getModel()
	{
		DishesModel model = new DishesModel();
		model.setDishes_id(9999l);
		model.setCalories(0);
		model.setName("test name dishes");
		model.setPrice(0);
		model.setWeight(0);

		return model;
	}
}
