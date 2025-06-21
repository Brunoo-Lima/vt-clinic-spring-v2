//package com.pfc.veterinaryclinic.service;
//
//import com.pfc.veterinaryclinic.entity.Consulta;
//import com.pfc.veterinaryclinic.entity.Prescricao;
//import com.pfc.veterinaryclinic.exception.PrescricaoNotFoundException;
//import com.pfc.veterinaryclinic.repository.PrescricaoRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class PrescricaoService {
//
//    @Autowired
//    private PrescricaoRepository prescricaoRepository;
//
//    // Buscar todas as prescrições
//    public List<Prescricao> listarTodas() {
//        return prescricaoRepository.findAll();
//    }
//
//    // Buscar uma prescrição por ID
//    public Prescricao buscarPorId(String id) {
//        return prescricaoRepository.findById(id)
//                .orElseThrow(() -> new PrescricaoNotFoundException("Prescrição com ID " + id + " não encontrada"));
//    }
//
//    // Buscar prescrições por agendamento
//    public List<Prescricao> buscarPorAgendamento(Consulta consulta) {
//        return prescricaoRepository.findByAppointment(consulta);
//    }
//
//    // Criar uma nova prescrição
//    public Prescricao criarPrescricao(Prescricao prescricao, Consulta consulta) {
//        prescricao.setConsultaId(consulta.getId());
//        return prescricaoRepository.save(prescricao);
//    }
//
//    // Atualizar uma prescrição existente
//    public Prescricao atualizar(String id, Prescricao novaPrescricao) {
//        Prescricao existente = buscarPorId(id);
//
//        return prescricaoRepository.save(existente);
//    }
//
//    // Excluir uma prescrição
//    public void deletar(String id) {
//        Prescricao prescricao = buscarPorId(id);
//        prescricaoRepository.delete(prescricao);
//    }
//
//    // Buscar prescrições por data
//    public List<Prescricao> buscarPorMedicamentoId(String id) {
//        return prescricaoRepository.findByMedicine(id);
//    }
//}