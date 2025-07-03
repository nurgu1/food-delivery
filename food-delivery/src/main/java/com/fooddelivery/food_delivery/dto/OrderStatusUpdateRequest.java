package com.fooddelivery.food_delivery.dto;

import com.fooddelivery.food_delivery.enums.OrderStatus;
import lombok.Data;

@Data
public class OrderStatusUpdateRequest {
    private OrderStatus status;
}
