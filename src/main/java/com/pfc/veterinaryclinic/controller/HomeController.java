package com.pfc.veterinaryclinic.controller;

import com.pfc.veterinaryclinic.entity.*;
import com.pfc.veterinaryclinic.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    private static final Logger log = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private VeterinarioService veterinarianService;
    @Autowired
    private PetService petService;
    @Autowired
    private ConsultaService consultaService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("layout");
        String fragment = "home :: content";
        log.info("Carregando fragmento: {}", fragment); // Log para depuração
        modelAndView.addObject("content", fragment);
        return modelAndView;
    }


    @GetMapping("/veterinarios")
    public String veterinarios(Model model) {
        List<Veterinario> veterinarios = veterinarianService.listarTodas();
        model.addAttribute("veterinarios", veterinarios);
        String fragment = "veterinarios :: content";
        log.info("Carregando fragmento: {}", fragment); // Log para depuração
        model.addAttribute("content", fragment);
        return "veterinarios";
    }

    @GetMapping("/veterinarios/criar-veterinario")
    public String mostrarFormularioVeterinario(Model model) {
        // Adiciona um objeto vazio para o formulário (se necessário)
        model.addAttribute("veterinario", new Veterinario() );
        log.info("Entrou no formulário de criar veterinário");
        // Retorna o template Thymeleaf
        return "veterinarios/criar-veterinario";

    }

    @GetMapping("/veterinarios/editar-veterinario/{id}")
    public String editarFormularioVeterinario(@PathVariable("id") String id, Model model) {
        Veterinario veterinarioExistente = veterinarianService.buscarPorId(id);
        model.addAttribute("veterinario", veterinarioExistente);
        log.info("Entrou no formulário de editar veterinário para id: {}", id);
        return "veterinarios/editar-veterinario"; // nome do template Thymeleaf
    }

    @PostMapping("/veterinarios")
    public String salvarVeterinario(@ModelAttribute Veterinario veterinario) {
        veterinarianService.criarVeterinario(veterinario);
        return "redirect:/veterinarios";
    }

    @PostMapping("/veterinarios/editar/{id}")
    public String updateVeterinarian(@PathVariable("id") String id, @ModelAttribute Veterinario veterinario) {
        veterinarianService.atualizar(id, veterinario);
        return "redirect:/veterinarios";
    }


    @GetMapping("/pets")
    public String pets(Model model) {
        List<Pet> pets = petService.listarTodos();
        model.addAttribute("pets", pets);
        String fragment = "pets :: content";
        log.info("Carregando fragmento: {}", fragment); // Log para depuração
        model.addAttribute("content", fragment);
        return "pets";
    }

    @GetMapping("/consultas")
    public String consultas(Model model) {
        List<Consulta> consultas = consultaService.listarTodos();
        model.addAttribute("consultas", consultas);
        String fragment = "consultas :: content";
        log.info("Carregando fragmento: {}", fragment); // Log para depuração
        model.addAttribute("content", fragment);
        return "consultas";
    }

    @GetMapping("/consultas/criar-consulta")
    public String mostrarFormularioConsulta(Model model) {
    // Adiciona um objeto vazio para o formulário (se necessário)
    model.addAttribute("consulta",null);

    // Retorna o template Thymeleaf
    return "consultas/criar-consulta";

    }

}
