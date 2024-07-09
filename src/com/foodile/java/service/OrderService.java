package com.foodile.java.service;

import com.foodile.java.exceptions.OrderExistsException;
import com.foodile.java.exceptions.OrderNotFoundException;
import com.foodile.java.model.Order;

import java.util.List;

public interface OrderService {
    public List<Order> getOrdersList();
    public Order getOrderById(String id) throws OrderNotFoundException;
    public Order save(Order order) throws OrderExistsException;
}
