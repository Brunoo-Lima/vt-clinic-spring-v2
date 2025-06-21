//package com.pfc.veterinaryclinic.service;
//
//import com.pfc.veterinaryclinic.entity.Medicamento;
//import com.pfc.veterinaryclinic.repository.MedicamentoRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class MedicamentoService {
//
//    @Autowired
//    private MedicamentoRepository medicineRepository;
//
//
//    public MedicamentoService(MedicamentoRepository medicineRepository) {
//        this.medicineRepository = medicineRepository;
//    }
//
//    public Medicamento criarMedicamento(Medicamento medicamento) {
//        return medicineRepository.save(medicamento);
//    }
//
//    public Medicamento atualizarMedicamento(String id, Medicamento medicamento) {
//        if (!medicineRepository.existsById(id)) {
//            throw new RuntimeException("Medicamento não encontrado");
//        }
//        medicamento.setId(id);
//        return medicineRepository.save(medicamento);
//    }
//
//    public void deletarMedicamento(String id) {
//        medicineRepository.deleteById(id);
//    }
//
//    public Optional<Medicamento> buscarPorId(String id) {
//        return medicineRepository.findById(id);
//    }
//
//    public List<Medicamento> listarTodos() {
//        return medicineRepository.findAll();
//    }
//
//}