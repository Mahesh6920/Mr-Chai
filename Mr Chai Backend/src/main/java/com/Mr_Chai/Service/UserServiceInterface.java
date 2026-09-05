package com.Mr_Chai.Service;

import com.Mr_Chai.Entity.User;

public interface UserServiceInterface {

	boolean register(User user);
	public User login(String email, String password);
	public User profile(int id);
	
}
