package com.fooddelivery.food_delivery.controller;


import com.fooddelivery.food_delivery.dto.RegisterRequest;
import com.fooddelivery.food_delivery.User;
import com.fooddelivery.food_delivery.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.fooddelivery.food_delivery.dto.AuthRequest;
import com.fooddelivery.food_delivery.dto.AuthResponse;


@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody RegisterRequest request) {
        User user = authService.register(request);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }


}
