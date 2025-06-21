//package com.pfc.veterinaryclinic.repository;
//
//
//import com.pfc.veterinaryclinic.entity.HistoricoMedico;
//import org.springframework.data.mongodb.repository.MongoRepository;
//import org.springframework.data.mongodb.repository.Query;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//import java.util.Optional;
//
//@Repository
//public interface HistoricoMedicoRepository extends MongoRepository<HistoricoMedico, String> {
//
//    // Encontra prontuário por pet
//    Optional<HistoricoMedico> findByPetId(String petId);
//
//    // Consulta customizada para prontuários com determinadas condições
////    @Query("{ 'chronicConditions': { $in: ?0 } }")
//    List<HistoricoMedico> findByChronicConditions(List<String> conditions);
//
//    // Verifica se pet já possui prontuário
//    boolean existsByPetId(String petId);
//}