package com.revature.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.revature.model.User;
import com.revature.repository.UserRepository;

public class LoginServiceImpl implements LoginService {

	@Autowired
	UserRepository uRepo;
	
	@Override
	public User findUserByUsernameAndPassword(String username, String password) {
		User loginUser = null;
		loginUser = uRepo.findUserByUsername(username);
		if(loginUser.getPassword().equals(password))
			return loginUser;
		return null;
	}

}
