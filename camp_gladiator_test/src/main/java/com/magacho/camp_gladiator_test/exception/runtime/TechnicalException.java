package com.magacho.camp_gladiator_test.exception.runtime;

public class TechnicalException extends RuntimeException {
	public TechnicalException() {
		super();
	}

	public TechnicalException(String message) {
		super(message);
	}

	public TechnicalException(String message, Throwable cause) {
		super(message, cause);
	}

}