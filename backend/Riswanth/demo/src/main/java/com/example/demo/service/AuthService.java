package com.example.demo.service;

import com.example.demo.entity.UserEntity;

public interface AuthService {
    UserEntity register(UserEntity userEntity);

    String login(String usernameorEmail, String password);
}
