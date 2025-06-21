package com.pfc.veterinaryclinic.exception;

public class PrescricaoNotFoundException extends RuntimeException {
    public PrescricaoNotFoundException(String message) {
        super(message);
    }
}
