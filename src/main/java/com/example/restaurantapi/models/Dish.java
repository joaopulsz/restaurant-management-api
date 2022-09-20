package com.example.restaurantapi.models;

import javax.persistence.Entity;

@Entity
public class Dish extends MenuItem {

    public Dish(String name, double price) {
        super(name, price);
    }

    public Dish() {
    }
}
