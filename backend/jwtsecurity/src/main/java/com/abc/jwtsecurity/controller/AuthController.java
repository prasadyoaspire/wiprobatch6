package com.abc.jwtsecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc.jwtsecurity.entity.UserEntity;
import com.abc.jwtsecurity.service.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	@Autowired
	private AuthService authService;
	
	@PostMapping("/register")
	public ResponseEntity<UserEntity> doRegistration(@RequestBody UserEntity userEntity) {
		
		authService.register(userEntity);
		
		return new ResponseEntity<>(userEntity,HttpStatus.CREATED);
	}
}
