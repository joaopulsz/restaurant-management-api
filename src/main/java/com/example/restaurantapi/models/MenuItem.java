package com.example.restaurantapi.models;

import javax.persistence.*;
import javax.persistence.Table;

@Inheritance
@Entity
@Table(name = "menu_items")
public abstract class MenuItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Column
    private double price;

    public MenuItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public MenuItem() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
