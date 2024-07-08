package com.foodile.java.service;

import com.foodile.java.exceptions.DishExitsException;
import com.foodile.java.exceptions.DishNotFoundException;
import com.foodile.java.model.Dish;

import java.util.List;

public interface DishService {
    public List<Dish> getDishList();
    public Dish save(Dish dish) throws DishExitsException;
    public Dish getDishId(String id) throws DishNotFoundException;
}
