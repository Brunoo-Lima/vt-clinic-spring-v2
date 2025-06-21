package com.pfc.veterinaryclinic.repository;

import com.pfc.veterinaryclinic.entity.Consulta;
import com.pfc.veterinaryclinic.entity.Pet;
import com.pfc.veterinaryclinic.entity.Veterinario;
import com.pfc.veterinaryclinic.enums.ConsultaStatus;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ConsultaRepository extends MongoRepository<Consulta, String> {

    // Encontra consultas por pet
    List<Consulta> findByPet(Pet pet);

    // Encontra consultas por veterinário
    List<Consulta> findByVeterinary(Veterinario veterinary);

    // Encontra consultas por status
    List<Consulta> findByStatus(ConsultaStatus status);

    // Encontra consultas entre datas
//    List<Consulta> findByDateTimeBetween(LocalDateTime start, LocalDateTime end);


}