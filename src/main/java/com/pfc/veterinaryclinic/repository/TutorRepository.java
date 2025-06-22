package com.pfc.veterinaryclinic.repository;

import com.pfc.veterinaryclinic.entity.Tutor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TutorRepository extends MongoRepository<Tutor, String> {

    // Busca donos por nome (case insensitive)
   Tutor findByName(String name);

    // Consulta customizada para donos com pets de determinada espécie
//    @Query("{ 'petIds': { $in: ?0 } }")
//    List<Tutor> findByPetIdsIn(List<String> petIds);

}