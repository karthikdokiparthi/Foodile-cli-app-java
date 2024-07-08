package com.foodile.java.service;

import com.foodile.java.exceptions.DishExistsException;
import com.foodile.java.exceptions.DishNotFoundException;
import com.foodile.java.model.Dish;

import java.util.List;

public interface DishService {
    public List<Dish> getDishList();
    public Dish save(Dish dish) throws DishExistsException;
    public Dish getDishId(String id) throws DishNotFoundException;
}
