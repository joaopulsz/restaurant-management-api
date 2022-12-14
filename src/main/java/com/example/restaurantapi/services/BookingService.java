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

    public Booking addBooking(Booking booking) {
        bookingRepository.save(booking);
        return booking;
    }

    public Booking updateBookingById(int id, Booking booking) {
        Optional<Booking> bookingToUpdate = bookingRepository.findById(id);
        if (bookingToUpdate.isPresent()) {
            bookingToUpdate.get().setName(booking.getName());
            bookingToUpdate.get().setDateAndTime(booking.getDateAndTime());
            bookingToUpdate.get().setTableNumber(booking.getTableNumber());
            bookingRepository.save(bookingToUpdate.get());
            return bookingToUpdate.get();
        }
        return null;
    }

    public boolean removeBookingById(int id) {
        Optional<Booking> bookingToRemove = bookingRepository.findById(id);
        if (bookingToRemove.isPresent()) {
            bookingRepository.delete(bookingRepository.findById(id).get());
            return true;
        }
        return false;
    }

}
