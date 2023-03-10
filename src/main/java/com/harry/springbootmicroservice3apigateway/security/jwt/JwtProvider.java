package com.harry.springbootmicroservice3apigateway.security.jwt;

import com.harry.springbootmicroservice3apigateway.security.UserPricipal;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;

public interface JwtProvider {
    String generateToken(UserPricipal auth);

    Authentication getAuthentication(HttpServletRequest request);

    boolean isTokenValid(HttpServletRequest request);
}
