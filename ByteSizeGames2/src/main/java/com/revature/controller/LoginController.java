package com.revature.controller;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.User;
import com.revature.service.UserService;
import com.revature.util.LoginConrollerHelper;

@RestController
@CrossOrigin(origins = {"http://localhost:4200", "http://bytesizegames.us-east-1.elasticbeanstalk.com", "http://ec2-3-19-30-93.us-east-2.compute.amazonaws.com:3000"})
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
		User u = uService.findUserById(id);
		return u.safeUser();
	}
	
	@PostMapping()
	public User addUser(@RequestBody User u) {
		System.out.println(u.toString());
		User user = uService.findUserByUsername(u.getUsername());
		//System.out.println(user.toString());
		if(LoginConrollerHelper.loginCheckIfUser(u, user)) {
			return user.safeUser();
		}
		return u.safeUser();
	}
}
