package com.revature.util;

import com.revature.model.User;

public class LoginConrollerHelper {
	public static boolean loginCheckIfUser(User u, User user) {
		if(user == null)
			return false;
		if(u.getUsername().equals(user.getUsername()) && u.getPassword().equals(user.getPassword())) {
			return true;
		}
		return false;
	}
}
