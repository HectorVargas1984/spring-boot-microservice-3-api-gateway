package com.harry.springbootmicroservice3apigateway.service;

import com.harry.springbootmicroservice3apigateway.model.Roles;
import com.harry.springbootmicroservice3apigateway.model.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface IUserService {
    User saveUser(User user);

    Optional<User> findByUsername(String username);

    @Transactional
    void changeRoles(Roles newRole, String username);
}
