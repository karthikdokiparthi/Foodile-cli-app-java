package com.foodile.java.util;

import com.foodile.java.model.Customers;
import com.foodile.java.model.Dish;
import com.foodile.java.model.Restaurants;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CsvReader {
        //Read the data from CSV files and create a List of objects

    String customerFilePath="D:\\TrainingHub\\Data Types\\foodile-cle-app-java\\data\\customers.csv";
    String line;
    String csvSplitBy=",";
    List<Customers> customersList=new ArrayList<>();
    public List<Customers> readCsvFromCustomer(){
       try (BufferedReader br=new BufferedReader(new FileReader(customerFilePath))){
           br.readLine();
           while ((line = br.readLine()) != null){
               String[] data = line.split(csvSplitBy);
               Customers customer =new Customers();
               customer.setId(data[0]);
               customer.setName(data[1]);
               customer.setEmail(data[2]);
               customer.setPassword(data[3]);

               customersList.add(customer);
           }
       }catch (IOException e){
           System.out.println("File not found in the specified path");
           System.exit(0);
       };
       return customersList;
    }

    List<Dish> dishList = new ArrayList<>();
    String dishFilePath="D:\\TrainingHub\\Data Types\\foodile-cle-app-java\\data\\dishes.csv";
    public List<Dish> readCsvFromDish(){
        try (BufferedReader br=new BufferedReader(new FileReader(dishFilePath))){
            br.readLine();
            while ((line = br.readLine()) != null){
                String[] data= line.split(csvSplitBy);
                Dish dish=new Dish();
                dish.setId(data[0]);
                dish.setName(data[1]);
                dish.setDescription(data[2]);
                dish.setPrice(Double.parseDouble(data[3]));
                dishList.add(dish);
            }

        }catch(IOException e){
            System.out.println("File not found in the specified path");
            System.exit(0);
        }

        return dishList;
    }

    List<Restaurants> restaurantList = new ArrayList<>();
    String restaurantFilePath="D:\\TrainingHub\\Data Types\\foodile-cle-app-java\\data\\restaurants.csv";
    public List<Restaurants> readCsvFromRestaurant(){
        try (BufferedReader br=new BufferedReader(new FileReader(restaurantFilePath))){
            br.readLine();
            while ((line = br.readLine()) != null){
                String[] data= line.split(csvSplitBy);
                Restaurants restaurant=new Restaurants();
                restaurant.setId(data[0]);
                restaurant.setName(data[1]);
                restaurant.setAddress(data[2]);
                restaurant.setMenu(Collections.singletonList(data[3]));
                restaurantList.add(restaurant);
            }

        }catch(IOException e){
            System.out.println("File not found in the specified path");
            System.exit(0);
        }

        return restaurantList;
    }
}
