package com.foodile.java.exceptions;

public class CustomerNotFoundException extends Exception{
    public CustomerNotFoundException(String message) {
        super(message);
    }
}
