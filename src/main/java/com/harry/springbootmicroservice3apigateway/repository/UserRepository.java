package com.harry.springbootmicroservice3apigateway.repository;

import com.harry.springbootmicroservice3apigateway.model.Roles;
import com.harry.springbootmicroservice3apigateway.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Busca un usuario por el nombre del usuario
     * @param username
     * @return por el nombre del usuario
     */
    Optional<User> findByUsername(String username);


    /**
     * Permite actualizar role atravez del username
     * @param username
     * @param role
     */
    @Modifying
    @Query("UPDATE User set role=:role WHERE username=:username")
    void updaateUserROle(@Param("username") String username, @Param("role")Roles role);
}
