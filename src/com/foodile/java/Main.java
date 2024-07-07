package com.foodile.java;

import com.foodile.java.repository.CustomerRepository;
import com.foodile.java.util.CsvReader;

public class Main {
    public static void main(String[] args) {
        CustomerRepository customerRepository=new CustomerRepository();
        System.out.println(customerRepository.getAllCustomersList());
    }
}