package com.example.restaurantapi.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity(name = "restaurant")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "till")
    private double till;

    @OneToMany
    @JoinColumn(name = "restaurant_menu")
    private List<MenuItem> menu;

    @OneToMany
    @JoinColumn(name = "bill_id")
    private List<Bill> closedBills;

    @OneToMany
    @JoinColumn(name = "bill_id")
    private List<Bill> openBills;

    @OneToMany
    @JoinColumn(name = "booking_id")
    private Map<String, Booking> bookings;

    public Restaurant() {
        this.till = 0.0;
        this.menu = new ArrayList<>();
        this.closedBills = new ArrayList<>();
        this.openBills = new ArrayList<>();
        this.bookings = new HashMap<>();
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

    public List<MenuItem> getMenu() {
        return menu;
    }

    public void setMenu(List<MenuItem> menu) {
        this.menu = menu;
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

    public Map<String, Booking> getBookings() {
        return bookings;
    }

    public void setBookings(Map<String, Booking> bookings) {
        this.bookings = bookings;
    }
}
