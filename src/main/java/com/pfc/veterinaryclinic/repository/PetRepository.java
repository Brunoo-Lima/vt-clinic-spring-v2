package com.pfc.veterinaryclinic.repository;

import com.pfc.veterinaryclinic.entity.Pet;
import com.pfc.veterinaryclinic.entity.Tutor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetRepository extends MongoRepository<Pet, String> {

    List<Pet> findByName(String name);

    // Encontra pets por dono
    List<Pet> findByTutor(Tutor tutor);

    // Encontra pets por espécie
    List<Pet> findByRace(String race);

}