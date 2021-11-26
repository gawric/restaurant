package com.restaran.restaran.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "dishes")
public class DishesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long dishes_id;

    @NotEmpty(message = "name не может быть пустым")
    @Size(min=2, message="name не может быть короче 2 символов")
    private String name;

    @OneToMany(targetEntity = IngredientModel.class , fetch = FetchType.EAGER,cascade = CascadeType.ALL ,orphanRemoval=true  , mappedBy="dishes")
    @Fetch(value = FetchMode.SUBSELECT)
    private List<IngredientModel> ingredient = new ArrayList<IngredientModel>();

    public List<IngredientModel> getIngredient() {
        return this.ingredient;
    }
    public void setIngredient( ArrayList<IngredientModel> ingredient) {
        this.ingredient = ingredient;
    }


    private int price;
    private int calories;
    private int weight;

    public Long getDishes_id() {
        return dishes_id;
    }

    public void setDishes_id(Long dishes_id) {
        this.dishes_id = dishes_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }



}
