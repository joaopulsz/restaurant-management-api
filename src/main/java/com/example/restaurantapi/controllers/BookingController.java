package com.example.restaurantapi.controllers;

import com.example.restaurantapi.models.Booking;
import com.example.restaurantapi.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/bookings")
public class BookingController {

    @Autowired
    BookingService bookingService;

    @GetMapping
    public ResponseEntity<List<Booking>> getAllBookings() {
        return new ResponseEntity<>(bookingService.getAllBookings(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Booking> getBookingById(@PathVariable int id) {
        Optional<Booking> booking = bookingService.findBookingById(id);
        return booking.isPresent() ? new ResponseEntity<>(booking.get(), HttpStatus.OK) : new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Booking> addNewBooking(@RequestBody Booking booking) {
        Booking newBooking = bookingService.addBooking(booking);
        return new ResponseEntity<>(newBooking, HttpStatus.CREATED);
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<Booking> updateBookingById(@PathVariable int id, @RequestBody Booking booking) {
        Booking updatedBooking = bookingService.updateBookingById(id, booking);
        return updatedBooking != null ? new ResponseEntity<>(updatedBooking, HttpStatus.ACCEPTED) : new ResponseEntity<>(updatedBooking, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> removeBookingById(@PathVariable int id) {
        boolean isRemoved = bookingService.removeBookingById(id);
        return isRemoved ? new ResponseEntity<>("Booking removed.", HttpStatus.OK) : new ResponseEntity<>("Booking not found.", HttpStatus.NOT_FOUND);
    }
}
