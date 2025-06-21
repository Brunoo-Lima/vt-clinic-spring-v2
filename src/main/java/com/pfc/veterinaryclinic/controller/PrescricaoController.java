//package com.pfc.veterinaryclinic.controller;
//
//import com.pfc.veterinaryclinic.entity.Consulta;
//import com.pfc.veterinaryclinic.entity.Pet;
//import com.pfc.veterinaryclinic.entity.Prescricao;
//import com.pfc.veterinaryclinic.service.PrescricaoService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/prescricoes")
//public class PrescricaoController {
//
//    @Autowired
//    private PrescricaoService prescriptionService;
//
//    @PostMapping("/appointment/{appointmentId}")
//    public ResponseEntity<Prescricao> createPrescription(
//            @PathVariable Consulta appointment,
//            @RequestBody Prescricao prescription) {
//        Prescricao createdPrescription = prescriptionService.criarPrescricao(prescription,appointment);
//        return new ResponseEntity<>(createdPrescription, HttpStatus.CREATED);
//    }
//
//    @GetMapping("/appointment/{appointmentId}")
//    public ResponseEntity<List<Prescricao>> getPrescriptionsByAppointment(@RequestBody Consulta consulta) {
//        List<Prescricao> prescriptions = prescriptionService.buscarPorAgendamento(consulta);
//        return ResponseEntity.ok(prescriptions);
//    }
//
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Prescricao> updatePrescription(
//            @PathVariable String id,
//            @RequestBody Prescricao prescriptionDetails) {
//        Prescricao prescription = prescriptionService.atualizar(id, prescriptionDetails);
//        return ResponseEntity.ok(prescription);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deletePrescription(@PathVariable String id) {
//        prescriptionService.deletar(id);
//        return ResponseEntity.noContent().build();
//    }
//}