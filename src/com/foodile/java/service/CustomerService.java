package com.foodile.java.service;

import com.foodile.java.exceptions.CustomerExistsException;
import com.foodile.java.model.Customers;

public interface CustomerService {
    public Customers save(Customers customers) throws CustomerExistsException;
}
