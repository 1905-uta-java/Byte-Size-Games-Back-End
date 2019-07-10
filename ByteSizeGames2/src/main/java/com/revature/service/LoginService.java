package com.revature.service;

import com.revature.model.User;

public interface LoginService {
	public User findUserByUsernameAndPassword(String username, String password);
}
