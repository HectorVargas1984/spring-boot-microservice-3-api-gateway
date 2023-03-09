package com.harry.springbootmicroservice3apigateway.security;

import com.harry.springbootmicroservice3apigateway.model.User;
import com.harry.springbootmicroservice3apigateway.service.IUserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService {

    private final IUserService userService;

    public CustomUserDetailsService(IUserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userService.findByUsername(username)
                .orElseThrow(()-> new UsernameNotFoundException("El usuario no fue encontrado: " + username));



        return null;
    }
}
