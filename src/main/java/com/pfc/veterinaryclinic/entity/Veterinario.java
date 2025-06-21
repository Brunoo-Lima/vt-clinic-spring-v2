package com.pfc.veterinaryclinic.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "veterinarios")
@Getter @Setter
public class Veterinario extends Pessoa {
    @Id
    private String id;
    private String crmv;
    private String specialty;
    private boolean available;

    public Veterinario() {
        super("");
    }

    public Veterinario(String name, String crmv, String specialty) {
        super(name);
        this.crmv = crmv;
        this.available = true;
        this.specialty = specialty;
    }

    public Veterinario(String id, String name,
                      String crmv, String specialty, boolean available) {
        super(name);
        this.id = id;
        this.crmv = crmv;
        this.specialty = specialty;
        this.available = available;
    }

}
