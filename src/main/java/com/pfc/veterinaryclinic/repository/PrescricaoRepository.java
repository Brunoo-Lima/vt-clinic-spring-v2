//package com.pfc.veterinaryclinic.repository;
//
//import com.pfc.veterinaryclinic.entity.Consulta;
//import com.pfc.veterinaryclinic.entity.Prescricao;
//import org.springframework.data.mongodb.repository.MongoRepository;
//import org.springframework.data.mongodb.repository.Query;
//import org.springframework.stereotype.Repository;
//
//import java.time.LocalDate;
//import java.util.List;
//
//@Repository
//public interface PrescricaoRepository extends MongoRepository<Prescricao, String> {
//
//    // Encontra prescrições por consulta
//    List<Prescricao> findByAppointment(Consulta appointment);
//
//    // Encontra prescrições ativas (não expiradas)
////    @Query("{ 'expirationDate': { $gte: ?0 } }")
//    List<Prescricao> findActivePrescriptions(LocalDate currentDate);
//
//    // Encontra prescrições por medicamento
////    @Query("{ 'items.medicineId': ?0 }")
//    List<Prescricao> findByMedicine(String medicineId);
//
//    // Encontra prescrições por consulta e data de expiração
//    List<Prescricao> findByAppointmentIdAndExpirationDateAfter(String appointmentId, LocalDate date);
//
//    List<Prescricao> findByAppointmentIdInAndExpirationDateAfter(
//            List<String> appointmentIds,
//            LocalDate expirationDate
//    );
//}