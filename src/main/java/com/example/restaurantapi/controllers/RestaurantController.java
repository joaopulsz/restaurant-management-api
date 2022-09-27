package com.example.restaurantapi.controllers;

import com.example.restaurantapi.models.Bill;
import com.example.restaurantapi.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/restaurant")
public class RestaurantController {

    @Autowired
    RestaurantService restaurantService;

    @GetMapping(value = "/till")
    public ResponseEntity<Double> getTillAmount() {
        return new ResponseEntity<>(restaurantService.getTillAmount(), HttpStatus.OK);
    }

    @GetMapping(value = "/closed-bills")
    public ResponseEntity<List<Bill>> getClosedBills() {
        return new ResponseEntity<>(restaurantService.getClosedBills(), HttpStatus.OK);
    }
}
