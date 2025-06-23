package com.pfc.veterinaryclinic.controller;

import com.pfc.veterinaryclinic.entity.Veterinario;
import com.pfc.veterinaryclinic.facade.VeterinarioFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/veterinarios")
public class VeterinarioPageController {
    private static final Logger log = LoggerFactory.getLogger(PetPageController.class);

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
        return "veterinarios";
    }

    @GetMapping("/criar-veterinario")
    public String mostrarFormularioVeterinario(Model model) {
        veterinarioFacade.prepararFormularioCriacao(model);
        log.info("Entrou no formulário de criar veterinário");
        return "veterinarios/criar-veterinario";

    }

    @GetMapping("/editar-veterinario/{id}")
    public String editarFormularioVeterinario(@PathVariable("id") String id, Model model) {
        veterinarioFacade.prepararFormularioEdicao(id, model);
        log.info("Entrou no formulário de editar veterinário para id: {}", id);
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
