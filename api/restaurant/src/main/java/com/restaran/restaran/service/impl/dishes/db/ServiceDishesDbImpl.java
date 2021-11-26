package com.restaran.restaran.service.impl.dishes.db;

import com.restaran.restaran.model.DishesModel;
import com.restaran.restaran.repository.DishesModelRepository;
import com.restaran.restaran.service.serviceinterface.dbinterface.IServiceDishesDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("IServiceDishesDb")
public class ServiceDishesDbImpl implements IServiceDishesDb {

    @Autowired
    private DishesModelRepository dishesRepo;

    @Override
    public Iterable<DishesModel> findAll() {
        return dishesRepo.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public boolean findExistByname(String name) {
        return  dishesRepo.findExistByname(name);
    }

    @Override
    public boolean saveDishes(DishesModel dishesm) {
        if(dishesm != null)
        {
            dishesRepo.save(dishesm);
            return true;
        }

        return false;
    }

    @Override
    public DishesModel findByName(String name) {
        return dishesRepo.findByName(name);
    }

    @Override
    public DishesModel findByDishesId(long dishes_Id) {
        return dishesRepo.findByDishesId(dishes_Id);
    }


}
