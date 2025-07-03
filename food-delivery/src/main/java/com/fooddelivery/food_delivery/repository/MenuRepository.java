package com.fooddelivery.food_delivery.repository;

import com.fooddelivery.food_delivery.MenuItem;
import com.fooddelivery.food_delivery.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuRepository extends JpaRepository<MenuItem, Long> {
    List<MenuItem> findByRestaurant(Restaurant restaurant);
}
