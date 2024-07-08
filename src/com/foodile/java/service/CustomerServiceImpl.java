package com.foodile.java.service;

import com.foodile.java.exceptions.CustomerExitsException;
import com.foodile.java.model.Customers;
import com.foodile.java.repository.CustomerRepository;

import java.util.Optional;

public class CustomerServiceImpl implements CustomerService{
    private CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository){
        this.customerRepository=customerRepository;
    }

    @Override
    public Customers save(Customers customers) throws CustomerExitsException {

        Optional<Customers> customerById = this.customerRepository.findCustomerById(customers.getId(),customers.getEmail());
        if(customerById.isPresent()) throw new CustomerExitsException("Customer already Exits with this id or Email : "+ customers.getId()+" "+customers.getEmail());
        return this.customerRepository.save(customers);
    }
}
