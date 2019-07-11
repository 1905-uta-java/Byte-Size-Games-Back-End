package com.revature.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.User;
import com.revature.service.UserService;

@RestController
@CrossOrigin(origins = {"http://localhost:4200", "http://bytesizegames.us-east-1.elasticbeanstalk.com", "http://ec2-3-19-30-93.us-east-2.compute.amazonaws.com:3000"})
@RequestMapping("/game")
public class GameController {
	@Autowired
	UserService uService;
	//GameService gService;
	
	//function to add to individuals stats 
	//change to recieve throught the body
	@PostMapping("/{userId}")
	public void addStatsToUser(@PathVariable("userId") Integer userId, @RequestBody Integer point) {
		User u = uService.findUserById(userId);
		u.setTruePoints(u.getTruePoints() + point);
		System.out.println(u.getTruePoints());
		
	}
	//function to add to global stats
	
	

}
