package com.example.restaurantapi.services;

import com.example.restaurantapi.models.Bill;
import com.example.restaurantapi.models.Booking;
import com.example.restaurantapi.models.MenuItem;
import com.example.restaurantapi.repositories.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class RestaurantService {

    @Autowired
    RestaurantRepository restaurantRepository;

    public double getTillAmount() {
        return restaurantRepository.findById(1).get().getTill();
    }

    public List<Bill> getClosedBills() {
        return restaurantRepository.findById(1).get().getClosedBills();
    }

    public List<Bill> getOpenBills() {
        return restaurantRepository.findById(1).get().getOpenBills();
    }

}
