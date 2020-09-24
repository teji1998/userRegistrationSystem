package com.bridgelabz.userregistration.model;

import java.util.Objects;

public class User {
	public String phoneNo;
	public String firstName;
	public String lastName;
	public String emailId;
	public String password;

	public User(String firstName, String lastName, String password, String emailId, String phoneNo) {

		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.emailId = emailId;
		this.phoneNo = phoneNo;
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

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		User user = (User) o;
		return Objects.equals(phoneNo, user.phoneNo) &&
				  Objects.equals(firstName, user.firstName) &&
				  Objects.equals(lastName, user.lastName) &&
				  Objects.equals(emailId, user.emailId) &&
				  Objects.equals(password, user.password);
	}

	@Override
	public int hashCode() {
		return 0;
	}
}


