package com.pfc.veterinaryclinic.controller;

import com.pfc.veterinaryclinic.entity.Consulta;
import com.pfc.veterinaryclinic.facade.ConsultaFacade;
import com.pfc.veterinaryclinic.singleton.ClinicLogger;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/consultas")
public class ConsultaPageController {

    @Autowired
    private ClinicLogger clinicLogger;

    private final ConsultaFacade consultaFacade;

    public ConsultaPageController(ConsultaFacade consultaFacade) {
        this.consultaFacade = consultaFacade;
    }

    @GetMapping()
    public String consultas(Model model) {
        List<Consulta> consultas = consultaFacade.listarTodos();
        model.addAttribute("consultas", consultas);
        String fragment = "consultas :: content";
        model.addAttribute("content", fragment);
        clinicLogger.log("Consultas");
        return "consultas";
    }


    @GetMapping("/criar-consulta")
    public String mostrarFormularioConsulta(Model model) {
        consultaFacade.prepararFormularioConsulta(model);
        clinicLogger.log("Criar consulta");
        return "consultas/criar-consulta";
    }

    @PostMapping()
    public String salvarConsulta(@ModelAttribute Consulta consulta, RedirectAttributes redirectAttributes) throws NotFoundException {
        consultaFacade.criarConsulta(consulta);

//        String namePet = consulta.getPet().getName();
//        redirectAttributes.addFlashAttribute("mensagemSucesso", "Consulta agendada com sucesso, " + namePet + "!");

        return "redirect:/consultas";
    }

    @GetMapping("/editar-consulta/{id}")
    public String editarFormularioConsulta(@PathVariable("id") String id, Model model) {
        consultaFacade.prepararFormularioEdicao(id, model);
        clinicLogger.log("Editar consulta");
        return "consultas/editar-consulta";
    }

    @PostMapping("/editar/{id}")
    public String updateConsulta(@PathVariable("id") String id, @ModelAttribute Consulta Consulta) {
        consultaFacade.atualizar(id, Consulta);
        return "redirect:/consultas";
    }

}
