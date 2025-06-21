package com.pfc.veterinaryclinic.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

//historico medico
@Document(collection = "historicosMedico")
public class HistoricoMedico {
    @Id
    private String id;
    private final Pet pet;
    private List<Consulta> medicalConsultations;
    private List<Prescricao> medicalPrescriptions;


    public HistoricoMedico(Pet pet) {
        this.pet = pet;
        this.medicalConsultations = new ArrayList<>();
        this.medicalPrescriptions = new ArrayList<>();
    }

    public HistoricoMedico(String id, Pet pet) {
        this.id = id;
        this.pet = pet;
        this.medicalConsultations = new ArrayList<>();
        this.medicalPrescriptions = new ArrayList<>();
    }

    public HistoricoMedico(String id, Pet pet, List<Consulta> consultations, List<Prescricao> prescriptions) {
        this.id = id;
        this.pet = pet;
        this.medicalConsultations = new ArrayList<>(consultations);
        this.medicalPrescriptions = new ArrayList<>(prescriptions);
    }

    public void addConsultation(Consulta medicalConsultation) {
        if (medicalConsultation != null && medicalConsultation.getPet().equals(pet)) {
            medicalConsultations.add(medicalConsultation);
        }
    }

    public void addPrescription(Prescricao prescription) {
        if (prescription != null && prescription.getPet().equals(pet)) {
            medicalPrescriptions.add(prescription);
        }
    }

    public List<Prescricao> getPrescriptionList() {
        return Collections.unmodifiableList(medicalPrescriptions);
    }

    public List<Consulta> getConsultaList() {
        return Collections.unmodifiableList(medicalConsultations);
    }

    public String getId() {
        return id;
    }

    public Pet getPet() {
        return pet;
    }

    public Optional<Consulta> getLastConsultation() {
        if (medicalConsultations.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(medicalConsultations.get(medicalConsultations.size() - 1));
    }

    public Optional<Prescricao> getLastPrescription() {
        if (medicalPrescriptions.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(medicalPrescriptions.get(medicalPrescriptions.size() - 1));
    }
}
