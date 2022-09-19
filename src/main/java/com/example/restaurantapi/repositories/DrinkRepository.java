package com.example.restaurantapi.repositories;

import com.example.restaurantapi.models.Drink;

import javax.transaction.Transactional;

@Transactional
public interface DrinkRepository extends MenuItemRepository<Drink> {
}
