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

    public Table addTable(Table table) {
        tableRepository.save(table);
        return table;
    }

    public Takeaway addTakeaway(Takeaway takeaway) {
        takeawayRepository.save(takeaway);
        return takeaway;
    }

    public boolean removeTableById(int id) {
        Optional<Table> tableToRemove = tableRepository.findById(id);
        if (tableToRemove.isPresent()) {
            tableRepository.delete(tableRepository.findById(id).get());
            return true;
        }
        return false;
    }

    public boolean removeTakeawayById(int id) {
        Optional<Takeaway> takeawayToRemove = takeawayRepository.findById(id);
        if (takeawayToRemove.isPresent()) {
            takeawayRepository.delete(takeawayRepository.findById(id).get());
            return true;
        }
        return false;
    }
}
