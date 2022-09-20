package com.example.restaurantapi.models;

import javax.persistence.Entity;

@Entity
public class Drink extends MenuItem {

    public Drink(String name, double price) {
        super(name, price);
    }

    public Drink() {
    }
}
