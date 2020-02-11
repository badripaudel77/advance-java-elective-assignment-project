package com.library.servicesimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.library.database.DatabaseConnection;
import com.library.database.DatabaseConnectionImpl;
import com.library.entities.User;
import com.library.services.UserService;

public class UserServiceImpl implements UserService {

	DatabaseConnection doConnect = new DatabaseConnectionImpl();

	@Override
	public boolean isUserValid(User user) {
		Statement statement = doConnect.doConnection();
		String query = "SELECT * FROM `users` WHERE `username` = '" + user.getUsername() + "' and `password` = '"
				+ user.getPassword() + "'";

		try {
			ResultSet rs = statement.executeQuery(query);
			if (rs.next()) {
				return true;
			}
		} catch (SQLException ex) {
			System.out.println(ex);
		}
		return false;
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getUserById(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

}
