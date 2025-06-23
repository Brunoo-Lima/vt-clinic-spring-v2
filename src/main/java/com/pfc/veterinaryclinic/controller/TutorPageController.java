package com.pfc.veterinaryclinic.controller;

import com.pfc.veterinaryclinic.entity.Tutor;
import com.pfc.veterinaryclinic.facade.TutorFacade;
import com.pfc.veterinaryclinic.singleton.ClinicLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/tutores")
public class TutorPageController {

    @Autowired
    private ClinicLogger clinicLogger;

    private final TutorFacade tutorFacade;

    public TutorPageController(TutorFacade tutorFacade) {
        this.tutorFacade = tutorFacade;
    }

    @GetMapping()
    public String tutores(Model model) {
        List<Tutor> tutores = tutorFacade.listarTodos();
        model.addAttribute("tutores", tutores);
        String fragment = "tutores :: content";
        model.addAttribute("content", fragment);
        clinicLogger.log("Tutores ");
        return "tutores";
    }

    @GetMapping("/criar-tutor")
    public String mostrarFormularioTutor(Model model) {
        tutorFacade.prepararFormularioCriacao(model);
        clinicLogger.log("Entrou no formulário de criar tutor");
        return "tutores/criar-tutor";

    }

    @GetMapping("/editar-tutor/{id}")
    public String editarFormularioTutores(@PathVariable("id") String id, Model model) {
        tutorFacade.prepararFormularioEdicao(id, model);
        clinicLogger.log("Entrou no formulário de editar tutor");
        return "tutores/editar-tutor";
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
