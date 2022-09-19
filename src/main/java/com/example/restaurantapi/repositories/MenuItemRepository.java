package com.example.restaurantapi.repositories;

import com.example.restaurantapi.models.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface MenuItemRepository<T extends MenuItem> extends JpaRepository<T, Integer> {

}
