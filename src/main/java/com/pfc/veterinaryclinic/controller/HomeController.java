package com.pfc.veterinaryclinic.controller;

import com.pfc.veterinaryclinic.entity.*;
import com.pfc.veterinaryclinic.repository.TutorRepository;
import com.pfc.veterinaryclinic.service.*;
import javassist.NotFoundException;
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
    @Autowired
    private TutorService tutorService;

    @Autowired
    private TutorRepository tutorRepository;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("layout");
        String fragment = "home :: content";

        boolean hasTutores = tutorRepository.count() > 0; // Verifica se existe ao menos um tutor

        modelAndView.addObject("content", fragment);
        modelAndView.addObject("hasTutores", hasTutores); // Adiciona ao modelo

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

    @GetMapping("/pets/criar-pet")
    public String mostrarFormularioPet(Model model) {
        // Adiciona um objeto vazio para o formulário (se necessário)
        model.addAttribute("pet", new Pet() );
        model.addAttribute("tutores", tutorService.listarTodas());
        log.info("Entrou no formulário de criar pet");
        // Retorna o template Thymeleaf
        return "pets/criar-pet";

    }

    @GetMapping("/pets/editar-pet/{id}")
    public String editarFormularioPets(@PathVariable("id") String id, Model model) {
        List<Tutor> tutores = tutorService.listarTodas();
        Pet petExistente = petService.buscarPorId(id);
        model.addAttribute("pet", petExistente);
        model.addAttribute("tutores", tutores);
        log.info("Entrou no formulário de editar pet para id: {}", id);
        return "pets/editar-pet"; // nome do template Thymeleaf
    }

    @PostMapping("/pets")
    public String salvarPet(@ModelAttribute Pet pet) throws NotFoundException {
        petService.criarPet(pet);
        return "redirect:/pets";
    }

    @PostMapping("/pets/editar/{id}")
    public String updatePet(@PathVariable("id") String id, @ModelAttribute Pet pet) {
        petService.atualizarPet(id, pet);
        return "redirect:/pets";
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
        model.addAttribute("consulta", new Consulta());
        model.addAttribute("veterinarios", veterinarianService.listarTodas());
        model.addAttribute("tutores", tutorService.listarTodas());
        model.addAttribute("pets", petService.listarTodos());

        return "consultas/criar-consulta";
    }

    @PostMapping("/consultas")
    public String salvarConsulta(@ModelAttribute Consulta consulta) throws NotFoundException {
        consultaService.criarConsulta(consulta);
        return "redirect:/consultas";
    }


    @GetMapping("/tutores")
    public String tutores(Model model) {
        List<Tutor> tutores = tutorService.listarTodas();
        model.addAttribute("tutores", tutores);
        String fragment = "tutores :: content";
        log.info("Carregando fragmento: {}", fragment); // Log para depuração
        model.addAttribute("content", fragment);
        return "tutores";
    }

    @GetMapping("/tutores/criar-tutor")
    public String mostrarFormularioTutor(Model model) {
        // Adiciona um objeto vazio para o formulário (se necessário)
        model.addAttribute("tutor", new Tutor() );
        log.info("Entrou no formulário de criar tutor");
        // Retorna o template Thymeleaf
        return "tutores/criar-tutor";

    }

    @GetMapping("/tutores/editar-tutor/{id}")
    public String editarFormularioTutores(@PathVariable("id") String id, Model model) {
        Tutor tutorExistente = tutorService.buscarPorId(id);
        model.addAttribute("tutor", tutorExistente);
        log.info("Entrou no formulário de editar tutor para id: {}", id);
        return "tutores/editar-tutor"; // nome do template Thymeleaf
    }

    @PostMapping("/tutores")
    public String salvarPet(@ModelAttribute Tutor tutor) {
        tutorService.criarTutor(tutor);
        return "redirect:/tutores";
    }

    @PostMapping("/tutores/editar/{id}")
    public String updateTutor(@PathVariable("id") String id, @ModelAttribute Tutor tutor) {
        tutorService.atualizar(id, tutor);
        return "redirect:/tutores";
    }



}
