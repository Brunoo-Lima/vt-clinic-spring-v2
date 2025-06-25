package com.pfc.veterinaryclinic.facade;

import com.pfc.veterinaryclinic.entity.Tutor;
import com.pfc.veterinaryclinic.service.TutorService;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class TutorFacade {

    private final TutorService tutorService;

    public TutorFacade(TutorService tutorService) {
        this.tutorService = tutorService;
    }

    /**
     * Prepara o formulário para criação de tutor.
     */
    public void prepararFormularioCriacao(Model model) {
        model.addAttribute("tutor", new Tutor());
    }

    /**
     * Prepara o formulário de edição, carregando o tutor pelo ID.
     */
    public void prepararFormularioEdicao(String id, Model model) {
        Tutor tutor = tutorService.buscarPorId(id);
        model.addAttribute("tutor", tutor);
    }

    /**
     * Cria um novo tutor.
     */
    public void criarTutor(Tutor tutor) {
        tutorService.criarTutor(tutor);
    }

    /**
     * Atualiza os dados de um tutor existente.
     */
    public void atualizarTutor(String id, Tutor tutor) {
        tutorService.atualizar(id, tutor);
    }

    /**
     * Lista todos os tutores.
     */
    public List<Tutor> listarTodos() {
        return tutorService.listarTodas();
    }
}
