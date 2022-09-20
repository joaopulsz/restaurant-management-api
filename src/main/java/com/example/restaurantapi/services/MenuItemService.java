package com.example.restaurantapi.services;

import com.example.restaurantapi.models.Dish;
import com.example.restaurantapi.models.Drink;
import com.example.restaurantapi.repositories.DishRepository;
import com.example.restaurantapi.repositories.DrinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MenuItemService {

    @Autowired
    DishRepository dishRepository;

    @Autowired
    DrinkRepository drinkRepository;

    public List<Dish> getAllDishes() {
        return dishRepository.findAll();
    }

    public List<Drink> getAllDrinks() {
        return drinkRepository.findAll();
    }

    public Optional<Dish> getDishById(int id) {
        return dishRepository.findById(id);
    }

    public Optional<Drink> getDrinkById(int id) {
        return drinkRepository.findById(id);
    }

    public Dish addDish(Dish dish) {
        dishRepository.save(dish);
        return dish;
    }

    public Drink addDrink(Drink drink) {
        drinkRepository.save(drink);
        return drink;
    }

    public boolean removeDishById(int id) {
        Optional<Dish> dishToRemove = dishRepository.findById(id);
        if (dishToRemove.isPresent()) {
            dishRepository.delete(dishRepository.findById(id).get());
            return true;
        }
        return false;

    }

    public boolean removeDrinkById(int id) {
        Optional<Drink> drinkToRemove = drinkRepository.findById(id);
        if (drinkToRemove.isPresent()) {
            drinkRepository.delete(drinkRepository.findById(id).get());
            return true;
        }
        return false;

    }

}
