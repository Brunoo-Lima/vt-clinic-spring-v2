package com.pfc.veterinaryclinic.exception;

public class PetNotFoundException extends RuntimeException {

    public PetNotFoundException(String id) {
        super("Pet com ID " + id + " não encontrado.");
    }
}