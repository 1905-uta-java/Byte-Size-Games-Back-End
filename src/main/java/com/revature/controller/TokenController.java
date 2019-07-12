package com.revature.controller;

import java.util.HashMap;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = {"http://localhost:4200", "http://bytesizegames.us-east-1.elasticbeanstalk.com", "http://ec2-3-19-30-93.us-east-2.compute.amazonaws.com:3000"})
@RequestMapping("/token")
public class TokenController {
	
	public static HashMap<Integer, Integer> tokens = new HashMap<Integer, Integer>();
	Integer tokenNumber = 1;
	
	@GetMapping
	public HashMap<Integer, Integer> getTokens(){
		return tokens;
	}
	
	
	
	@PostMapping
	public int giveToken(@RequestBody Integer i){
		tokenNumber += 2;
		tokens.put(i, tokenNumber);
		return tokenNumber;
	}
	
	@PutMapping("/{userId}")
	public int makeHost(@PathVariable("userId")Integer id) {
		tokenNumber += 2;
		tokens.remove(id);
		tokens.put(id, tokenNumber - 1);
		return tokenNumber - 1;
	}
	
	@PostMapping("/{userId}")
	public boolean checkUser(@PathVariable("userId")Integer userId, @PathVariable("tokenId")Integer tokenId) {
		Integer testToken = tokens.get(userId);
		if(testToken == tokenId) {
			System.out.println("You have succeed");
			return true;
		}
		System.out.println("You have failed");
		return false;
	}
	
	@DeleteMapping("/{userId}")
	public void deleteUser(@PathVariable("userId") Integer id) {
		tokens.remove(id);
	}
	
}
