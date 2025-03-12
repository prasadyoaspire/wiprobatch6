package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.UserEntity;
import com.example.demo.model.LoginDTO;
import com.example.demo.service.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<UserEntity> doRegistration(@RequestBody UserEntity userEntity) {
        authService.register(userEntity);
        return new ResponseEntity<>(userEntity, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<String> doLogin(@RequestBody LoginDTO loginDTO)

    {

        String token = authService.login(loginDTO.getUsernameorEmail(), loginDTO.getPassword());
        return new ResponseEntity<>(token, HttpStatus.OK);
    }

}
