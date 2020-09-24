package com.bridgelabz.userregistration;

import com.bridgelabz.userregistration.model.User;

public interface UserOperations {

	public void editUser(User user);
	public void addUser(User user);
	public int findByName(User user);
	public void deleteUser(User user);
	public void userLogin(User user);
}
