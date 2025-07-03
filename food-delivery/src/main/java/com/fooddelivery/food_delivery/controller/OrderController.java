package com.fooddelivery.food_delivery.controller;

import com.fooddelivery.food_delivery.User;
import com.fooddelivery.food_delivery.dto.OrderRequest;
import com.fooddelivery.food_delivery.Order;
import com.fooddelivery.food_delivery.service.OrderService;
import com.fooddelivery.food_delivery.dto.OrderStatusUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public Order create(@RequestBody OrderRequest request,
                        @AuthenticationPrincipal User user) {
        return orderService.create(request, user);
    }

    @GetMapping("/my")
    public List<Order> getMyOrders(@AuthenticationPrincipal User user) {
        return orderService.getMyOrders(user);
    }

    @PreAuthorize("hasRole('RESTAURANT_OWNER')")
    @PutMapping("/{id}/status")
    public Order updateOrderStatus(@PathVariable Long id,
                                   @RequestBody OrderStatusUpdateRequest request) {
        return orderService.updateStatus(id, request.getStatus());
    }
}
