package com.foodile.java.model;

import java.util.List;
import java.util.Objects;

public class Restaurants {
    private String id;
    private String name;
    private String address;
    private List<String> menu;

    public Restaurants() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<String> getMenu() {
        return menu;
    }

    public void setMenu(List<String> menu) {
        this.menu = menu;
    }

    @Override
    public boolean equals(Object obj){
        if (this ==obj)return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Restaurants restaurant = (Restaurants) obj;
        return Objects.equals(id, restaurant.id) && Objects.equals(name, restaurant.name) && Objects.equals(address,restaurant.address) && Objects.equals(menu, restaurant.menu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address, menu);
    }

    @Override
    public String toString() {
        return "Restaurants{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", menu=" + menu +
                '}';
    }
}