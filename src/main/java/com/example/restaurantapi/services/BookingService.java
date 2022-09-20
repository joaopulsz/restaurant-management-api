package com.example.restaurantapi.services;

import com.example.restaurantapi.models.Booking;
import com.example.restaurantapi.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    BookingRepository bookingRepository;

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Optional<Booking> findBookingById(int id) {
        return bookingRepository.findById(id);
    }

}
