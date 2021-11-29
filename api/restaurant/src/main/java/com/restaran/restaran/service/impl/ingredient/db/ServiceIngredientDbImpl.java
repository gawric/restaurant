package com.restaran.restaran.service.impl.ingredient.db;

import com.restaran.restaran.model.IngredientModel;
import com.restaran.restaran.repository.IngredientModelRepository;
import com.restaran.restaran.service.serviceinterface.dbinterface.IServiceIngredientDb;
import com.restaran.restaran.service.serviceinterface.dbinterface.IServiceUserDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service("IServiceIngredientDb")
public class ServiceIngredientDbImpl implements IServiceIngredientDb {

    @Autowired
    private IngredientModelRepository repoIngredient;

    @Override
    public boolean deleteByDishesId(long id) {
        repoIngredient.deleteByDishesId(id);
        return true;
    }

    @Override
    public ArrayList<IngredientModel> findAll() {
        Iterable<IngredientModel> allModel = repoIngredient.findAll();
        return null;
    }

    @Override
    public List<IngredientModel> findByAllNameUniq() {
        return repoIngredient.findByAllNameUniq();

    }
}
