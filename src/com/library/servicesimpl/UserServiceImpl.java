package com.library.servicesimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
			// if that data is there , return true
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

		Statement statement = doConnect.doConnection();

		List<User> userList = new ArrayList<>();

		String sql = "SELECT * FROM users";

		try {

			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {
				User user = new User();

				user.setId(rs.getInt("id")); // we can use the name too
				user.setFullName(rs.getString("full_name"));
				user.setUsername(rs.getString("username"));
				user.setRole(rs.getInt("role"));

				userList.add(user);
			}
			return userList;
		}

		catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public User getUserById(User user) {
        
		Statement statement = doConnect.doConnection();
		
		String query = "SELECT * FROM `users` where id ='"+user.getId()+"';";

		
		User editUser = new User();
		
		try {
			ResultSet rs = statement.executeQuery(query);
		    
			while(rs.next()) {
				editUser.setId(rs.getInt("id"));
				editUser.setFullName(rs.getString("full_name"));
				editUser.setUsername(rs.getString("username"));
				editUser.setPassword(rs.getString("password"));
				editUser.setRole(rs.getInt("role"));
			}
			return editUser;
		} 
		catch (SQLException e) {

			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public boolean updateUser(User user) {

		Statement statement = doConnect.doConnection();
		String query = "UPDATE `users` SET `id`='" + user.getId() + "',`full_name`='" + user.getFullName()
				+ "',`username`='" + user.getUsername() + "',`password`='" + user.getPassword() + "',`role`='"
				+ user.getRole() + "' WHERE id='" + user.getId() + "';";

		try {

			statement.execute(query);
			return true;

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean deleteUser(User user) {
		Statement statement = doConnect.doConnection();

		String query = " DELETE from `users` where `id` = '" + user.getId() + "';";

		try {

			statement.execute(query);
			return true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean addUser(User user) {
		Statement statement = doConnect.doConnection();

		String sql = " INSERT INTO `users` (`full_name`, `username`, `password`, `role`) VALUES ('" + user.getFullName()
				+ "', '" + user.getUsername() + "', '" + user.getPassword() + "', '" + user.getRole() + "');";

		try {
			// user added to the database
			statement.execute(sql);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
