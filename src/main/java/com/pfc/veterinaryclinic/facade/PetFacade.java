package com.pfc.veterinaryclinic.facade;

import com.pfc.veterinaryclinic.entity.Pet;
import com.pfc.veterinaryclinic.entity.Tutor;
import com.pfc.veterinaryclinic.service.PetService;
import com.pfc.veterinaryclinic.service.TutorService;
import javassist.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class PetFacade {

    private final PetService petService;
    private final TutorService tutorService;

    public PetFacade(PetService petService, TutorService tutorService) {
        this.petService = petService;
        this.tutorService = tutorService;
    }

    /**
     * Prepara o formulário para criar um novo pet.
     */
    public void prepararFormularioCriacao(Model model) {
        model.addAttribute("pet", new Pet());
        model.addAttribute("tutores", tutorService.listarTodas());
    }

    /**
     * Prepara o formulário para edição de pet existente.
     */
    public void prepararFormularioEdicao(String id, Model model) {
        Pet petExistente = petService.buscarPorId(id);
        List<Tutor> tutores = tutorService.listarTodas();
        model.addAttribute("pet", petExistente);
        model.addAttribute("tutores", tutores);
    }

    /**
     * Cria um novo pet.
     */
    public void criarPet(Pet pet) throws NotFoundException {
        petService.criarPet(pet);
    }

    /**
     * Atualiza os dados de um pet existente.
     */
    public void atualizarPet(String id, Pet pet) {
        petService.atualizarPet(id, pet);
    }

    public List<Pet> listarTodos() {
        return petService.listarTodos();
    }

}
