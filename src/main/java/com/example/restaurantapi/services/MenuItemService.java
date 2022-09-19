package com.example.restaurantapi.services;

import com.example.restaurantapi.repositories.DishRepository;
import com.example.restaurantapi.repositories.DrinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuItemService {

    @Autowired
    DishRepository dishRepository;

    @Autowired
    DrinkRepository drinkRepository;



}
