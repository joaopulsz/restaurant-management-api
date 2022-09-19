package com.example.restaurantapi.services;

import com.example.restaurantapi.repositories.TableRepository;
import com.example.restaurantapi.repositories.TakeawayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillService {

    @Autowired
    TableRepository tableRepository;

    @Autowired
    TakeawayRepository takeawayRepository;
}
