package com.example.restaurantapi.repositories;

import com.example.restaurantapi.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {
}
