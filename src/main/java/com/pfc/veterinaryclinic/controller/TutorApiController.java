package com.pfc.veterinaryclinic.controller;

import com.pfc.veterinaryclinic.entity.Tutor;
import com.pfc.veterinaryclinic.service.TutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tutores")
public class TutorApiController {

    @Autowired
    private TutorService ownerService;

    @PostMapping
    public ResponseEntity<Tutor> createOwner(@RequestBody Tutor tutor) {
        Tutor createdOwner = ownerService.criarTutor(tutor);
        return new ResponseEntity<>(createdOwner, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Tutor>> getAllOwners() {
        List<Tutor> owners = ownerService.listarTodas();
        return ResponseEntity.ok(owners);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tutor> getOwnerById(@PathVariable String id) {
        Tutor owner = ownerService.buscarPorId(id);
        return ResponseEntity.ok(owner);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Tutor> updateOwner(@PathVariable String id, @RequestBody Tutor tutorDetails) {
        Tutor updatedOwner = ownerService.atualizar(id, tutorDetails);
        return ResponseEntity.ok(updatedOwner);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deleteOwner(@PathVariable("id") String id) {
        ownerService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}