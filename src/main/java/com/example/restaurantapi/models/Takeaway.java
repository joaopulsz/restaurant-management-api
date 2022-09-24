package com.example.restaurantapi.models;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Takeaway extends Bill {

    @Column(name = "delivery_fee")
    private boolean deliveryFee;

    @Column(name = "is_closed")
    private boolean isClosed;

    public Takeaway(boolean deliveryFee) {
        this.deliveryFee = deliveryFee;
        this.isClosed = false;
    }

    public Takeaway() {
    }

    public boolean hasDeliveryFee() {
        return deliveryFee;
    }

    public void setDeliveryFee(boolean deliveryFee) {
        this.deliveryFee = deliveryFee;
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
        if (hasDeliveryFee()) {
            return total + 5;
        }
        return total;
    }
}
