package com.example.restaurantapi.services;

import com.example.restaurantapi.models.MenuItem;
import com.example.restaurantapi.models.Table;
import com.example.restaurantapi.models.Takeaway;
import com.example.restaurantapi.repositories.MenuItemRepository;
import com.example.restaurantapi.repositories.RestaurantRepository;
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

    @Autowired
    RestaurantRepository restaurantRepository;

    @Autowired
    MenuItemRepository menuItemRepository;

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

    public Table addOrderToTableById(int tableId, int orderId) {
        Optional<Table> table = tableRepository.findById(tableId);
        Optional<MenuItem> order = menuItemRepository.findById(orderId);
        if (table.isPresent() && order.isPresent()) {
            table.get().getOrders().add(order.get());
            tableRepository.save(table.get());
            return table.get();
        }
        return null;
    }

    public Takeaway addOrderToTakeawayById(int takeawayId, int orderId) {
        Optional<Takeaway> takeaway = takeawayRepository.findById(takeawayId);
        Optional<MenuItem> order = menuItemRepository.findById(orderId);
        if (takeaway.isPresent() && order.isPresent()) {
            takeaway.get().getOrders().add(order.get());
            takeawayRepository.save(takeaway.get());
            return takeaway.get();
        }
        return null;
    }

    public double closeTableById(int id) {
        Optional<Table> table = tableRepository.findById(id);
        if (table.isPresent()) {
            table.get().setClosed(true);
            restaurantRepository.findById(1).get().getClosedBills().add(table.get());
            restaurantRepository.save(restaurantRepository.findById(1).get());
            return table.get().getTotalAmountToPay();
        }
        return 0;
    }

    public double closeTakeawayById(int id) {
        Optional<Takeaway> takeaway = takeawayRepository.findById(id);
        if (takeaway.isPresent()) {
            takeaway.get().setClosed(true);
            restaurantRepository.findById(1).get().getClosedBills().add(takeaway.get());
            restaurantRepository.save(restaurantRepository.findById(1).get());
            return takeaway.get().getTotalAmountToPay();
        }
        return 0;
    }

}
