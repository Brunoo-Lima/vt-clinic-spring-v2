package com.pfc.veterinaryclinic.controller;

import com.pfc.veterinaryclinic.entity.Pet;
import com.pfc.veterinaryclinic.facade.PetFacade;
import com.pfc.veterinaryclinic.service.PetService;
import javassist.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;

@Controller
@RequestMapping("/pets")
public class PetPageController {
    private static final Logger log = LoggerFactory.getLogger(PetPageController.class);

    private final PetService petService;
    private final PetFacade petFacade;


    public PetPageController(PetService petService, PetFacade petFacade) {
        this.petService = petService;
        this.petFacade = petFacade;
    }

    @GetMapping
    public String pets(Model model) {
        List<Pet> pets = petService.listarTodos();
        model.addAttribute("pets", pets);
        String fragment = "pets :: content";
        log.info("Carregando fragmento: {}", fragment); // Log para depuração
        model.addAttribute("content", fragment);
        return "pets";
    }

    @GetMapping("/criar-pet")
    public String mostrarFormularioPet(Model model) {
        petFacade.prepararFormularioCriacao(model);
        log.info("Entrou no formulário de salvar pet");
        return "pets/criar-pet";
    }

    @GetMapping("/editar-pet/{id}")
    public String editarFormularioPet(@PathVariable("id") String id, Model model) {
        petFacade.prepararFormularioEdicao(id, model);
        log.info("Entrou no formulário de editar pet para id: {}", id);
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
