package com.revature.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
import com.revature.util.UserControllerHelper;

@RestController
@CrossOrigin(origins = {"http://localhost:4200", "http://bytesizegames.us-east-1.elasticbeanstalk.com", "http://ec2-3-19-30-93.us-east-2.compute.amazonaws.com:3000"})
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

	//Need to add indication that user was not added to the database
	
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> addUser(@Valid @RequestBody User u) {
		if(!UserControllerHelper.validUser(u, uService.findAllUsers())){
			return null;
		}
		else {
		return new ResponseEntity<User>(uService.addUser(u),HttpStatus.CREATED);
		}
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
