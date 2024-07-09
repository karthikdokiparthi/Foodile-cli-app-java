package com.foodile.java.ui;

import com.foodile.java.controller.CustomerController;
import com.foodile.java.controller.DishController;
import com.foodile.java.exceptions.CustomerExistsException;
import com.foodile.java.model.Customers;
import com.foodile.java.model.Dish;
import com.foodile.java.util.Factory;

import java.util.List;
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
            System.out.println("4. View Dish Menu");
            System.out.println("5. Place Order");
            System.out.println("6. View Orders");
            System.out.println("7. Exit");

            System.out.println("Please enter your chose (1-7)");

            int input=sc.nextInt();
            switch (input){
                case 1:
                    displayRegisterMenu();
                    break;
                case 4:
                    displayDishesList();
                    break;
                case 7:
                    System.out.println("Thank you using Foodie app, See you again");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Input.Please enter the valid input from (1-7)");

            }
        }
    }

    private void displayDishesList() {
        DishController dishController=Factory.getDishController();
        //System.out.println(dishController.getDishesList());
        List<Dish> dishList=dishController.getDishesList();
        String dashesLine = new String(new char[150]).replace('\0','-');
        displayMenuHeader("Menu Items");
        System.out.printf("%-10s %-30s %-80s %-10s\n","Id","Name","Description","Price");
        System.out.println(dashesLine);
        dishList.forEach(dish -> {
            System.out.printf("%-10s %-30s %-80s %-10s\n",dish.getId(),dish.getName(),dish.getDescription(),String.format("$%.2f",dish.getPrice()));
        });

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
        } catch (CustomerExistsException e) {
            System.out.println(e.getMessage());
            System.out.println("Please login using Main Menu");
            displayMainMenu();
        }
    }
    public void displayMenuHeader(String menuHeader){
        String dashesLine=new String(new char[150]).replace('\0','-');
        System.out.println(dashesLine);
        String spaces=new String(new char[70]).replace('\0',' ');
        System.out.printf("%-70s %-10s %-70s \n",spaces,menuHeader,spaces);
        System.out.println(dashesLine);
    }
}
