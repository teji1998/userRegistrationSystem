package com.bridgelabz.userregistration.service;

import com.bridgelabz.userregistration.exception.UserValidationException;
import com.bridgelabz.userregistration.model.User;
import com.bridgelabz.userregistration.utility.UserInput;

import java.util.InputMismatchException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserValidation {

	public static String firstName;
	public static String lastName;
	public static String emailId;
	public static String password;

	public static User getUserName() {
		User user = new User();
		String name;
		System.out.println("Enter the first name :");
		while (!UserValidation.namePatternCheck(firstName)) {
			System.out.println("Enter valid the first name");
			firstName = UserInput.getString();
		}
		user.setFirstName(firstName);
		lastName = UserInput.getString();
		while (!UserValidation.namePatternCheck(lastName)) {
			System.out.println("Enter valid the last name");
			lastName = UserInput.getString();
		}
		user.setLastName(lastName);
		name = user.getFirstName() + user.getLastName();
		return user;
	}

	public static User addUserRecord(User user) {
		try {
			long length;
			System.out.println("Enter the Password");
			password = UserInput.getString();
			while (!UserValidation.passwordPatternCheck(password)) {
				System.out.println("Enter valid the Password");
				password = UserInput.getString();
			}
			user.setPassword(password);
			System.out.println("Enter the emailId");
			emailId = UserInput.getString();
			while (!UserValidation.emailPatternCheck(emailId)) {
				System.out.println("Enter the valid emailId");
				emailId = UserInput.getString();
			}
			user.setEmailId(emailId);
		} catch (NullPointerException | InputMismatchException e) {
			System.out.println(e);
		}
		return user;
	}

	public static User userLogin() {
		User user = new User();
		try {
			System.out.println("Enter the emailId");
			user.setEmailId(UserInput.getString());
			System.out.println("Enter the Password");
			user.setPassword(UserInput.getString());
		} catch (NullPointerException | InputMismatchException e) {
			System.out.println(e);
		}
		return user;
	}

	public static boolean namePatternCheck(String stringCheck) {
		Pattern stringChecker = Pattern.compile("^[A-Z]{1}[A-Za-z]{2,}");
		Matcher matchString = stringChecker.matcher(stringCheck);
		return matchString.matches();
	}

	public static boolean passwordPatternCheck(String stringCheck) {
		Pattern pattern = Pattern.compile("^(?=.*[A-Z].*)(?=.*[0-9].*)(?=.*[@#$%^&*+_].*)[0-9a-zA-Z@#$%^&*+_]{8,}");
		Matcher matchString = pattern.matcher(stringCheck);
		return matchString.matches();
	}

	public static boolean emailPatternCheck(String stringCheck) {
		Pattern pattern = Pattern.compile("^[0-9a-z]+[+_.-]?[0-9a-z]+[@][0-9a-z]+[.][a-z]{2,}");
		Matcher matchString = pattern.matcher(stringCheck);
		return matchString.matches();
	}

	public static String fieldValidate(User user) throws UserValidationException {

		if (!UserValidation.namePatternCheck(user.getFirstName())) {
			throw new UserValidationException(UserValidationException.ExceptionType.INVALID_FIRST_NAME, "Invalid First Name");
		}
		if (!UserValidation.namePatternCheck(user.getLastName())) {
			throw new UserValidationException(UserValidationException.ExceptionType.INVALID_LAST_NAME, "Invalid Last Name");
		}
		if (!UserValidation.passwordPatternCheck(user.getPassword())) {
			throw new UserValidationException(UserValidationException.ExceptionType.INVALID_PASSWORD, "Invalid Password");
		}
		if (!UserValidation.emailPatternCheck(user.getEmailId())) {
			throw new UserValidationException(UserValidationException.ExceptionType.INVALID_EMAIL_ID, "Invalid Email");
		}
		return "Registration SuccessFul";
	}
}