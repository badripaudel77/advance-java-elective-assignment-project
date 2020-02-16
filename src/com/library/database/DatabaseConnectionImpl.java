package com.library.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnectionImpl implements DatabaseConnection {

	@Override
	public Statement doConnection() {
		
		Connection connection = null;
		Statement statement = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");

			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbs_lms", "root", "");
			System.out.println("Connected to Mysql Database");

			statement = connection.createStatement();
			return statement;

		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}

		return statement;
	}
}
