package com.abc.jwtsecurity.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.abc.jwtsecurity.entity.RoleEntity;
import com.abc.jwtsecurity.entity.UserEntity;
import com.abc.jwtsecurity.repository.RoleRepository;
import com.abc.jwtsecurity.repository.UserRepository;

@Service
public class AuthServiceImpl implements AuthService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public UserEntity register(UserEntity userEntity) {
		
		//TODO: check username and email already existing or not. If it is existing throw some exception
				
		//before saving userEntity, encode the password
		userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
		
		Set<RoleEntity> userRoles = new HashSet<>();
		
		Set<RoleEntity> roles = userEntity.getRoles();  
		
		roles.forEach(r -> {
			Optional<RoleEntity> optionalRoleEntity = roleRepository.findById(r.getId());			
			if(optionalRoleEntity.isEmpty()) {
				
			}
			RoleEntity roleEntity = optionalRoleEntity.get();			
			userRoles.add(roleEntity);
			
		});
	
		userEntity.setRoles(userRoles);
		
		userRepository.save(userEntity);
		
		return userEntity;
	}

}
