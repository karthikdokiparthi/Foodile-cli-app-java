package com.foodile.java.service;

import com.foodile.java.exceptions.CustomerExistsException;
import com.foodile.java.model.Customers;
import com.foodile.java.repository.CustomerRepository;

import java.util.Optional;

public class CustomerServiceImpl implements CustomerService{
    private CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository){
        this.customerRepository=customerRepository;
    }

    @Override
    public Customers save(Customers customers) throws CustomerExistsException {

        Optional<Customers> customerById = this.customerRepository.findCustomerById(customers.getId());
        if(customerById.isPresent()) throw new CustomerExistsException("Customer already Exits with this id : "+ customers.getId());
        return this.customerRepository.save(customers);
    }
}
