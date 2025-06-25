package com.pfc.veterinaryclinic.service;

import com.pfc.veterinaryclinic.entity.Pet;
import com.pfc.veterinaryclinic.entity.Tutor;
import com.pfc.veterinaryclinic.exception.PetNotFoundException;
import com.pfc.veterinaryclinic.repository.PetRepository;
import com.pfc.veterinaryclinic.repository.TutorRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PetService {

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private TutorRepository tutorRepository;


    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    public Pet criarPet(Pet pet) throws NotFoundException {
        Tutor tutorCompleto = tutorRepository.findById(pet.getTutor().getId()).orElseThrow(() -> new NotFoundException("Ta isso"));
        pet.setTutor(tutorCompleto);
        return petRepository.save(pet);
    }

    public Pet atualizarPet(String id, Pet pet) {
        if (!petRepository.existsById(id)) {
            throw new RuntimeException("Medicamento não encontrado");
        }
        pet.setId(id);
        return petRepository.save(pet);
    }

    public void deletarPet(String id) {
        petRepository.deleteById(id);
    }

    public Pet buscarPorId(String id) {
        return petRepository.findById(id)
                .orElseThrow(() -> new PetNotFoundException("Pet com ID " + id + " não encontrado"));
    }

    public List<Pet> listarTodos() {
        return petRepository.findAll();
    }

    // Encontra pets por dono
    public List<Pet> buscarPorTutor(Tutor tutor) {
        return petRepository.findByTutor(tutor);
    }

    // Encontra pets por espécie
    public List<Pet> buscarPorRaca(String race) {
        return petRepository.findByRace(race);
    }
}