package com.pfc.veterinaryclinic.service;

import com.pfc.veterinaryclinic.entity.Tutor;
import com.pfc.veterinaryclinic.exception.TutorNotFoundException;
import com.pfc.veterinaryclinic.repository.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TutorService {
    @Autowired
    private TutorRepository tutorRepository;
//    @Autowired
//    private PetService petService;

    public Tutor criarTutor(Tutor tutor) {
        return tutorRepository.save(tutor);
    }

    public Tutor buscarPorNome(String name) {
        return tutorRepository.findByName(name);
    }

    public List<Tutor> listarTodas() {
        return tutorRepository.findAll();
    }

    public Tutor buscarPorId(String id) {
        return tutorRepository.findById(id)
                .orElseThrow(() -> new TutorNotFoundException("Tutor com ID " + id + " não encontrado"));
    }

    public Tutor atualizar(String id, Tutor tutor) {
        return tutorRepository.save(tutor);
    }

    public void deletar(String id) {
        Tutor tutor = buscarPorId(id);
        tutorRepository.delete(tutor);
    }
    
}
