package com.pfc.veterinaryclinic.controller;

import com.pfc.veterinaryclinic.entity.Pet;
import com.pfc.veterinaryclinic.facade.PetFacade;
import com.pfc.veterinaryclinic.singleton.ClinicLogger;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;

@Controller
@RequestMapping("/pets")
public class PetPageController {

    @Autowired
    private ClinicLogger clinicLogger;

    private final PetFacade petFacade;

    public PetPageController(PetFacade petFacade) {
        this.petFacade = petFacade;
    }

    @GetMapping
    public String pets(Model model) {
        List<Pet> pets = petFacade.listarTodos();
        model.addAttribute("pets", pets);
        String fragment = "pets :: content";
        clinicLogger.log("Pets");
        model.addAttribute("content", fragment);
        return "pets";
    }

    @GetMapping("/criar-pet")
    public String mostrarFormularioPet(Model model) {
        petFacade.prepararFormularioCriacao(model);
        clinicLogger.log("Entrou no formulário de salvar pet");
        return "pets/criar-pet";
    }

    @GetMapping("/editar-pet/{id}")
    public String editarFormularioPet(@PathVariable("id") String id, Model model) {
        petFacade.prepararFormularioEdicao(id, model);
        clinicLogger.log("Entrou no formulário de editar pet");
        return "pets/editar-pet";
    }

    @PostMapping
    public String salvarPet(@ModelAttribute Pet pet) throws NotFoundException {
        petFacade.criarPet(pet);
        return "redirect:/pets";
    }

    @PostMapping("/editar/{id}")
    public String atualizarPet(@PathVariable("id") String id, @ModelAttribute Pet pet) {
        petFacade.atualizarPet(id, pet);
        return "redirect:/pets";
    }
}
