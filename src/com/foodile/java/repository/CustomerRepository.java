package com.foodile.java.repository;

import com.foodile.java.model.Customers;
import com.foodile.java.util.CsvReader;

import java.util.List;

public class CustomerRepository {
    private List<Customers> customersList;

    public CustomerRepository() {
        CsvReader csvReader = new CsvReader();
        this.customersList = csvReader.readCsvFromCustomer();
    }
    public List<Customers> getAllCustomersList(){
        return this.customersList;
    }
    public Customers save(Customers customers){
        this.customersList.add(customers);
        return customers;
    }

}
