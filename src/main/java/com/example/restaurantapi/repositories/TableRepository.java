package com.example.restaurantapi.repositories;

import com.example.restaurantapi.models.Table;

import javax.transaction.Transactional;

@Transactional
public interface TableRepository extends BillRepository<Table> {
}
