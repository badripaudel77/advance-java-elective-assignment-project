package com.library.services;

import java.util.List;

import com.library.entities.User;

public interface UserService {

	// user login
	public boolean isUserValid(User user);

	//add the user
	public boolean addUser(User user);
	
	// list the users
	public List<User> getAllUsers();

	// list an individual user by id
	public User getUserById(User user);

	// update user
	public boolean updateUser(User user);

	// delete user
	public boolean deleteUser(User user);

}
