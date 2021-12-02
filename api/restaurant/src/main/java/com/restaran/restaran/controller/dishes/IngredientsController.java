package com.restaran.restaran.controller.dishes;


import com.restaran.restaran.service.serviceinterface.IServiceIngredient;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ingredient-rest")
public class IngredientsController {

    @Autowired
    private IServiceIngredient serviceIngred;

    @ApiOperation(value = "Получаем все ингредиенты для добавления в новое блюдо")
    @GetMapping(value = "/getIngred")
    public ResponseEntity<Object> getIngredient() {
        return serviceIngred.getIngredWebAll();
    }

    //@PreAuthorize("hasRole('USER')")
    @GetMapping(value = "/delIngred")
    public ResponseEntity<Object> delIngredient(@RequestParam long id ) {
        return serviceIngred.delIngredWeb(id);
    }

}
