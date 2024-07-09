package com.foodile.java.controller;

import com.foodile.java.exceptions.RestarantNotFoundException;
import com.foodile.java.exceptions.RestaurantExistsException;
import com.foodile.java.model.Restaurants;
import com.foodile.java.service.RestaurantServiceImpl;

import java.util.List;

public class RestaurantController {
    private final RestaurantServiceImpl restaurantService;

    public RestaurantController(RestaurantServiceImpl restaurantService) {
        this.restaurantService = restaurantService;
    }

    public List<Restaurants> getRestaurantList(){
        return this.restaurantService.getRestaurantList();
    }

    public Restaurants saveRestaurant(Restaurants restaurant) throws RestaurantExistsException {
        return this.restaurantService.save(restaurant);
    }

    public Restaurants getRestaurantById(String id) throws RestarantNotFoundException {
        return this.restaurantService.getRestaurantById(id);
    }

    public Restaurants updateRestaurant(Restaurants restaurant) throws RestarantNotFoundException{
        return this.restaurantService.updateRestaurant(restaurant);
    }

    public void deleteRestaurant(String id) throws RestarantNotFoundException {
        this.restaurantService.deleteRestaurant(id);
    }
}
