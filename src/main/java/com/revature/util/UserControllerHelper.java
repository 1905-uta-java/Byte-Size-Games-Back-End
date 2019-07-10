package com.revature.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.revature.model.User;
import com.revature.service.UserServiceImpl;

public class UserControllerHelper {
	
	@Autowired
	UserServiceImpl uServe;
	
	
	public static boolean validUser(User u, List<User> users) {
		if(u.getFirstName() == null || u.getLastName() == null || u.getUsername() == null || u.getPassword() == null || u.getEmail() == null) {
			System.out.println("THIS IS NOT A USER");
			return false;
		}
		for(User user : users) {
			if(user.getUsername().equals(u.getUsername())) {
				System.out.println("User already exists");
				return false;
			}
		}
		return true;
	}
	
}
