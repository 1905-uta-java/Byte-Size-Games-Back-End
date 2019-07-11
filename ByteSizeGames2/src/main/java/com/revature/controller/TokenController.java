package com.revature.controller;

import java.util.HashMap;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = {"http://localhost:4200", "http://bytesizegames.us-east-1.elasticbeanstalk.com", "http://ec2-3-19-30-93.us-east-2.compute.amazonaws.com:3000"})
@RequestMapping("/token")
public class TokenController {
	
	public static HashMap<Integer, Integer> tokens = new HashMap<Integer, Integer>();
	
	@GetMapping
	public HashMap<Integer, Integer> getTokens(){
		return tokens;
	}
	
	
	
	@PostMapping
	public int giveToken(@RequestBody Integer i){
		int high = tokens.size() + 1;
		tokens.put(high, i);
		return high;
	}
	
	@PostMapping("/{userId}")
	public int makHost(@PathVariable("userId")Integer id) {
		return 0;
	}
}
