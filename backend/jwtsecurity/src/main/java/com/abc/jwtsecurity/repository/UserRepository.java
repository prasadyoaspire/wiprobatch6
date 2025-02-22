package com.abc.jwtsecurity.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abc.jwtsecurity.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity,Long> {

	Optional<UserEntity> findByUsernameOrEmail(String username,String email);
}
