package com.bridgelabz.userregistration.exception;

public class UserValidationException extends Exception {

	public ExceptionType exceptionType;

	public enum ExceptionType {
		INVALID_PASSWORD,
		INVALID_EMAIL_ID,
		INVALID_FIRST_NAME,
		INVALID_LAST_NAME
	}

	public UserValidationException(ExceptionType exceptionType, String message) {
		super(message);
		this.exceptionType = exceptionType;
	}
}

