package com.foodile.java.repository;

import com.foodile.java.model.Dish;
import com.foodile.java.util.CsvReader;

import java.util.List;
import java.util.Optional;

public class DishRepository {
    private List<Dish> dishList;

    public DishRepository() {
        CsvReader csvReader = new CsvReader();
        this.dishList = csvReader.readCsvFromDish();
    }
    public List<Dish> getDishList(){
        return this.dishList;
    }
    public Dish saveDish(Dish dish){
        this.dishList.add(dish);
        return dish;
    }
    public Optional<Dish> findDishById(String id){
        return this.dishList.stream().filter(customers -> customers.getId().equals(id)).findFirst();
    }
}
