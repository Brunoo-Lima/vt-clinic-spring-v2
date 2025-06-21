//package com.pfc.veterinaryclinic.controller;
//
//import com.pfc.veterinaryclinic.entity.HistoricoMedico;
//import com.pfc.veterinaryclinic.service.HistoricoMedicoService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api/registros-medicos")
//public class HistoricoMedicoController {
//
//    @Autowired
//    private HistoricoMedicoService historicoMedicoService;
//
//    @PostMapping("/pet/{petId}")
//    public ResponseEntity<HistoricoMedico> createMedicalRecord(@PathVariable String petId) {
//        HistoricoMedico record = historicoMedicoService.createMedicalRecord(petId);
//        return new ResponseEntity<>(record, HttpStatus.CREATED);
//    }
//
//    @GetMapping("/pet/{petId}")
//    public ResponseEntity<HistoricoMedico> getMedicalRecordByPetId(@PathVariable String petId) {
//        HistoricoMedico record = historicoMedicoService.getMedicalRecordByPetId(petId);
//        return ResponseEntity.ok(record);
//    }
//
//    @PutMapping("/{id}/add-vaccine")
//    public ResponseEntity<HistoricoMedico> addVaccine(
//            @PathVariable String id,
//            @RequestParam String vaccine) {
//        HistoricoMedico record = historicoMedicoService.addVaccineToRecord(id, vaccine);
//        return ResponseEntity.ok(record);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<HistoricoMedico> updateMedicalRecord(
//            @PathVariable String id,
//            @RequestBody HistoricoMedico recordDetails) {
//        HistoricoMedico record = historicoMedicoService.updateMedicalRecord(id, recordDetails);
//        return ResponseEntity.ok(record);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteMedicalRecord(@PathVariable String id) {
//        historicoMedicoService.deleteMedicalRecord(id);
//        return ResponseEntity.noContent().build();
//    }
//}