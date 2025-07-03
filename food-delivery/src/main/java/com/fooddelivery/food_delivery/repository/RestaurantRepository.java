package com.fooddelivery.food_delivery.repository;

import com.fooddelivery.food_delivery.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
}
