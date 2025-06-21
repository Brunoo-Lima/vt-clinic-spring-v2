package com.pfc.veterinaryclinic.exception;

public class MedicamentoNotFoundException extends RuntimeException {
    public MedicamentoNotFoundException(String message) {
        super(message);
    }
}
