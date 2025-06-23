package com.pfc.veterinaryclinic.controller;

import com.pfc.veterinaryclinic.entity.Consulta;
import com.pfc.veterinaryclinic.facade.ConsultaFacade;
import javassist.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/consultas")
public class ConsultaPageController {

    private static final Logger log = LoggerFactory.getLogger(PetPageController.class);

    private final ConsultaFacade consultaFacade;

    public ConsultaPageController(ConsultaFacade consultaFacade) {
        this.consultaFacade = consultaFacade;
    }

    @GetMapping()
    public String consultas(Model model) {
        List<Consulta> consultas = consultaFacade.listarTodos();
        model.addAttribute("consultas", consultas);
        String fragment = "consultas :: content";
        log.info("Carregando fragmento: {}", fragment); // Log para depuração
        model.addAttribute("content", fragment);
        return "consultas";
    }


    @GetMapping("/criar-consulta")
    public String mostrarFormularioConsulta(Model model) {
        consultaFacade.prepararFormularioConsulta(model);
        return "consultas/criar-consulta";
    }

    @PostMapping()
    public String salvarConsulta(@ModelAttribute Consulta consulta) throws NotFoundException {
        consultaFacade.criarConsulta(consulta);
        return "redirect:/consultas";
    }

    @GetMapping("/editar-consulta/{id}")
    public String editarFormularioConsulta(@PathVariable("id") String id, Model model) {
        consultaFacade.prepararFormularioEdicao(id, model);
        log.info("Entrou no formulário de editar consulta para id: {}", id);
        return "consultas/editar-consulta";
    }

    @PostMapping("/editar/{id}")
    public String updateConsulta(@PathVariable("id") String id, @ModelAttribute Consulta Consulta) {
        consultaFacade.atualizar(id, Consulta);
        return "redirect:/consultas";
    }

}
