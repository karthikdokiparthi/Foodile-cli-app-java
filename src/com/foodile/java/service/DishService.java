package com.foodile.java.service;

import com.foodile.java.exceptions.DishExistsException;
import com.foodile.java.exceptions.DishNotFoundException;
import com.foodile.java.model.Dish;

import java.util.List;

public interface DishService {
    public List<Dish> getDishesList();

    public Dish save(Dish dish) throws DishExistsException;
    public Dish getDishById(String id) throws DishNotFoundException;
    public Dish update(Dish dish) throws DishNotFoundException;

    public void delete(String id) throws DishNotFoundException;
}
