package com.foodile.java.model;

import java.util.List;
import java.util.Objects;

public class Order {

    private String id;
    private String customer;
    private List<String> dish;
    private String restaurants;
    private double price;

    public Order() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public List<String> getDish() {
        return dish;
    }

    public void setDish(List<String> dish) {
        this.dish = dish;
    }

    public String getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(String restaurants) {
        this.restaurants = restaurants;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Order order = (Order) obj;
        return Double.compare(price, order.price) == 0 && Objects.equals(id, order.id) && Objects.equals(customer, order.customer) && Objects.equals(dish, order.dish) && Objects.equals(restaurants, order.restaurants);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customer, dish, restaurants, price);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", customer='" + customer + '\'' +
                ", dish=" + dish +
                ", restaurants='" + restaurants + '\'' +
                ", price=" + price +
                '}';
    }
}
