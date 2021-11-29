package com.restaran.restaran.service.impl.ingredient;

import com.restaran.restaran.model.IngredientModel;
import com.restaran.restaran.service.impl.ingredient.db.ServiceIngredientDbImpl;
import com.restaran.restaran.service.serviceinterface.IServiceIngredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("IServiceIngredient")
public class ServiceIngredient implements IServiceIngredient {

    @Autowired
    private ServiceIngredientDbImpl serviceIngredDb;


    @Override
    public ResponseEntity<Object> delIngredWeb(long dishes_id) {
        return null;
    }

    @Override
    public ResponseEntity<Object> getIngredWebAll() {
       List<IngredientModel> mpodel = serviceIngredDb.findByAllNameUniq();
        return null;
    }
}
