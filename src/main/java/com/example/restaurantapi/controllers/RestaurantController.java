package com.example.restaurantapi.controllers;

import com.example.restaurantapi.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/restaurant")
public class RestaurantController {

    @Autowired
    RestaurantService restaurantService;
}
