package com.pfc.veterinaryclinic.facade;

import com.pfc.veterinaryclinic.entity.Veterinario;
import com.pfc.veterinaryclinic.service.VeterinarioService;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class VeterinarioFacade {

    private final VeterinarioService veterinarioService;

    public VeterinarioFacade(VeterinarioService veterinarioService) {
        this.veterinarioService = veterinarioService;
    }

    /**
     * Prepara o formulário para criação.
     */
    public void prepararFormularioCriacao(Model model) {
        model.addAttribute("veterinario", new Veterinario());
    }

    /**
     * Prepara o formulário de edição, carregando pelo ID.
     */
    public void prepararFormularioEdicao(String id, Model model) {
        Veterinario veterinario = veterinarioService.buscarPorId(id);
        model.addAttribute("veterinario", veterinario);
    }

    /**
     * Cria um novo veterinario.
     */
    public void criarVeterinario(Veterinario veterinario) {
        veterinarioService.criarVeterinario(veterinario);
    }

    /**
     * Atualiza os dados de um veterinario existente.
     */
    public void atualizarVeterinario(String id, Veterinario veterinario) {
        veterinarioService.atualizar(id, veterinario);
    }

    public List<Veterinario> listarTodos() {
        return veterinarioService.listarTodas();
    }
}
