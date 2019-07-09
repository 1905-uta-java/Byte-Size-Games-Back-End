package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.User;
import com.revature.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	UserService uService;
	
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public List<User> getAllUsers() {
		System.out.println("login get");
		return uService.findAllUsers();
	}
	
	@GetMapping(value="/{username}")
	public User getRestaurantById(@PathVariable("userId") Integer id) {
		return uService.findUserById(id);
	}
	
	@PostMapping()
	public User addUser(@RequestBody User u) {
		User user = uService.findUserByUsername(u.getUsername());
		if(u.getUsername().equals(user.getUsername()) && u.getPassword().equals(user.getPassword())) {
			return user;
		}
		System.out.println(user.toString()); 
		return u;
	}
}
