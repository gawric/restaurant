package com.restaran.restaran.service.serviceinterface;

import com.restaran.restaran.model.DishesModel;
import com.restaran.restaran.model.FaqModel;
import org.springframework.http.ResponseEntity;

public interface IServiceFaq {

    ResponseEntity<Object> addFaqWeb(FaqModel fModel);
    ResponseEntity<Object> delFaqWeb(long faq_id);
    ResponseEntity<Object> delFaqThemeWeb(String themeName);
    ResponseEntity<Object> findByIdWeb(long faq_id);
    ResponseEntity<Object> findByThemeWeb(String themeName);
    ResponseEntity<Object> findByThemeWebPages(String themeName , int pages);
    ResponseEntity<Object> updFaqWeb(FaqModel fmodel);
}
