package com.restaran.restaran.service.impl.dishes;

import com.restaran.restaran.model.DishesModel;
import com.restaran.restaran.repository.DishesModelRepository;
import com.restaran.restaran.service.serviceinterface.IServiceDishesDb;
import com.restaran.restaran.service.serviceinterface.IServiceUserDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service("IServiceDishesDb")
public class ServiceDishesDbImpl implements IServiceDishesDb {

    @Autowired
    private DishesModelRepository dishesRepo;

    @Override
    public Iterable<DishesModel> findAll() {
        return dishesRepo.findAll();
    }
}
