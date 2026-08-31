package com.Mr_Chai.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Mr_Chai.Entity.User;
import com.Mr_Chai.Repository.UserRepo;

@Service
public class UserService {
	
	@Autowired
	private UserRepo userRepo;

	public boolean register(User user) {
		if (userRepo.save(user) != null) {
			return true;
		}
		
		return false;
	}

	public User login(String email, String password) {
		
		User user = userRepo.findByEmail(email)
				.orElseThrow(() ->
						new RuntimeException("Invalid email or password"));
		
		if (!user.getPassword().equals(password)) {
			throw new RuntimeException("Invalid email or password");
		}
		
		
		
		return user;
	}
	
}
