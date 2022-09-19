package com.example.restaurantapi.models;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Takeaway extends Bill {

    @Column(name = "delivery_fee")
    private boolean deliveryFee;

    public Takeaway(boolean deliveryFee) {
        this.deliveryFee = deliveryFee;
    }

    public Takeaway() {
    }

    public boolean isDeliveryFee() {
        return deliveryFee;
    }

    public void setDeliveryFee(boolean deliveryFee) {
        this.deliveryFee = deliveryFee;
    }
}
