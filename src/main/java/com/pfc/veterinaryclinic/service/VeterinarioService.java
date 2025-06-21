package com.pfc.veterinaryclinic.service;

import com.pfc.veterinaryclinic.entity.Veterinario;
import com.pfc.veterinaryclinic.exception.VeterinarioNotFoundException;
import com.pfc.veterinaryclinic.repository.VeterinarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class VeterinarioService {

    @Autowired
    private VeterinarioRepository veterinarioRepository;

    public Veterinario criarVeterinario(Veterinario veterinario) {
        return veterinarioRepository.save(veterinario);
    }

    public List<Veterinario> listarTodas() {
        return veterinarioRepository.findAll();
    }

    public Veterinario buscarPorId(String id) {
        return veterinarioRepository.findById(id)
                .orElseThrow(() -> new VeterinarioNotFoundException("Veterinario com ID " + id + " não encontrado"));
    }

    public Veterinario atualizar(String id, Veterinario veterinario) {
        Veterinario existente = buscarPorId(id);

        existente.setName(veterinario.getName());
        existente.setCrmv(veterinario.getCrmv());
        existente.setSpecialty(veterinario.getSpecialty());
        existente.setAvailable(veterinario.isAvailable());

        return veterinarioRepository.save(existente);
    }

    public void deletar(String id) {
        Veterinario veterinario = buscarPorId(id);
        veterinarioRepository.delete(veterinario);
    }

    public List<Veterinario> buscarPorCRMV(String crmv) {
        return veterinarioRepository.findByCrmv(crmv);
    }

    // Encontra veterinários por especialização
    public List<Veterinario> buscarPorEspecializacao(String specialty) {
        return veterinarioRepository.findBySpecialty(specialty);
    }
}