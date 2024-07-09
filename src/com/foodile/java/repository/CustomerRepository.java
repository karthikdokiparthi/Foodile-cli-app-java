package com.foodile.java.repository;

import com.foodile.java.model.Customers;
import com.foodile.java.util.CsvReader;
import com.foodile.java.util.Factory;

import java.util.List;
import java.util.Optional;

public class CustomerRepository {
    List<Customers> customersList;

    public CustomerRepository() {
        this.customersList = Factory.getCsvReader().readCsvFromCustomer();
    }

    public List<Customers> getCustomersList() {
        return this.customersList;
    }

    public Customers saveCustomer(Customers customer) {
        this.customersList.add(customer);
        return customer;
    }

    public Optional<Customers> findCustomerById(String id) {
        return this.customersList.stream().filter(customer -> customer.getId().equals(id)).findFirst();
    }

    public Optional<Customers> findCustomerByEmail(String email){
        return this.customersList.stream().filter(customer -> customer.getEmail().equals(email)).findFirst();
    }

    public Customers updateCustomer(Customers customerToBeUpdated) {
        Optional<Customers> updateCustomer =  this.customersList.stream().filter(customer -> customer.getId().equals(customerToBeUpdated.getId()))
                .findFirst()
                .map(customer -> {
                    customer.setName(customerToBeUpdated.getName())
                            .setEmail(customerToBeUpdated.getEmail())
                            .setPassword(customerToBeUpdated.getPassword());

                    return customer;
                });
        return updateCustomer.orElse(null);

    }

    public void deleteCustomer(Customers customer){
        this.customersList.remove(customer);
    }

    public Optional<Customers> findByEmailAndPassword(String email, String password){
        return this.customersList.stream().filter(customer -> customer.getEmail().equalsIgnoreCase(email) && customer.getPassword().equals(password)).findFirst();
    }

}
