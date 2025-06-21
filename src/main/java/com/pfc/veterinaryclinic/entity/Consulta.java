package com.pfc.veterinaryclinic.entity;

import com.pfc.veterinaryclinic.enums.ConsultaStatus;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

//consulta medica
@Document(collection = "consultas")
@Getter @Setter
public class Consulta {
    @Id
    private String id;
    private final Pet pet;
    private final Veterinario veterinary;
    private final String diagnostic;
    private final String symptoms;
    private final Date date;
    private ConsultaStatus status;


    Consulta(Builder builder) {
        this.id = builder.id;
        this.pet = builder.pet;
        this.veterinary = builder.veterinary;
        this.diagnostic = builder.diagnostic;
        this.symptoms = builder.symptoms;
        this.date = builder.date;
    }

    public static class Builder {
        private String id;
        private final Pet pet;
        private final Veterinario veterinary;

        private String diagnostic = "Diagnóstico não informado";
        private String symptoms = "Sintomas não informados";
        private Date date = new Date();

        public Builder(Pet pet, Veterinario veterinary) {
            if (pet == null || veterinary == null) {
                throw new IllegalArgumentException("Pet e Veterinário são obrigatórios");
            }
            this.pet = pet;
            this.veterinary = veterinary;
        }

        public Builder withId(String id) {
            this.id = id;
            return this;
        }

        public Builder withDiagnostic(String diagnostic) {
            this.diagnostic = diagnostic;
            return this;
        }

        public Builder withSymptoms(String symptoms) {
            this.symptoms = symptoms;
            return this;
        }

        public Builder withDate(Date date) {
            if (date != null) {
                this.date = new Date(date.getTime());
            }
            return this;
        }

        public Consulta build() {
            return new Consulta(this);
        }
    }
}