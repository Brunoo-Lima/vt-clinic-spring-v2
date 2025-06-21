package com.pfc.veterinaryclinic.service;

import com.pfc.veterinaryclinic.entity.Consulta;
import com.pfc.veterinaryclinic.entity.Pet;
import com.pfc.veterinaryclinic.entity.Veterinario;
import com.pfc.veterinaryclinic.enums.ConsultaStatus;
import com.pfc.veterinaryclinic.repository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsultaService {
    @Autowired
    private ConsultaRepository consultaRepository;

    public ConsultaService(ConsultaRepository consultaRepository) {
        this.consultaRepository = consultaRepository;
    }

    public Consulta criarConsulta(Consulta consulta) {
        return consultaRepository.save(consulta);
    }

    public Consulta atualizarConsulta(String id, Consulta consulta) {
        if (!consultaRepository.existsById(id)) {
            throw new RuntimeException("Consulta não encontrado");
        }
        consulta.setId(id);
        return consultaRepository.save(consulta);
    }

    public void deletarConsulta(String id) {
        consultaRepository.deleteById(id);
    }

    public Optional<Consulta> buscarPorId(String id) {
        return consultaRepository.findById(id);
    }

    public List<Consulta> listarTodos() {
        return consultaRepository.findAll();
    }

//     Buscar consulta por ID
    public Optional<Consulta> buscarConsultaPorId(String id) {
        return consultaRepository.findById(id);
    }

//     Buscar consultas por pet
    public List<Consulta> buscarPorPet(Pet pet) {
        return consultaRepository.findByPet(pet);
    }

//     Buscar consultas por veterinário
    public List<Consulta> buscarPorVeterinario(Veterinario veterinary) {
        return consultaRepository.findByVeterinary(veterinary);
    }

//     Buscar consultas por status
    public List<Consulta> buscarPorStatus(ConsultaStatus status) {
        return consultaRepository.findByStatus(status);
    }

}