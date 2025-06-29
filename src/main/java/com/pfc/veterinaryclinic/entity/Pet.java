package com.pfc.veterinaryclinic.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection = "pets")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pet {
    @Id
    private String id;
    private String name;
    private Tutor tutor;
    private int age;
    private String gate;
    private String race;
    private HistoricoMedico historic;

    public Pet(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.tutor = builder.tutor;
        this.age = builder.age;
        this.gate = builder.gate;
        this.race = builder.race;
        this.historic = builder.historic;
    }

    public static class Builder {
        private String id;
        private String name;
        private Tutor tutor;
        private int age = 0;
        private String gate;
        private String race = "Unknown";
        private HistoricoMedico historic;

        public Builder() {
        }

        public Builder(String name, Tutor tutor) {
            this.name = name;
            this.tutor = tutor;
        }

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder gate(String gate) {
            this.gate = gate;
            return this;
        }

        public Builder race(String race) {
            this.race = race;
            return this;
        }

        public Builder historic(HistoricoMedico historic) {
            this.historic = historic;
            return this;
        }

        public Pet build() {
            return new Pet(this);
        }
    }
}
