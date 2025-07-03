package com.fooddelivery.food_delivery.repository;

import com.fooddelivery.food_delivery.Order;
import com.fooddelivery.food_delivery.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByCustomer(User user);
}
