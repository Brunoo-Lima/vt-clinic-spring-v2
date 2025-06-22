package com.pfc.veterinaryclinic.entity;

import com.pfc.veterinaryclinic.enums.ConsultaStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

//consulta medica
@Document(collection = "consultas")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Consulta {
    @Id
    private String id;
    private Pet pet;
    private Tutor tutor;
    private Veterinario veterinary;
    private String diagnostic;
    private String symptoms;

    private LocalDateTime date;
    private ConsultaStatus status;


    Consulta(Builder builder) {
        this.id = builder.id;
        this.pet = builder.pet;
        this.tutor = builder.tutor;
        this.veterinary = builder.veterinary;
        this.diagnostic = builder.diagnostic;
        this.symptoms = builder.symptoms;
        this.date = builder.date;
    }

    public static class Builder {
        private String id;
        private Pet pet;
        private Veterinario veterinary;
        private Tutor tutor;
        private String diagnostic = "Diagnóstico não informado";
        private String symptoms = "Sintomas não informados";
        private LocalDateTime date = LocalDateTime.now();

        public Builder () {}

        public Builder(Pet pet, Tutor tutor, Veterinario veterinary) {
            if (pet == null || tutor == null || veterinary == null) {
                throw new IllegalArgumentException("Pet e Veterinário são obrigatórios");
            }
            this.pet = pet;
            this.veterinary = veterinary;
            this.tutor = tutor;
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

        public Builder withDate(LocalDateTime date) {
            if (date != null) {
                this.date = date;
            }
            return this;
        }

        public Consulta build() {
            return new Consulta(this);
        }
    }
}