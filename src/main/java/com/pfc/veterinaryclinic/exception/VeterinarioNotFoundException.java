package com.pfc.veterinaryclinic.exception;

public class VeterinarioNotFoundException extends RuntimeException {
    public VeterinarioNotFoundException(String message) {
        super(message);
    }
}
