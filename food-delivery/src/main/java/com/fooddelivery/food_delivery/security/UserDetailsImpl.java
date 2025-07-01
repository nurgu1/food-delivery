package com.fooddelivery.food_delivery.security;

import com.fooddelivery.food_delivery.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class UserDetailsImpl implements UserDetails {

    private final User user;

    public UserDetailsImpl(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // если у тебя есть роли — верни их здесь
        return Collections.emptyList();
    }

    @Override
    public String getPassword() {
        return user.getPassword();  // убедись, что в твоём User есть getPassword()
    }

    @Override
    public String getUsername() {
        return user.getEmail();  // или user.getUsername(), если у тебя есть такое поле
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
