package com.magacho.camp_gladiator_test.exception.runtime;

public class BadRequestException extends RuntimeException {

    public BadRequestException(String msg) {
        super(msg);
    }

}
