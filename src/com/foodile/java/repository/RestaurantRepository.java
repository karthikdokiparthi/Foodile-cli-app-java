package com.foodile.java.repository;

import com.foodile.java.model.Restaurants;
import com.foodile.java.util.Factory;

import java.util.List;
import java.util.Optional;

public class RestaurantRepository {
    private List<Restaurants> restaurantList;

    public RestaurantRepository() {
        this.restaurantList = Factory.getCsvReader().readCsvFromRestaurant();
    }

    public List<Restaurants> getRestaurantList(){
        return this.restaurantList;
    }

    public Restaurants save(Restaurants restaurant){ this.restaurantList.add(restaurant); return restaurant; }

    public Optional<Restaurants> findRestaurantById(String id) {
        return this.restaurantList.stream().filter(restaurant -> restaurant.getId().equals(id)).findFirst();
    }

    public Restaurants updateRetaurant(Restaurants restaurantToBeUpdated){
        Optional<Restaurants> restaurantOptional = this.restaurantList.stream().filter(restaurant -> restaurant.getId().equals(restaurantToBeUpdated.getId()))
                .findFirst()
                .map(restaurant -> {
                    restaurant.setName(restaurantToBeUpdated.getName());
                    restaurant.setAddress(restaurantToBeUpdated.getAddress());
                    restaurant.setMenu(restaurantToBeUpdated.getMenu());
                    return restaurant;
                });
        return restaurantOptional.orElse(null);
    }

    public void deleteRestaurant(Restaurants restaurant){
        this.restaurantList.remove(restaurant);
    }

}
