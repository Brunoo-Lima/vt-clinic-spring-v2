package com.pfc.veterinaryclinic.controller;

import com.pfc.veterinaryclinic.entity.Veterinario;
import com.pfc.veterinaryclinic.facade.VeterinarioFacade;
import com.pfc.veterinaryclinic.singleton.ClinicLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/veterinarios")
public class VeterinarioPageController {
    @Autowired
    private ClinicLogger clinicLogger;

    private final VeterinarioFacade veterinarioFacade;

    public VeterinarioPageController(VeterinarioFacade veterinarioFacade) {
        this.veterinarioFacade = veterinarioFacade;
    }

    @GetMapping()
    public String veterinarios(Model model) {
        List<Veterinario> veterinarios = veterinarioFacade.listarTodos();
        model.addAttribute("veterinarios", veterinarios);

        String fragment = "veterinarios :: content";
        model.addAttribute("content", fragment);

        clinicLogger.log("Veterinários");
        return "veterinarios";
    }

    @GetMapping("/criar-veterinario")
    public String mostrarFormularioVeterinario(Model model) {
        veterinarioFacade.prepararFormularioCriacao(model);
        clinicLogger.log("Entrou no formulário de criar veterinário");
        return "veterinarios/criar-veterinario";

    }

    @GetMapping("/editar-veterinario/{id}")
    public String editarFormularioVeterinario(@PathVariable("id") String id, Model model) {
        veterinarioFacade.prepararFormularioEdicao(id, model);
        clinicLogger.log("Entrou no formulário de editar veterinário");
        return "veterinarios/editar-veterinario";
    }

    @PostMapping()
    public String salvarVeterinario(@ModelAttribute Veterinario veterinario) {
        veterinarioFacade.criarVeterinario(veterinario);
        return "redirect:/veterinarios";
    }

    @PostMapping("/editar/{id}")
    public String updateVeterinarian(@PathVariable("id") String id, @ModelAttribute Veterinario veterinario) {
        veterinarioFacade.atualizarVeterinario(id, veterinario);
        return "redirect:/veterinarios";
    }

}
