package com.fooddelivery.food_delivery.service;

import com.fooddelivery.food_delivery.User;
import com.fooddelivery.food_delivery.dto.RestaurantRequest;
import com.fooddelivery.food_delivery.Restaurant;
import com.fooddelivery.food_delivery.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    public Restaurant create(RestaurantRequest request, User owner) {
        Restaurant restaurant = Restaurant.builder()
                .name(request.getName())
                .address(request.getAddress())
                .owner(owner)
                .build();
        return restaurantRepository.save(restaurant);
    }

    public List<Restaurant> getAll() {
        return restaurantRepository.findAll();
    }

    public Restaurant getById(Long id) {
        return restaurantRepository.findById(id).orElseThrow();
    }
}
