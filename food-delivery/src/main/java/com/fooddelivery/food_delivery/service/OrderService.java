package com.fooddelivery.food_delivery.service;

import com.fooddelivery.food_delivery.User;
import com.fooddelivery.food_delivery.dto.OrderRequest;
import com.fooddelivery.food_delivery.MenuItem;
import com.fooddelivery.food_delivery.Order;
import com.fooddelivery.food_delivery.Restaurant;
import com.fooddelivery.food_delivery.enums.OrderStatus;
import com.fooddelivery.food_delivery.repository.MenuRepository;
import com.fooddelivery.food_delivery.repository.OrderRepository;
import com.fooddelivery.food_delivery.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final RestaurantRepository restaurantRepository;
    private final MenuRepository menuItemRepository;

    public Order create(OrderRequest request, User customer) {
        Restaurant restaurant = restaurantRepository.findById(request.getRestaurantId()).orElseThrow();
        List<MenuItem> items = menuItemRepository.findAllById(request.getItemIds());

        Order order = Order.builder()
                .customer(customer)
                .restaurant(restaurant)
                .items(items)
                .status(OrderStatus.NEW)
                .createdAt(LocalDateTime.now())
                .build();

        return orderRepository.save(order);
    }

    public List<Order> getMyOrders(User customer) {
        return orderRepository.findByCustomer(customer);
    }

    public Order updateStatus(Long orderId, OrderStatus status) {
        Order order = orderRepository.findById(orderId).orElseThrow();
        order.setStatus(status);
        return orderRepository.save(order);
    }

}
