package com.bridgelabz.userregistration.Repository;

import java.sql.*;

public class UserRepository {

	public final static String DATABASE_URL = "jdbc:mysql://localhost:3306/world";
	public final static String DATABASE_USERNAME = "root";
	public final static String DATABASE_PASSWORD = "teju1998";

	public static Connection getConnection() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

}

