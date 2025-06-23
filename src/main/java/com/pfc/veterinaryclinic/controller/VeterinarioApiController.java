package com.pfc.veterinaryclinic.controller;

import com.pfc.veterinaryclinic.entity.Veterinario;
import com.pfc.veterinaryclinic.service.VeterinarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/veterinarios")
public class VeterinarioApiController {

    @Autowired
    private VeterinarioService veterinarioService;

    @PostMapping()
    public ResponseEntity<Veterinario> createVeterinarian(@RequestBody Veterinario veterinarian) {
        Veterinario createdVeterinarian = veterinarioService.criarVeterinario(veterinarian);
        return new ResponseEntity<>(createdVeterinarian, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Veterinario>> getAllVeterinarians() {
        List<Veterinario> veterinarians = veterinarioService.listarTodas();
        return ResponseEntity.ok(veterinarians);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Veterinario> getVeterinarianById(@PathVariable String id) {
        Veterinario veterinarian = veterinarioService.buscarPorId(id);
        return ResponseEntity.ok(veterinarian);
    }

    @GetMapping("/specialty")
    public ResponseEntity<List<Veterinario>> getVeterinarianSpecialty(@PathVariable String specialty) {
        List<Veterinario> veterinarian = veterinarioService.buscarPorEspecializacao(specialty);
        return ResponseEntity.ok(veterinarian);
    }

    @GetMapping("/crmv/{crmv}")
    public ResponseEntity<List<Veterinario>> getVeterinarianByCrmv(@PathVariable String crmv) {
        List<Veterinario> veterinarian = veterinarioService.buscarPorCRMV(crmv);
        return ResponseEntity.ok(veterinarian);
    }

    @PostMapping("/editar/{id}")
    public String updateVeterinarian(@PathVariable("id") String id, @ModelAttribute Veterinario veterinarioDetails) {
        veterinarioService.atualizar(id, veterinarioDetails);
        return "redirect:/veterinarios";
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deleteVeterinarian(@PathVariable("id") String id) {
        veterinarioService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}