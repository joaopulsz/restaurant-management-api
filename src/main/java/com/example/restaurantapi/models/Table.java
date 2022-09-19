package com.example.restaurantapi.models;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Table extends Bill {

    @Column
    private int number;

    @Column
    private int seats;

    @Column(name = "is_booked")
    private boolean isBooked;

    public Table(int number, int seats, boolean isBooked) {
        this.number = number;
        this.seats = seats;
        this.isBooked = isBooked;
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

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }
}
