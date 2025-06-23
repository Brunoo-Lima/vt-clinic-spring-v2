package com.pfc.veterinaryclinic.controller;

import com.pfc.veterinaryclinic.repository.TutorRepository;
import com.pfc.veterinaryclinic.singleton.ClinicLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    @Autowired
    private ClinicLogger clinicLogger;

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

        clinicLogger.log("Acessou a home");
        return modelAndView;
    }

}
