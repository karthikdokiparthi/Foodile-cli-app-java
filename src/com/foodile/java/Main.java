package com.foodile.java;

import com.foodile.java.util.CsvReader;

public class Main {
    public static void main(String[] args) {
        CsvReader csvReader = new CsvReader();
        System.out.println(csvReader.readCsvFromCustomer());
        System.out.println(csvReader.readCsvFromDish());
        System.out.println(csvReader.readCsvFromRestaurant());
    }
}