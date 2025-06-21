package com.pfc.veterinaryclinic.repository;

import com.pfc.veterinaryclinic.entity.Veterinario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VeterinarioRepository extends MongoRepository<Veterinario, String> {

    // Encontra veterinário por CRMV
    List<Veterinario> findByName(String name);

    // Encontra veterinário por CRMV
    List<Veterinario> findByCrmv(String crmv);

    // Encontra veterinários por especialização
    List<Veterinario> findBySpecialty(String specialty);

    // Encontra veterinários disponíveis em um determinado dia
    List<Veterinario> findByAvailable(boolean available);

    // Verifica se existe veterinário com determinado CRMV
    boolean existsByCrmv(String crmv);

//    // Encontra veterinários por lista de IDs
//    List<Veterinario> findByIdIn(List<String> ids);
}