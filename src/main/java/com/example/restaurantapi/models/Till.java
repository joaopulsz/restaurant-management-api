package com.example.restaurantapi.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity(name = "till")
public class Till {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "till_amount")
    private double tillAmount;

    @OneToMany
    @JoinColumn(name = "bill_id")
    private List<Bill> closedBills;

    @OneToMany
    @JoinColumn(name = "booking_id")
    private Map<String, Booking> bookings;

    public Till() {
        this.tillAmount = 0.0;
        this.closedBills = new ArrayList<>();
        this.bookings = new HashMap<>();
    }

    public double getTillAmount() {
        return tillAmount;
    }

    public void setTillAmount(double till) {
        this.tillAmount = till;
    }

    public List<Bill> getClosedBills() {
        return closedBills;
    }

    public void setClosedBills(List<Bill> closedBills) {
        this.closedBills = closedBills;
    }

    public Map<String, Booking> getBookings() {
        return bookings;
    }

    public void setBookings(Map<String, Booking> bookings) {
        this.bookings = bookings;
    }
}
