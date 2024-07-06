package com.foodile.java.util;

import com.foodile.java.model.Customers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvReader {
        //Read the data from CSV files and create a List of objects

    String customerFilePath="D:\\TrainingHub\\Data Types\\foodile-cle-app-java\\data\\customers.csv";
    String line;
    List<Customers> customersList=new ArrayList<>();
    public List<Customers> readCsvFromCustomer(){
       try (BufferedReader br=new BufferedReader(new FileReader(customerFilePath))){
           String csvSplitBy=",";
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
}
