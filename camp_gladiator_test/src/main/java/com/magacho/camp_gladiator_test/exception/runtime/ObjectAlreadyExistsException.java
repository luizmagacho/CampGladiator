package com.magacho.camp_gladiator_test.exception.runtime;

public class ObjectAlreadyExistsException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ObjectAlreadyExistsException() { }

	public ObjectAlreadyExistsException(String message) {
		super(message);
	}
	
	public ObjectAlreadyExistsException(String message, Throwable cause) {
		super(message, cause);
	}

}