package com.revature.service;

import java.util.List;

import com.revature.model.User;

public interface UserService {
	
	public List<User> findAllUsers();
	public User findUserById(Integer userId);
	public User findUserByUsername(String name);
	public User addUser(User u);
	public User updateUser(User u);
	public User deleteUser(User u);

}
