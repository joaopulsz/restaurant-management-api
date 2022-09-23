package com.example.restaurantapi.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "restaurant")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "till")
    private double till;

    @OneToMany
    @JoinColumn(name = "bill_id")
    private List<Bill> closedBills;

    @OneToMany
    @JoinColumn(name = "bill_id")
    private List<Bill> openBills;

    public Restaurant() {
        this.till = 0.0;
        this.closedBills = new ArrayList<>();
        this.openBills = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getTill() {
        return till;
    }

    public void setTill(double till) {
        this.till = till;
    }

    public List<Bill> getClosedBills() {
        return closedBills;
    }

    public void setClosedBills(List<Bill> closedBills) {
        this.closedBills = closedBills;
    }

    public List<Bill> getOpenBills() {
        return openBills;
    }

    public void setOpenBills(List<Bill> openBills) {
        this.openBills = openBills;
    }

}
