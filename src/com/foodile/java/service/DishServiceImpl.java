package com.foodile.java.service;

import com.foodile.java.exceptions.DishExistsException;
import com.foodile.java.exceptions.DishNotFoundException;
import com.foodile.java.model.Customers;
import com.foodile.java.model.Dish;
import com.foodile.java.repository.DishRepository;

import java.util.List;
import java.util.Optional;

public class DishServiceImpl implements DishService {

    private DishRepository dishRepository;

    public DishServiceImpl(DishRepository dishRepository){
        this.dishRepository=dishRepository;
    }

    @Override
    public List<Dish> getDishList() {
        return this.dishRepository.getDishList();
    }

    @Override
    public Dish save(Dish dish) throws DishExistsException {
        Optional<Dish> dishById = this.dishRepository.findDishById(dish.getId());
        if(dishById.isPresent()) throw new DishExistsException("Dish already Exits with this id : "+ dish.getId());
        return this.dishRepository.saveDish(dish);
    }

    @Override
    public Dish getDishId(String id) throws DishNotFoundException {
        Optional<Dish> dishById=this.dishRepository.findDishById(id);
        if(!dishById.isPresent())
            throw new DishNotFoundException("Dish not found with this id: "+id);
        return dishById.get();
    }
}
