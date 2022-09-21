package com.example.restaurantapi.controllers;

import com.example.restaurantapi.services.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/bills")
public class BillController {

    @Autowired
    BillService billService;
}
