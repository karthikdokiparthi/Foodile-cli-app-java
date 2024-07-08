package com.foodile.java.controller;

import com.foodile.java.model.Dish;
import com.foodile.java.service.DishServiceImpl;

import java.util.List;

public class DishController {
    private DishServiceImpl dishService;

    public DishController(DishServiceImpl dishService) {
        this.dishService = dishService;
    }

    public List<Dish> getDishesList(){
        return this.dishService.getDishList();
    }
}
