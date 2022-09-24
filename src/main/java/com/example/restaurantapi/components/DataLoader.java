package com.example.restaurantapi.components;

import com.example.restaurantapi.models.Booking;
import com.example.restaurantapi.models.Dish;
import com.example.restaurantapi.models.Drink;
import com.example.restaurantapi.models.Restaurant;
import com.example.restaurantapi.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    RestaurantRepository restaurantRepository;

    @Autowired
    DishRepository dishRepository;

    @Autowired
    DrinkRepository drinkRepository;

    @Autowired
    BookingRepository bookingRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Restaurant joaosBurgers = new Restaurant();

        Dish doubleWithCheese = new Dish("Double with Cheese", 10.00);
        Dish baconAndOnion = new Dish("Bacon and Onion Burger", 10.00);
        Dish vegBurger = new Dish("Mushroom patty", 8.00);
        Dish rosemaryFries = new Dish("Rosemary Fries", 3.50);
        Dish chickenWings = new Dish("Chicken Wings", 6.00);
        dishRepository.save(doubleWithCheese);
        dishRepository.save(baconAndOnion);
        dishRepository.save(vegBurger);
        dishRepository.save(rosemaryFries);
        dishRepository.save(chickenWings);

        Drink milkShake = new Drink("Milk Shake", 3.50);
        Drink juice = new Drink("Fruit Juice", 2.00);
        Drink beer = new Drink("Beer", 4.00);
        drinkRepository.save(milkShake);
        drinkRepository.save(juice);
        drinkRepository.save(beer);

        Booking booking1 = new Booking("Joao", "Friday, 20:00", 5);
        Booking booking2 = new Booking("Pedro", "Saturday, 20:30", 7);

        bookingRepository.save(booking1);
        bookingRepository.save(booking2);

        restaurantRepository.save(joaosBurgers);
    }

}
