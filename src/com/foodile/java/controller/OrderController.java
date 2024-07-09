package com.foodile.java.controller;

import com.foodile.java.exceptions.OrderExistsException;
import com.foodile.java.exceptions.OrderNotFoundException;
import com.foodile.java.model.Order;
import com.foodile.java.service.OrderServiceImpl;

import java.util.List;

public class OrderController {
    private OrderServiceImpl orderService;

    public OrderController(OrderServiceImpl orderService) {
        this.orderService = orderService;
    }

    public List<Order> getOrdersList(){
        return this.orderService.getOrdersList();
    }

    public Order getOrderById(String id) throws OrderNotFoundException {
        return this.orderService.getOrderById(id);
    }

    public Order saveOrder(Order order) throws OrderExistsException {
        return this.orderService.save(order);
    }
}
