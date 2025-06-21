package com.pfc.veterinaryclinic.repository;

import com.pfc.veterinaryclinic.entity.Pet;
import com.pfc.veterinaryclinic.entity.Tutor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
//
@Repository
public interface PetRepository extends MongoRepository<Pet, String> {

    List<Pet> findByName(String name);

    // Encontra pets por dono
    List<Pet> findByTutor(Tutor tutor);

    // Encontra pets por espécie
    List<Pet> findByRace(String race);

//    // Consulta customizada para pets com histórico médico contendo termo
////    @Query("{ 'medicalHistory': { $regex: ?0, $options: 'i' } }")
//    List<Pet> findByMedicalHistoryContaining(String term);
//

}