package com.fooddelivery.food_delivery.controller;

import com.fooddelivery.food_delivery.dto.MenuItemRequest;
import com.fooddelivery.food_delivery.MenuItem;
import com.fooddelivery.food_delivery.service.MenuItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/restaurants/{id}/menu")
public class MenuController {

    private final MenuItemService menuService;

    @PostMapping
    public MenuItem addMenuItem(@PathVariable Long id, @RequestBody MenuItemRequest request) {
        return menuService.addMenuItem(id, request);
    }

    @GetMapping
    public List<MenuItem> getMenu(@PathVariable Long id) {
        return menuService.getMenu(id);
    }
}
