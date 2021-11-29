package com.restaran.restaran.service.serviceinterface;

import org.springframework.http.ResponseEntity;

public interface IServiceIngredient {
    ResponseEntity<Object> delIngredWeb(long dishes_id);
    ResponseEntity<Object> getIngredWebAll();
}
