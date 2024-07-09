package com.foodile.java.service;

import com.foodile.java.exceptions.DishNotFoundException;
import com.foodile.java.exceptions.RestarantNotFoundException;
import com.foodile.java.exceptions.RestaurantExistsException;
import com.foodile.java.model.Dish;
import com.foodile.java.model.Restaurants;

import java.util.List;

public interface RestaurantService {
    public List<Restaurants> getRestaurantList();
    public Restaurants save(Restaurants restaurant) throws RestaurantExistsException;

    public Restaurants getRestaurantById(String id) throws RestarantNotFoundException;

    public Restaurants updateRestaurant(Restaurants restaurant) throws RestarantNotFoundException;
    public void deleteRestaurant(String id) throws RestarantNotFoundException;

    public List<Dish> getDishItems(String id) throws RestarantNotFoundException, DishNotFoundException;
}