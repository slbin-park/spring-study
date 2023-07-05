package com.example.securitystudy.controller;

import com.example.securitystudy.config.TokenProvider;
import com.example.securitystudy.dto.TokenResponse;
import com.example.securitystudy.dto.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/users")
public class UserController {
    private TokenProvider tokenProvider;
    @PostMapping
    public TokenResponse getToken(User user){
        return tokenProvider.generateJWT(user);
    }
}
