package com.pfc.veterinaryclinic.entity;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public abstract class Pessoa {
    private String name;

    public Pessoa(String name) {
        this.name = name;
    }

}
