package com.example.authorizationserver.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.authorizationserver.Model.User;

public interface UserDetailRepository extends JpaRepository<User, Integer> {
	
	Optional<User> findByUsername(String name);

}
