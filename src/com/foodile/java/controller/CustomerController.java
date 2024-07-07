package com.foodile.java.controller;

import com.foodile.java.exceptions.CustomerExitsException;
import com.foodile.java.model.Customers;
import com.foodile.java.service.CustomerServiceImpl;

public class CustomerController {
    private CustomerServiceImpl customerService;

    public CustomerController(CustomerServiceImpl customerService) {
        this.customerService = customerService;
    }

    public Customers save(Customers customers) throws CustomerExitsException{
        return this.customerService.save(customers);
    }
}
