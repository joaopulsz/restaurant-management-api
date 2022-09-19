package com.example.restaurantapi.models;

import javax.persistence.*;

@Entity(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Column(name = "date_and_time")
    private String dateAndTime;

    @Column(name = "table_number")
    private int tableNumber;

    public Booking(String name, String dateAndTime, int tableNumber) {
        this.name = name;
        this.dateAndTime = dateAndTime;
        this.tableNumber = tableNumber;
    }

    public Booking() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(String dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }
}
