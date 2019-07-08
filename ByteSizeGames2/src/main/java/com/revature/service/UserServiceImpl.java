package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.User;
import com.revature.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository uRepo;

	@Override
	public List<User> findAllUsers() {

		return uRepo.findAll();
	}

	@Override
	public User findUserById(Integer userId) {

		return uRepo.findUserByUserId(userId);
	}


	@Override
	public User addUser(User u) {

		return uRepo.save(u);
	}

	@Override
	public User updateUser(User u) {

		return uRepo.save(u);
	}

	@Override
	public User deleteUser(User u) {

		uRepo.delete(u);
		return u;
	}

	@Override
	public User findUserByUsername(String username) {
		
		return uRepo.findUserByUsername(username);
	}

}
