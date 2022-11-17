package com.magacho.camp_gladiator_test.exception.runtime;

public class ObjectNotFoundException extends RuntimeException {
	public ObjectNotFoundException() {
		super();
	}

	public ObjectNotFoundException(String message) {
		super(message);
	}
	
	public ObjectNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

}