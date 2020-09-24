package com.bridgelabz.userregistration.Repository;

import com.bridgelabz.userregistration.service.UserOperations;
import com.bridgelabz.userregistration.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDatabaseOperations implements UserOperations {

	public static final String INSERT_QUERY = "insert into user( first_name, last_name, password, emailId ) values (?,?,?,?,?)";
	private static final String SELECT_QUERY = "select * from user";
	private static final String QUERY = "select count(*) AS total from user where first_name = ? and last_name = ?";
	private static final String UPDATE_QUERY = "Update user set password = ?, emailId = ?, phone_number = ? where first_name = ? and last_name = ?";
	private static final String DELETE_QUERY = "delete from user where first_name = ? and last_name = ?";

	public void addUser(User user) {
		try (Connection con = UserRepository.getConnection();
		     PreparedStatement stmt = con.prepareStatement(INSERT_QUERY)) {
			int counter = 1;
			stmt.setString(counter++, user.getFirstName());
			stmt.setString(counter++, user.getLastName());
			stmt.setString(counter++, user.getPassword());
			stmt.setString(counter++, user.getEmailId());
			stmt.setString(counter, user.getPhoneNo());
			stmt.executeUpdate();
			System.out.println("Registration successfully");
		} catch (SQLException e) {
			System.out.println("Exception");
			e.printStackTrace();
		}
	}

	public void editUser(User user) {
		try (Connection con = UserRepository.getConnection();
		     PreparedStatement stmt = con.prepareStatement(UPDATE_QUERY)) {
			int counter = 1;
			stmt.setString(counter++, user.getPassword());
			stmt.setString(counter++, user.getEmailId());
			stmt.setString(counter++, user.getFirstName());
			stmt.setString(counter, user.getLastName());
			stmt.setString(counter++, user.getPhoneNo());
			stmt.executeUpdate();
			System.out.println("Record Updated successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int findByName(User user) {
		int count = 0;
		try (Connection con = UserRepository.getConnection();
		     PreparedStatement stmt = con.prepareStatement(QUERY)) {
			int counter = 1;
			stmt.setString(counter++, user.getFirstName());
			stmt.setString(counter, user.getLastName());
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				count = rs.getInt("total");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public void deleteUser(User user) {
		try (Connection con = UserRepository.getConnection();
		     PreparedStatement stmt = con.prepareStatement(DELETE_QUERY)) {
			int counter = 1;
			stmt.setString(counter++, user.getFirstName());
			stmt.setString(counter, user.getLastName());
			stmt.executeUpdate();
			System.out.println("Record deleted successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void userLogin(User user) {
		try (Connection con = UserRepository.getConnection();
		     PreparedStatement stmt = con.prepareStatement(SELECT_QUERY)) {
			ResultSet rs = stmt.executeQuery();
			String databaseEmail;
			String databasePassword;
			while (rs.next()) {
				databaseEmail = rs.getString("emailId");
				databasePassword = rs.getString("password");
				if ((user.getEmailId().equals(databaseEmail)) && (user.getPassword().equals(databasePassword))) {
					System.out.println("login successfully");
					break;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

