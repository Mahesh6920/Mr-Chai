package com.Mr_Chai.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.Mr_Chai.Entity.User;
import com.Mr_Chai.Service.UserServiceInterface;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserServiceInterface userService;
	
	@PostMapping("/register")
	public ResponseEntity<Boolean> register(@RequestBody User user) {
		if (userService.register(user)) {
			return ResponseEntity
					.status(HttpStatus.CREATED)
					.body(true);
		}

		return ResponseEntity
				.status(HttpStatus.BAD_REQUEST)
				.body(false);
	}

	@PostMapping("/login")
	public ResponseEntity<User> login(@RequestBody User user, HttpSession session) {

		User responseUser = userService.login(
				user.getEmail(),
				user.getPassword());

		if (responseUser != null) {
			session.setAttribute(
		            "userId",
		            responseUser.getId()
		    );

			System.out.println("========== LOGIN ==========");
		    System.out.println("Session ID: " + session.getId());
		    System.out.println("User ID: " + session.getAttribute("userId"));

		    return ResponseEntity
		            .status(HttpStatus.OK)
		            .body(responseUser);
		}
		
		return ResponseEntity
				.status(HttpStatus.UNAUTHORIZED)
				.body(null);
	}
	
	@GetMapping("/profile")
	public ResponseEntity<User> profile(HttpSession session) {
		
		System.out.println("========== PROFILE ==========");
	    System.out.println("Session ID: " + session.getId());
	    System.out.println("User ID: " + session.getAttribute("userId"));

		Object userID = session.getAttribute("userId");
		
		if (userID == null) {
			return ResponseEntity
					.status(HttpStatus.UNAUTHORIZED)
					.body(null);
		}
		
		int userId = (Integer) userID;
		User user = userService.profile(userId);
		
		if (user == null) {
			return ResponseEntity
					.status(HttpStatus.UNAUTHORIZED)
					.body(null);
		}
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(user);
	}

}
