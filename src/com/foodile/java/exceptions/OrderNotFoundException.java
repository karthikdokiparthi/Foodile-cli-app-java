package com.foodile.java.exceptions;

public class OrderNotFoundException extends Exception{
    public OrderNotFoundException(String message) {
        super(message);
    }
}
