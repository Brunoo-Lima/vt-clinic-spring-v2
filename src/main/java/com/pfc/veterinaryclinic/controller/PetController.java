package com.pfc.veterinaryclinic.controller;

import com.pfc.veterinaryclinic.entity.Pet;
import com.pfc.veterinaryclinic.entity.Tutor;
import com.pfc.veterinaryclinic.service.PetService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pets")
public class PetController {

    @Autowired
    private PetService petService;

    @PostMapping
    public ResponseEntity<Pet> createPet(@RequestBody Pet pet) throws NotFoundException {
        Pet createdPet = petService.criarPet(pet);
        return new ResponseEntity<>(createdPet, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Pet>> getAllPets() {
        List<Pet> pets = petService.listarTodos();
        return ResponseEntity.ok(pets);
    }

    @GetMapping("/race")
    public ResponseEntity<List<Pet>> getPetById(@PathVariable String race) {
        List<Pet> pet = petService.buscarPorRaca(race);
        return ResponseEntity.ok(pet);
    }

    @GetMapping("/tutor")
    public ResponseEntity<List<Pet>> getPetsByTutor(@PathVariable Tutor tutor) {
        List<Pet> pets = petService.buscarPorTutor(tutor);
        return ResponseEntity.ok(pets);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pet> updatePet(@PathVariable String id, @RequestBody Pet petDetails) {
        Pet updatedPet = petService.atualizarPet(id, petDetails);
        return ResponseEntity.ok(updatedPet);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletePet(@PathVariable("id") String id) {
        petService.deletarPet(id);
        return ResponseEntity.noContent().build();
    }
}