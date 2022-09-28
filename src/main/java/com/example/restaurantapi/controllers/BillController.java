package com.example.restaurantapi.controllers;

import com.example.restaurantapi.models.Table;
import com.example.restaurantapi.models.Takeaway;
import com.example.restaurantapi.services.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/bills")
public class BillController {

    @Autowired
    BillService billService;

    @GetMapping(value = "/tables")
    public ResponseEntity<List<Table>> getAllTables() {
        return new ResponseEntity<>(billService.getAllTables(), HttpStatus.OK);
    }

    @GetMapping(value = "/takeaways")
    public ResponseEntity<List<Takeaway>> getAllTakeaways() {
        return new ResponseEntity<>(billService.getAllTakeaways(), HttpStatus.OK);
    }

    @GetMapping(value = "/tables/{id}")
    public ResponseEntity<Table> getTableById(@PathVariable int id) {
        Optional<Table> table = billService.getTableById(id);
        return table.isPresent() ? new ResponseEntity<>(table.get(), HttpStatus.OK) : new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/takeaways/{id}")
    public ResponseEntity<Takeaway> getTakeawayById(@PathVariable int id) {
        Optional<Takeaway> takeaway = billService.getTakeawayById(id);
        return takeaway.isPresent() ? new ResponseEntity<>(takeaway.get(), HttpStatus.OK) : new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/tables")
    public ResponseEntity<Table> addTable(@RequestBody Table table) {
        return new ResponseEntity<>(billService.addTable(table), HttpStatus.CREATED);
    }

    @PostMapping(value = "/takeaways")
    public ResponseEntity<Takeaway> addTakeaway(@RequestBody Takeaway takeaway) {
        return new ResponseEntity<>(billService.addTakeaway(takeaway), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/tables/{id}")
    public ResponseEntity<String> removeTableById(@PathVariable int id) {
        return billService.removeTableById(id) ? new ResponseEntity<>("Table removed", HttpStatus.OK) : new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/takeaways/{id}")
    public ResponseEntity<String> removeTakeawayById(@PathVariable int id) {
        return billService.removeTakeawayById(id) ? new ResponseEntity<>("Takeaway removed", HttpStatus.OK) : new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/tables/{tableId}/order/{orderId}")
    public ResponseEntity<Table> addOrderToTableById(@PathVariable int tableId, @PathVariable int orderId) {
        Table table = billService.addOrderToTableById(tableId, orderId);
        return table != null ? new ResponseEntity<>(table, HttpStatus.OK) : new ResponseEntity<>(table, HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/takeaways/{takeawayId}/order/{orderId}")
    public ResponseEntity<Takeaway> addOrderToTakeawayById(@PathVariable int takeawayId, @PathVariable int orderId) {
        Takeaway takeaway = billService.addOrderToTakeawayById(takeawayId, orderId);
        return takeaway != null ? new ResponseEntity<>(takeaway, HttpStatus.OK) : new ResponseEntity<>(takeaway, HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/tables/close/{id}")
    public ResponseEntity<String> closeTableById(@PathVariable int id) {
        double closedTable = billService.closeTableById(id);
        return closedTable != 0 ? new ResponseEntity<>("Bill closed, the amount to pay is " + closedTable, HttpStatus.OK) : new ResponseEntity<>("Not found.", HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/takeaways/close/{id}")
    public ResponseEntity<String> closeTakeawaysById(@PathVariable int id) {
        double closedTakeaway = billService.closeTakeawayById(id);
        return closedTakeaway != 0 ? new ResponseEntity<>("Bill closed, the amount to pay is " + closedTakeaway, HttpStatus.OK) : new ResponseEntity<>("Not found.", HttpStatus.NOT_FOUND);
    }
}
