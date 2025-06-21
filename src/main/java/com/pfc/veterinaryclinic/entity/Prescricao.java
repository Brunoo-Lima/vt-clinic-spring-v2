package com.pfc.veterinaryclinic.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "prescricoes")
@Getter @Setter
public class Prescricao {
    public enum MedicationType {
        ANTIBIOTIC, ANTI_INFLAMMATORY, PAINKILLER, ANTIPARASITIC, OTHER
    }

    @Id
    private String id;
    private final Veterinario veterinary;
    private final Pet pet;
    private final String medicine;
    private final Date dateDescription;
    private final int durationDays;
    private final String dosage;
    private final MedicationType type;
    private final String instructions;

    private String consultaId;


    private Prescricao(Builder builder) {
        this.id = builder.id;
        this.pet = builder.pet;
        this.veterinary = builder.veterinary;
        this.medicine = builder.medicine;
        this.dosage = builder.dosage;
        this.durationDays = builder.durationDays;
        this.dateDescription = builder.dateDescription;
        this.type = builder.type;
        this.instructions = builder.instructions;
    }

    // Builder
    public static class Builder {
        private String id;
        private final Veterinario veterinary;
        private final String medicine;
        private Pet pet;
        private String dosage = "1x/dia";
        private int durationDays = 7;
        private Date dateDescription = new Date();
        private MedicationType type = MedicationType.OTHER;
        private String instructions = "Seguir orientações do veterinário";

        public Builder(Veterinario veterinary, String medicine) {
            if (veterinary == null || medicine == null || medicine.isBlank()) {
                throw new IllegalArgumentException("Veterinário e medicamento são obrigatórios");
            }
            this.veterinary = veterinary;
            this.medicine = medicine;
        }

        public Builder withId(String id) {
            this.id = id;
            return this;
        }

        public Builder forPet(Pet pet) {
            this.pet = pet;
            return this;
        }


        public Builder withDosage(String dosage) {
            this.dosage = dosage;
            return this;
        }

        public Builder withDurationDays(int durationDays) {
            if (durationDays <= 0) {
                throw new IllegalArgumentException("Duração deve ser positiva");
            }
            this.durationDays = durationDays;
            return this;
        }

        public Builder withDateDescription(Date dateDescription) {
            if (dateDescription != null) {
                this.dateDescription = new Date(dateDescription.getTime());
            }
            return this;
        }

        public Builder withType(MedicationType type) {
            this.type = type;
            return this;
        }

        public Builder withInstructions(String instructions) {
            this.instructions = instructions;
            return this;
        }

        public Prescricao build() {
            validate();
            return new Prescricao(this);
        }


        private void validate() {
            if (pet == null) {
                throw new IllegalStateException("Pet é obrigatório para a prescrição");
            }
            if (dosage == null || dosage.isBlank()) {
                throw new IllegalStateException("Dosagem não pode ser vazia");
            }
            if (durationDays <= 0) {
                throw new IllegalStateException("Duração deve ser positiva");
            }
        }
    }
}
