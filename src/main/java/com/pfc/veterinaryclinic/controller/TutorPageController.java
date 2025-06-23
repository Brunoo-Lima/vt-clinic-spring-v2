package com.pfc.veterinaryclinic.controller;

import com.pfc.veterinaryclinic.entity.Tutor;
import com.pfc.veterinaryclinic.facade.TutorFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/tutores")
public class TutorPageController {

    private static final Logger log = LoggerFactory.getLogger(PetPageController.class);

    private final TutorFacade tutorFacade;

    public TutorPageController(TutorFacade tutorFacade) {
        this.tutorFacade = tutorFacade;
    }

    @GetMapping()
    public String tutores(Model model) {
        List<Tutor> tutores = tutorFacade.listarTodos();
        model.addAttribute("tutores", tutores);
        String fragment = "tutores :: content";
        log.info("Carregando fragmento: {}", fragment);
        model.addAttribute("content", fragment);
        return "tutores";
    }

    @GetMapping("/criar-tutor")
    public String mostrarFormularioTutor(Model model) {
        tutorFacade.prepararFormularioCriacao(model);
        log.info("Entrou no formulário de criar tutor");
        // Retorna o template Thymeleaf
        return "tutores/criar-tutor";

    }

    @GetMapping("/editar-tutor/{id}")
    public String editarFormularioTutores(@PathVariable("id") String id, Model model) {
        tutorFacade.prepararFormularioEdicao(id, model);
        log.info("Entrou no formulário de editar tutor para id: {}", id);
        return "tutores/editar-tutor"; // nome do template Thymeleaf
    }

    @PostMapping()
    public String salvarTutor(@ModelAttribute Tutor tutor) {
        tutorFacade.criarTutor(tutor);
        return "redirect:/tutores";
    }

    @PostMapping("/editar/{id}")
    public String updateTutor(@PathVariable("id") String id, @ModelAttribute Tutor tutor) {
        tutorFacade.atualizarTutor(id, tutor);
        return "redirect:/tutores";
    }

}
