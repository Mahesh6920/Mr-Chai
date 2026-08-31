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

}
