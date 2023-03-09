package com.harry.springbootmicroservice3apigateway.service;

import com.harry.springbootmicroservice3apigateway.model.Roles;
import com.harry.springbootmicroservice3apigateway.model.User;
import com.harry.springbootmicroservice3apigateway.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService{

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * Guardar un User
     * @param user
     * @return el usuario guardado
     */
    @Override
    public User saveUser(User user){

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(Roles.USER);
        user.setFechaCreacion(LocalDateTime.now());

        return userRepository.save(user);

    }

    /**
     * Buscar un user por username
     * @param username
     * @return
     */
    @Override
    public Optional<User> findByUsername(String username){
        return userRepository.findByUsername(username);
    }

    /**
     * Actualiza los roles de un usuario
     * @param newRole
     * @param username
     */
    @Override
    @Transactional // se agrega cuando trabajas con query en tu codigo
    public void changeRoles(Roles newRole, String username){
        userRepository.updaateUserROle(username, newRole);
    }



}
