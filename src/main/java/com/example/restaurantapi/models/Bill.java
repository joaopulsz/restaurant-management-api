package com.example.restaurantapi.models;

import javax.persistence.*;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Inheritance
@Entity
@Table(name = "bills")
public abstract class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToMany
    @JoinTable(
            name = "bills_orders",
            joinColumns = {@JoinColumn(name = "bill_id", nullable = false)},
            inverseJoinColumns = {@JoinColumn(name = "menu_item_id", nullable = false)}
    )
    private List<MenuItem> orders;

    public Bill() {
        this.orders = new ArrayList<>();
    }

    public List<MenuItem> getOrders() {
        return orders;
    }

    public void setOrders(List<MenuItem> orders) {
        this.orders = orders;
    }
}
