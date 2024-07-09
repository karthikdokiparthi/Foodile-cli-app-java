package com.foodile.java.util;

import com.foodile.java.controller.CustomerController;
import com.foodile.java.controller.DishController;
import com.foodile.java.repository.CustomerRepository;
import com.foodile.java.repository.DishRepository;
import com.foodile.java.service.CustomerServiceImpl;
import com.foodile.java.service.DishServiceImpl;

public class Factory {
    public static CustomerRepository getCustomerRepository(){
        return new CustomerRepository();
    }
    public static CustomerServiceImpl getCustomerServiceImpl(){
        return new CustomerServiceImpl(getCustomerRepository());
    }
    public static CustomerController getCustomerController(){
        return new CustomerController(getCustomerServiceImpl());
    }
    public static DishRepository getDishRepository(){
        return new DishRepository();
    }
    public static DishServiceImpl getDishServiceImpl(){
        return new DishServiceImpl(getDishRepository());
    }
    public static DishController getDishController(){
        return new DishController(getDishServiceImpl());
    }


}
