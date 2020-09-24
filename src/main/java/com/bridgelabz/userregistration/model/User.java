package com.bridgelabz.userregistration.model;

import java.util.Objects;

public class User {
	public String firstName;
	public String lastName;
	public String emailId;
	public String password;

	public User(String firstName, String lastName, String password, String emailId) {

		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.emailId = emailId;
	}

	public User() {

	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		User user = (User) o;
		return Objects.equals(firstName, user.firstName) &&
				  Objects.equals(lastName, user.lastName) &&
				  Objects.equals(emailId, user.emailId) &&
				  Objects.equals(password, user.password);
	}

	@Override
	public int hashCode() {
		return 0;
	}
}
