package com.bridgelabz.userregistration.service;

import com.bridgelabz.userregistration.Repository.UserDatabaseOperations;
import com.bridgelabz.userregistration.model.User;
import com.bridgelabz.userregistration.utility.UserInput;

public class UserRegistration {

	public static void main(String[] args) {
		UserServiceOperations userServiceOperations = new UserService(new UserDatabaseOperations());
		boolean isChoice = true;
		System.out.println("Hello! Welcome to User Registration System");
		while (isChoice){
			System.out.println("1]User Registration  \n2]User Updation \n3]User Deletion \n4]User Login");
			int option = UserInput.getNumber();
			switch (option) {
				case 1:
					User addingUser = UserValidation.getUserName();
					addingUser = UserValidation.addUserRecord(addingUser);
					userServiceOperations.addUser(addingUser);
					break;
				case 2:
					User editingUser = UserValidation.getUserName();
					if (userServiceOperations.findByName(editingUser) == 0) {
						System.out.println("There is no data present");
					} else {
						editingUser = UserValidation.addUserRecord(editingUser);
						userServiceOperations.editUser(editingUser);
					}
					break;

				case 3:
					User deletingUser = UserValidation.getUserName();
					if (userServiceOperations.findByName(deletingUser) == 0) {
						System.out.println("There is no data present");
					} else {
						userServiceOperations.deleteUser(deletingUser);
					}
					break;
				case 4:
					User loginUser = UserValidation.userLogin();
					userServiceOperations.userLogin(loginUser);
			}
		}
	}
}

