package com.example.restaurantapi.services;

import com.example.restaurantapi.models.Table;
import com.example.restaurantapi.models.Takeaway;
import com.example.restaurantapi.repositories.TableRepository;
import com.example.restaurantapi.repositories.TakeawayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BillService {

    @Autowired
    TableRepository tableRepository;

    @Autowired
    TakeawayRepository takeawayRepository;

    public List<Table> getAllTables() {
        return tableRepository.findAll();
    }

    public List<Takeaway> getAllTakeaways() {
        return takeawayRepository.findAll();
    }

    public Optional<Table> getTableById(int id) {
        return tableRepository.findById(id);
    }

    public Optional<Takeaway> getTakeawayById(int id) {
        return takeawayRepository.findById(id);
    }
}
