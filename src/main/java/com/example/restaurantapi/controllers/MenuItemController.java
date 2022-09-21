package com.example.restaurantapi.controllers;

import com.example.restaurantapi.services.MenuItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/menuitems")
public class MenuItemController {

    @Autowired
    MenuItemService menuItemService;
}
