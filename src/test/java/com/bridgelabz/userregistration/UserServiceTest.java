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

	@Test
	public void givenFirstName_whenIsNotProper_shouldGiveAnException() {
		try {
			User user = new User("Te", "Kulkarni", "Tejaswini$1998", "tejasvini.bts@gmail.com");
			userValidation.fieldValidate(user);
		} catch (UserValidationException e) {
			Assert.assertEquals(UserValidationException.ExceptionType.INVALID_FIRST_NAME, e.exceptionType);
		}
	}

	@Test
	public void givenLastName_whenIsNotProper_shouldGiveAnException() {
		try {
			User user = new User("Tejaswini", "Ku", "Tejaswini$1998", "tejasvini.bts@gmail.com");
			userValidation.fieldValidate(user);
		} catch (UserValidationException e) {
			Assert.assertEquals(UserValidationException.ExceptionType.INVALID_LAST_NAME, e.exceptionType);
		}
	}

	@Test
	public void givenEmailId_whenIsNotProper_shouldGiveAnException() {
		try {
			User user = new User("Tejaswini", "Kulkarni", "Tejaswini$1998", "@gmail.com");
			userValidation.fieldValidate(user);
		} catch (UserValidationException e) {
			Assert.assertEquals(UserValidationException.ExceptionType.INVALID_EMAIL_ID, e.exceptionType);
		}
	}
}

