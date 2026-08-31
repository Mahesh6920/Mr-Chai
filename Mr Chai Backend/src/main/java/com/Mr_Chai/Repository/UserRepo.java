package com.Mr_Chai.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Mr_Chai.Entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {
	
	Optional<User> findByEmail(String email);

	boolean existsByEmail(String email);
}
