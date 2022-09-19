package com.example.restaurantapi.repositories;

import com.example.restaurantapi.models.Till;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TillRepository extends JpaRepository<Till, Integer> {
}
