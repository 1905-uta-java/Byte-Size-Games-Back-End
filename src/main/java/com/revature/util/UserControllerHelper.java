package com.revature.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.revature.model.User;
import com.revature.service.UserServiceImpl;

public class UserControllerHelper {
	
	@Autowired
	UserServiceImpl uServe;
	
	
	public static boolean validUser(User u, List<User> users) {
		if(u.getFirstName().equals("") || u.getLastName().equals("") || u.getUsername().equals("") || u.getPassword().equals("") || u.getEmail().equals("")) {
			System.out.println("THIS IS NOT A USER");
			return false;
		}
		for(User user : users) {
			if(u.getUsername().equals(user.getUsername())) {
				System.out.println("User already exists");
				return false;
			}
		}
		return true;
	}
	
}
