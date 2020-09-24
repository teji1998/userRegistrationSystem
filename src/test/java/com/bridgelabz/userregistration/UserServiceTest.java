package com.bridgelabz.userregistration;

import com.bridgelabz.userregistration.Repository.UserRepository;
import com.bridgelabz.userregistration.exception.UserValidationException;
import com.bridgelabz.userregistration.model.User;
import com.bridgelabz.userregistration.service.UserValidation;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UserServiceTest {

	UserValidation userValidation;

	@Before
	public void setUp() {
		userValidation = new UserValidation();
	}

	@Test
	public void givenValidUser_WhenRegister_ShouldReturnSuccessMessage() throws UserValidationException {
		User user = new User("Tejaswini", "Kulkarni", "Tejaswini$1998",
				  "tejasvini.bts@gmail.com", "9920275347");
		String message = userValidation.fieldValidate(user);
		Assert.assertEquals("Registration SuccessFul", message);
	}

	@Test
	public void givenFirstName_whenIsNotProper_shouldGiveAnException() {
		try {
			User user = new User("Te", "Kulkarni", "Tejaswini$1998",
					  "tejasvini.bts@gmail.com", "9920275347");
			userValidation.fieldValidate(user);
		} catch (UserValidationException e) {
			Assert.assertEquals(UserValidationException.ExceptionType.INVALID_FIRST_NAME, e.exceptionType);
		}
	}

	@Test
	public void givenLastName_whenIsNotProper_shouldGiveAnException() {
		try {
			User user = new User("Tejaswini", "Ku", "Tejaswini$1998",
					  "tejasvini.bts@gmail.com", "9920275347");
			userValidation.fieldValidate(user);
		} catch (UserValidationException e) {
			Assert.assertEquals(UserValidationException.ExceptionType.INVALID_LAST_NAME, e.exceptionType);
		}
	}

	@Test
	public void givenEmailId_whenIsNotProper_shouldGiveAnException() {
		try {
			User user = new User("Tejaswini", "Kulkarni", "Tejaswini$1998",
					  "@gmail.com", "9920275347");
			userValidation.fieldValidate(user);
		} catch (UserValidationException e) {
			Assert.assertEquals(UserValidationException.ExceptionType.INVALID_EMAIL_ID, e.exceptionType);
		}
	}

	@Test
	public void givenPassword_whenIsNotProper_shouldGiveAnException() {
		try {
			User user = new User("Tejaswini", "Kulkarni", "Teji", "abc.def@gmail.com",
					  "9920275347");
			userValidation.fieldValidate(user);
		} catch (UserValidationException e) {
			Assert.assertEquals(UserValidationException.ExceptionType.INVALID_PASSWORD, e.exceptionType);
		}
	}

	@Test
	public void givenPhoneNo_whenIsNotProper_shouldGiveAnException() {
		try {
			User user = new User("Tejaswini", "Kulkarni", "Teji+1998", "abc.def@gmail.com",
					  "9920275");
			userValidation.fieldValidate(user);
		} catch (UserValidationException e) {
			Assert.assertEquals(UserValidationException.ExceptionType.INVALID_PHONE_NUMBER, e.exceptionType);
		}
	}
}

