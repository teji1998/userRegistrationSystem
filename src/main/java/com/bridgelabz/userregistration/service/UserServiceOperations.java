package com.bridgelabz.userregistration.service;

import com.bridgelabz.userregistration.model.User;

public interface UserServiceOperations {

	public void addUser(User user);
	public int findByName(User user);
	public void editUser(User user);
	public void deleteUser(User user);
	public void userLogin(User user);
}
