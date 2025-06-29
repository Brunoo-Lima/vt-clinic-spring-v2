package com.pfc.veterinaryclinic.facade;

import com.pfc.veterinaryclinic.entity.Consulta;
import com.pfc.veterinaryclinic.service.*;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class ConsultaFacade {

    private final ConsultaService consultaService;
    private final VeterinarioService veterinarioService;
    private final TutorService tutorService;
    private final PetService petService;
    private final NotificacaoService notificacaoService;

    public ConsultaFacade(
            ConsultaService consultaService,
            VeterinarioService veterinarioService,
            TutorService tutorService,
            PetService petService,
            NotificacaoService notificacaoService
    ) {
        this.consultaService = consultaService;
        this.veterinarioService = veterinarioService;
        this.tutorService = tutorService;
        this.petService = petService;
        this.notificacaoService = notificacaoService;
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
     * Cria uma nova consulta.
     */
    public void criarConsulta(Consulta consulta) {
        consultaService.criarConsulta(consulta);

        String nameTutor = consulta.getPet().getTutor().getName();
        notificacaoService.notificar(nameTutor, "Consulta foi agendada com sucesso!");
    }

    public void atualizar(String id, Consulta consulta) {
        consultaService.atualizarConsulta(id, consulta);
    }

    public List<Consulta> listarTodos() {
        return consultaService.listarTodos();
    }

}
