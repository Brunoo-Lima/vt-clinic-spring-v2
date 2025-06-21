//package com.pfc.veterinaryclinic.repository;
//
//import com.pfc.veterinaryclinic.entity.Medicamento;
//import org.springframework.data.mongodb.repository.MongoRepository;
//import org.springframework.data.mongodb.repository.Query;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public interface MedicamentoRepository extends MongoRepository<Medicamento, String> {
//
//    // Busca medicamentos por nome (case insensitive)
//    List<Medicamento> findByNameContainingIgnoreCase(String name);
//
//    // Encontra medicamentos por categoria
//    List<Medicamento> findByCategory(String category);
//
//    // Encontra medicamentos controlados
//    List<Medicamento> findByControlled(boolean controlled);
//
//    // Consulta customizada para busca por princípio ativo
////    @Query("{ 'activePrinciple': { $regex: ?0, $options: 'i' } }")
//    List<Medicamento> findByActivePrincipleContaining(String activePrinciple);
//
//    // Encontra medicamentos por fabricante
//    List<Medicamento> findByManufacturer(String manufacturer);
//}
