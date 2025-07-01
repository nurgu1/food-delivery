package com.fooddelivery.food_delivery.controller;

import com.fooddelivery.food_delivery.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    @GetMapping("/me")
    public String getCurrentUser(@AuthenticationPrincipal User user) {
        System.out.println("Current user: " + user.getEmail());
        return user.getEmail();
    }

}
