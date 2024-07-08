package com.foodile.java.exceptions;


public class CustomerExistsException extends Exception{
    public CustomerExistsException(String message) {
        super(message);
    }
}
