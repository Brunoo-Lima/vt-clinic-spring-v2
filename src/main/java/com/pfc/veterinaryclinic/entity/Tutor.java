package com.pfc.veterinaryclinic.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document(collection = "tutores")
@Getter @Setter
public class Tutor extends Pessoa {
    @Id
    private String id;
    private String phone;


    public Tutor(String name, String phone) {
        super(name);
        this.phone = phone;
    }
}
