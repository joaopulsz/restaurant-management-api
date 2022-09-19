package com.example.restaurantapi.repositories;

import com.example.restaurantapi.models.Dish;

import javax.transaction.Transactional;

@Transactional
public interface DishRepository extends MenuItemRepository<Dish> {
}
