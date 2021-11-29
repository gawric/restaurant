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

    @Transactional(readOnly = true)
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

    @Transactional(readOnly = true)
    @Override
    public DishesModel findByName(String name) {
        return dishesRepo.findByName(name);
    }

    @Transactional(readOnly = true)
    @Override
    public DishesModel findByDishesId(long dishes_Id) {
        return dishesRepo.findByDishesId(dishes_Id);
    }

    @Override
    public boolean deleteByDishesId(long dishes_Id) {
        dishesRepo.deleteById(dishes_Id);
        return true;
    }

    @Override
    public boolean deleteByModel(DishesModel dishesm) {
        dishesRepo.delete(dishesm);
        return true;
    }


}
