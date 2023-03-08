package com.harry.springbootmicroservice3apigateway.service;

import com.harry.springbootmicroservice3apigateway.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService{

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
