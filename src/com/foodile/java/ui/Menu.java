package com.foodile.java.ui;

import com.foodile.java.controller.CustomerController;
import com.foodile.java.exceptions.CustomerExitsException;
import com.foodile.java.model.Customers;
import com.foodile.java.util.Factory;

import java.util.Scanner;

public class Menu {
    public void displayMainMenu(){
        Scanner sc=new Scanner(System.in);
        while (true){
            System.out.println("---------------------------------------------------------");
            System.out.println("                    WELCOME TO FOODIE APP                ");
            System.out.println("---------------------------------------------------------");

            System.out.println();
            System.out.println("Please select the option !");
            System.out.println("--------------------------");
            System.out.println("1. Register (New Customer)");
            System.out.println("2. Login (Existing Customer)");
            System.out.println("3. View Restaurants");
            System.out.println("4. View Menu");
            System.out.println("5. Place Order");
            System.out.println("6. View Orders");
            System.out.println("7. Exit");

            System.out.println("Please enter your chose (1-7)");

            int input=sc.nextInt();
            switch (input){
                case 1:
                    displayRegisterMenu();
                    break;
                default:
                    System.out.println("Invalid Input.Please enter the valid input from (1-7)");
            }
        }
    }
    private void displayRegisterMenu(){
        Scanner sc=new Scanner(System.in);
        System.out.println("please register entering the following details\n");
        System.out.println("Enter Id");
        String id=sc.nextLine();
        System.out.println("Enter Name");
        String name=sc.nextLine();
        System.out.println("Enter E-mail");
        String email=sc.nextLine();
        System.out.println("Enter Password");
        String password=sc.nextLine();
        Customers customers=new Customers();
        customers.setId(id);
        customers.setName(name);
        customers.setEmail(email);
        customers.setPassword(password);

       // CustomerRepository customerRepository=new CustomerRepository();
        //CustomerServiceImpl customerServiceImpl=new CustomerServiceImpl(customerRepository);
        //CustomerController customerController=new CustomerController(customerServiceImpl);
        CustomerController customerController=Factory.getCustomerController();

        try {
            Customers savedCustomer=customerController.save(customers);
            if(savedCustomer!=null) {
                System.out.println("Customer Register Successful");
                System.out.println("Details");
                System.out.println("Id: " + customers.getId());
                System.out.println("Name: " + customers.getName());
                System.out.println("E-mail: " + customers.getEmail());
                System.out.println("Password: " + customers.getPassword());
            }else {
                System.out.println("Some internal error Occurred , Please try again");
                displayRegisterMenu();

            }
        } catch (CustomerExitsException e) {
            System.out.println(e.getMessage());
            System.out.println("Please login using Main Menu");
            displayMainMenu();
        }
    }
}