package com.pfc.veterinaryclinic.facade;

import com.pfc.veterinaryclinic.entity.Consulta;
import com.pfc.veterinaryclinic.service.ConsultaService;
import com.pfc.veterinaryclinic.service.PetService;
import com.pfc.veterinaryclinic.service.TutorService;
import com.pfc.veterinaryclinic.service.VeterinarioService;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Optional;

@Service
public class ConsultaFacade {

    private final ConsultaService consultaService;
    private final VeterinarioService veterinarioService;
    private final TutorService tutorService;
    private final PetService petService;

    public ConsultaFacade(
            ConsultaService consultaService,
            VeterinarioService veterinarioService,
            TutorService tutorService,
            PetService petService
    ) {
        this.consultaService = consultaService;
        this.veterinarioService = veterinarioService;
        this.tutorService = tutorService;
        this.petService = petService;
    }

    /**
     * Prepara os dados necessários para exibir o formulário de criação de consulta.
     */
    public void prepararFormularioConsulta(Model model) {
        model.addAttribute("consulta", new Consulta());
        model.addAttribute("veterinarios", veterinarioService.listarTodas());
        model.addAttribute("tutores", tutorService.listarTodas());
        model.addAttribute("pets", petService.listarTodos());
    }

    public void prepararFormularioEdicao(String id, Model model) {
        Consulta consulta = consultaService.buscarPorId(id);
        model.addAttribute("consulta", consulta);
        model.addAttribute("veterinarios", veterinarioService.listarTodas());
        model.addAttribute("tutores", tutorService.listarTodas());
        model.addAttribute("pets", petService.listarTodos());

    }

    /**
     * Cria uma nova consulta, com validações futuras se necessário.
     */
    public void criarConsulta(Consulta consulta) {
        // Aqui você pode adicionar regras de negócio, ex: checar disponibilidade
        consultaService.criarConsulta(consulta);
    }

    public void atualizar(String id, Consulta consulta) {
        consultaService.atualizarConsulta(id, consulta);
    }

    public List<Consulta> listarTodos() {
        return consultaService.listarTodos();
    }

}
