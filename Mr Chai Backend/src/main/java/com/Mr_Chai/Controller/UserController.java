package com.Mr_Chai.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Mr_Chai.Entity.User;
import com.Mr_Chai.Service.UserService;

@CrossOrigin(origins = "http://127.0.0.1:5500/")
@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
		
	@PostMapping("/register")
	public boolean register(@RequestBody User user) {
		if (userService.register(user)) {
			return true;
		}
		
		return false;
	}
	
	@PostMapping("/login")
	public boolean login(@RequestBody User user) {

	    userService.login(
	            user.getEmail(),
	            user.getPassword()
	    );

	    return true;
	}
}
