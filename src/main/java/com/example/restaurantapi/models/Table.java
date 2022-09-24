package com.example.restaurantapi.models;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Table extends Bill {

    @Column
    private int number;

    @Column
    private int seats;

    @Column(name = "service_charge")
    private boolean serviceCharge;

    @Column(name = "is_closed")
    private boolean isClosed;

    public Table(int number, int seats, boolean serviceCharge) {
        this.number = number;
        this.seats = seats;
        this.serviceCharge = serviceCharge;
        this.isClosed = false;
    }

    public Table() {
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public boolean hasServiceCharge() {
        return serviceCharge;
    }

    public void setServiceCharge(boolean booked) {
        serviceCharge = booked;
    }

    public boolean isClosed() {
        return isClosed;
    }

    public void setClosed(boolean closed) {
        isClosed = closed;
    }

    public double getTotalAmountToPay() {
        double total = 0;
        for (MenuItem order : this.getOrders()) {
            total += order.getPrice();
        }
        if (hasServiceCharge()) {
            return total + total / 10;
        }
        return total;
    }
}
