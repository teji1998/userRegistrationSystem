package com.bridgelabz.userregistration;

import com.bridgelabz.userregistration.model.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UserServiceTest {

	UserValidation userValidation;

	@Before
	public void setUp() throws Exception {
		userValidation = new UserValidation();
	}

	@Test
	public void givenValidUser_WhenRegister_ShouldReturnSuccessMessage() throws UserValidationException {
		User user = new User("Tejaswini", "Kulkarni", "Tejaswini$1998", "tejasvini.bts@gmail.com");
		String message = userValidation.fieldValidate(user);
		Assert.assertEquals("Registration SuccessFul", message);
	}

}

