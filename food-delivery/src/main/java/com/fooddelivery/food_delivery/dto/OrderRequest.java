package com.fooddelivery.food_delivery.dto;

import lombok.Data;

import java.util.List;

@Data
public class OrderRequest {
    private Long restaurantId;
    private List<Long> itemIds;
}
