package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.User;
import com.revature.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserService uService;
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public List<User> getAllUsers() {
		
		return uService.findAllUsers();
	}
	
	@GetMapping(value="/{userId}")
	public User getRestaurantById(@PathVariable("userId") Integer id) {
		return uService.findUserById(id);
	}

	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE)
	public User addUser(@RequestBody User u) {
		return uService.addUser(u);
	}
	
	@PutMapping("/{userId}")
	public User updateUser(@PathVariable("userId")Integer id, @RequestBody User u) {
		u.setUserId(id);;
		return uService.updateUser(u);
	}
	
	@DeleteMapping("/{userId}")
	public User deleteUser(@PathVariable("userId") Integer id) {
		User u = new User(id);
		return uService.deleteUser(u);
	}

}
