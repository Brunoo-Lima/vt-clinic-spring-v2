//package com.pfc.veterinaryclinic.controller;
//
//import com.pfc.veterinaryclinic.entity.Medicamento;
//import com.pfc.veterinaryclinic.service.MedicamentoService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/api/medicamentos")
//public class MedicamentoController {
//
//    @Autowired
//    private MedicamentoService medicineService;
//
//    @PostMapping
//    public ResponseEntity<Medicamento> createMedicine(@RequestBody Medicamento medicine) {
//        Medicamento createdMedicine = medicineService.criarMedicamento(medicine);
//        return new ResponseEntity<>(createdMedicine, HttpStatus.CREATED);
//    }
//
//    @GetMapping
//    public ResponseEntity<List<Medicamento>> getAllMedicines() {
//        List<Medicamento> medicines = medicineService.listarTodos();
//        return ResponseEntity.ok(medicines);
//    }
//
////    @GetMapping("/{id}")
////    public ResponseEntity<Optional<Medicamento>> getMedicineById(@PathVariable String id) {
////        Medicamento medicine = medicineService.buscarPorId(id);
////        return ResponseEntity.ok(medicine);
////    }
//
////    @GetMapping("/search")
////    public ResponseEntity<List<Medicamento>> searchMedicinesByName(@RequestParam String name) {
////        List<Medicamento> medicines = medicineService.searchMedicinesByName(name);
////        return ResponseEntity.ok(medicines);
////    }
//
////    @GetMapping("/category/{category}")
////    public ResponseEntity<List<Medicamento>> getMedicinesByCategory(@PathVariable String category) {
////        List<Medicamento> medicines = medicineService.getMedicinesByCategory(category);
////        return ResponseEntity.ok(medicines);
////    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Medicamento> updateMedicine(
//            @PathVariable String id,
//            @RequestBody Medicamento medicineDetails) {
//        Medicamento medicine = medicineService.atualizarMedicamento(id, medicineDetails);
//        return ResponseEntity.ok(medicine);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteMedicine(@PathVariable String id) {
//        medicineService.deletarMedicamento(id);
//        return ResponseEntity.noContent().build();
//    }
//}
