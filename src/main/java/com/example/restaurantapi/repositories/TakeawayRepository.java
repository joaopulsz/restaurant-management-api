package com.example.restaurantapi.repositories;

import com.example.restaurantapi.models.Takeaway;

import javax.transaction.Transactional;

@Transactional
public interface TakeawayRepository extends BillRepository<Takeaway> {
}
