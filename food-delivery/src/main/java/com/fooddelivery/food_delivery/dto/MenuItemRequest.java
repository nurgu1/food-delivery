package com.fooddelivery.food_delivery.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class MenuItemRequest {
    private String name;
    private String description;
    private BigDecimal price;
}
