package com.foodile.java.service;

import com.foodile.java.exceptions.CustomerExitsException;
import com.foodile.java.model.Customers;

public interface CustomerService {
    public Customers save(Customers customers) throws CustomerExitsException;
}
