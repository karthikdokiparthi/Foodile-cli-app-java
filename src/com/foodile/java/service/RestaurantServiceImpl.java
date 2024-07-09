package com.foodile.java.service;

import com.foodile.java.exceptions.DishNotFoundException;
import com.foodile.java.exceptions.RestarantNotFoundException;
import com.foodile.java.exceptions.RestaurantExistsException;
import com.foodile.java.model.Dish;
import com.foodile.java.model.Restaurants;
import com.foodile.java.repository.RestaurantRepository;
import com.foodile.java.util.Factory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RestaurantServiceImpl implements RestaurantService{

    private final RestaurantRepository restaurantRepository;

    public RestaurantServiceImpl(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public List<Restaurants> getRestaurantList() {
        return this.restaurantRepository.getRestaurantList();
    }

    @Override
    public Restaurants save(Restaurants restaurant) throws RestaurantExistsException {
        Optional<Restaurants> restaurantById = this.restaurantRepository.findRestaurantById(restaurant.getId());
        if(restaurantById.isPresent())
            throw new RestaurantExistsException("Restaurant Already Exists with this Id  :" + restaurant.getId());
        return this.restaurantRepository.save(restaurant);
    }

    @Override
    public Restaurants getRestaurantById(String id) throws RestarantNotFoundException {
        Optional<Restaurants> restaurantById = this.restaurantRepository.findRestaurantById(id);
        if(restaurantById.isEmpty())
            throw new RestarantNotFoundException("Restaurant Not Found with this Id  :" + id);
        return restaurantById.get();

    }

    @Override
    public Restaurants updateRestaurant(Restaurants restaurant) throws RestarantNotFoundException {
        Optional<Restaurants> restaurantById = this.restaurantRepository.findRestaurantById(restaurant.getId());
        if(restaurantById.isEmpty())
            throw new RestarantNotFoundException("Restaurant Not Found with this Id  :" + restaurant.getId());
        return this.restaurantRepository.updateRetaurant(restaurant);
    }


    @Override
    public void deleteRestaurant(String id) throws RestarantNotFoundException {
        Optional<Restaurants> restaurantById = this.restaurantRepository.findRestaurantById(id);
        if(restaurantById.isEmpty())
            throw new RestarantNotFoundException("Restaurant Not Found with this Id  :" + id);
        this.restaurantRepository.deleteRestaurant(restaurantById.get());
    }

    @Override
    public List<Dish> getDishItems(String id) throws RestarantNotFoundException, DishNotFoundException {
        Optional<Restaurants> restaurantById = this.restaurantRepository.findRestaurantById(id);
        if(restaurantById.isEmpty())
            throw new RestarantNotFoundException("Restaurant Not Found with this Id  :" + id);
        List<Dish> dishList = new ArrayList<>();
        Restaurants restaurant = restaurantById.get();
        List<String> dishIds = restaurant.getMenu();
        DishService dishService = Factory.getDishService();
        for(String dishId : dishIds){
            Dish dish = dishService.getDishById(dishId);
            dishList.add(dish);
        }
        return dishList;
    }
}
