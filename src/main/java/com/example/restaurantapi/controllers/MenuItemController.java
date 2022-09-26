package com.example.restaurantapi.controllers;

import com.example.restaurantapi.models.Dish;
import com.example.restaurantapi.models.Drink;
import com.example.restaurantapi.services.MenuItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/menuitems")
public class MenuItemController {

    @Autowired
    MenuItemService menuItemService;

    @GetMapping(value = "/dishes")
    public ResponseEntity<List<Dish>> getAllDishes() {
        return  new ResponseEntity<>(menuItemService.getAllDishes(), HttpStatus.OK);
    }

    @GetMapping(value = "/drinks")
    public ResponseEntity<List<Drink>> getAllDrinks() {
        return new ResponseEntity<>(menuItemService.getAllDrinks(), HttpStatus.OK);
    }

    @GetMapping(value = "/dishes/{id}")
    public ResponseEntity<Dish> getDishById(@PathVariable int id) {
        Optional<Dish> dish = menuItemService.getDishById(id);
        return dish.isPresent() ? new ResponseEntity<>(dish.get(), HttpStatus.OK) : new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/drinks/{id}")
    public ResponseEntity<Drink> getDrinkById(@PathVariable int id) {
        Optional<Drink> drink = menuItemService.getDrinkById(id);
        return drink.isPresent() ? new ResponseEntity<>(drink.get(), HttpStatus.OK) : new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/dishes")
    public ResponseEntity<Dish> addDish(@RequestBody Dish dish) {
        return new ResponseEntity<>(menuItemService.addDish(dish),HttpStatus.CREATED);
    }

    @PostMapping(value = "/drinks")
    public ResponseEntity<Drink> addDrink(@RequestBody Drink drink) {
        return new ResponseEntity<>(menuItemService.addDrink(drink), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/dishes/{id}")
    public ResponseEntity<String> removeDishById(@PathVariable int id) {
        return menuItemService.removeDishById(id) ? new ResponseEntity<>("Dish removed.", HttpStatus.OK) : new ResponseEntity<>("Not found.", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/drinks/{id}")
    public ResponseEntity<String> removeDrinkById(@PathVariable int id) {
        return menuItemService.removeDrinkById(id) ? new ResponseEntity<>("Drink removed.", HttpStatus.OK) : new ResponseEntity<>("Not found.", HttpStatus.NOT_FOUND);
    }

}
