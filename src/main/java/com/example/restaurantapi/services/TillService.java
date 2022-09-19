package com.example.restaurantapi.services;

import com.example.restaurantapi.repositories.TillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TillService {

    @Autowired
    TillRepository tillRepository;


}
