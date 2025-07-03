package com.fooddelivery.food_delivery.service;

import com.fooddelivery.food_delivery.dto.MenuItemRequest;
import com.fooddelivery.food_delivery.MenuItem;
import com.fooddelivery.food_delivery.Restaurant;
import com.fooddelivery.food_delivery.repository.MenuRepository;
import com.fooddelivery.food_delivery.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuItemService {

    private final RestaurantRepository restaurantRepository;
    private final MenuRepository menuItemRepository;

    public MenuItem addMenuItem(Long restaurantId, MenuItemRequest request) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId).orElseThrow();

        MenuItem item = MenuItem.builder()
                .name(request.getName())
                .description(request.getDescription())
                .price(request.getPrice())
                .restaurant(restaurant)
                .build();

        return menuItemRepository.save(item);
    }

    public List<MenuItem> getMenu(Long restaurantId) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId).orElseThrow();
        return menuItemRepository.findByRestaurant(restaurant);
    }
}
