package com.fooddelivery.food_delivery.service;


import com.fooddelivery.food_delivery.dto.AuthRequest;
import com.fooddelivery.food_delivery.dto.AuthResponse;
import com.fooddelivery.food_delivery.dto.RegisterRequest;
import com.fooddelivery.food_delivery.User;
import com.fooddelivery.food_delivery.Role;
import com.fooddelivery.food_delivery.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.fooddelivery.food_delivery.security.JwtService;
import com.fooddelivery.food_delivery.security.UserDetailsImpl;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public User register(RegisterRequest request) {
        User user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.CLIENT) // по умолчанию клиент
                .build();
        return userRepository.save(user);
    }

    public AuthResponse login(AuthRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow();

        String token = jwtService.generateToken(new UserDetailsImpl(user));
        return new AuthResponse(token);
    }


}
