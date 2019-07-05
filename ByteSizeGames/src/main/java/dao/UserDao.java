package dao;

import java.util.List;

import models.User;

public interface UserDao {
	public List<User> getUsers();
	
	public User getUserById(int id);
	
	public int createUser(User u);
	
	public void updateUser(User u);
}
