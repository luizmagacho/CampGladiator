package com.magacho.camp_gladiator_test.exception.runtime;

public class RequiredFieldException extends RuntimeException {
	public RequiredFieldException() {
		super();
	}

	public RequiredFieldException(String message) {
		super(message);
	}
	
	public RequiredFieldException(String message, Throwable cause) {
		super(message, cause);
	}

}