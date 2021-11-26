package com.restaran.restaran.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "ingredient")
public class IngredientModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ingredient_id;

    @NotEmpty(message = "name не может быть пустым")
    @Size(min=2, message="name не может быть короче 2 символов")
    private String name;

    private int weight;
    private int number;
    private int price;
    private int calories;


    //@ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name="dishes_id", nullable=false)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "dishes_id"  , insertable = true )
    private DishesModel  dishes;


    public DishesModel getDishes() {
        return this.dishes;
    }

    public void setDishes(DishesModel employee) {
        this.dishes = employee;
    }


    public Long getIngredient_id() {
        return ingredient_id;
    }

    public void setIngredient_id(Long ingredient_id) {
        this.ingredient_id = ingredient_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
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


}
