package com.pfc.veterinaryclinic.repository;

import com.pfc.veterinaryclinic.entity.Tutor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TutorRepository extends MongoRepository<Tutor, String> {

    // Busca donos por nome
    Tutor findByName(String name);

}