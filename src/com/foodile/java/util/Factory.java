package com.foodile.java.util;

import com.foodile.java.controller.CustomerController;
import com.foodile.java.repository.CustomerRepository;
import com.foodile.java.service.CustomerServiceImpl;

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

}
