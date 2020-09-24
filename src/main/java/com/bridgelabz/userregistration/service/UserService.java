package com.bridgelabz.userregistration.service;

import com.bridgelabz.userregistration.model.User;

public class UserService implements UserServiceOperations {

	private final UserOperations userOperation;
	private UserService userRegistrationUser;

	public UserService(UserOperations userOperation) {
		this.userOperation = userOperation;
	}

	@Override
	public void addUser(User user) {
		this.userOperation.addUser(user);
	}

	@Override
	public int findByName(User user) {
		return this.userOperation.findByName(user);
	}

	@Override
	public void editUser(User user) {
		this.userOperation.editUser(user);
	}

	@Override
	public void deleteUser(User user) {
		this.userOperation.deleteUser(user);
	}

	@Override
	public void userLogin(User user) {
		this.userOperation.userLogin(user);
	}
}
