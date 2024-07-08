package com.foodile.java.exceptions;

public class DishNotFoundException extends Exception{
    public DishNotFoundException(String message) {
        super(message);
    }
}
