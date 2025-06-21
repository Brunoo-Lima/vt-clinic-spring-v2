package com.pfc.veterinaryclinic.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "medicamentos")
@Getter @Setter
public class Medicamento {
    @Id
    private String id;
    private String type;
    private String description;

    public Medicamento(String id, String type, String description) {
        this.id = id;
        this.type = type;
        this.description = description;
    }
}
