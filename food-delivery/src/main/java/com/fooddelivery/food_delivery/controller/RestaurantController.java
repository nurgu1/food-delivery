package com.fooddelivery.food_delivery.controller;

import com.fooddelivery.food_delivery.User;
import com.fooddelivery.food_delivery.dto.RestaurantRequest;
import com.fooddelivery.food_delivery.Restaurant;
import com.fooddelivery.food_delivery.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

@RestController
@RequestMapping("/restaurants")
@RequiredArgsConstructor
public class RestaurantController {

    private final RestaurantService restaurantService;
    @PreAuthorize("hasRole('RESTAURANT_OWNER')")

    @PostMapping
    public Restaurant create(@RequestBody RestaurantRequest request,
                             @AuthenticationPrincipal User user) {
        return restaurantService.create(request, user);
    }

    @GetMapping
    public List<Restaurant> getAll() {
        return restaurantService.getAll();
    }

    @GetMapping("/{id}")
    public Restaurant getById(@PathVariable Long id) {
        return restaurantService.getById(id);
    }
}
