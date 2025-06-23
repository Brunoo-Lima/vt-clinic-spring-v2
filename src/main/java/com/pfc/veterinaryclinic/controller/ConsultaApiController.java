package com.pfc.veterinaryclinic.controller;

import com.pfc.veterinaryclinic.entity.Consulta;
import com.pfc.veterinaryclinic.entity.Pet;
import com.pfc.veterinaryclinic.entity.Veterinario;
//import com.pfc.veterinaryclinic.facade.ClinicaFacade;
import com.pfc.veterinaryclinic.service.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/consultas")
public class ConsultaApiController {

    @Autowired
    private ConsultaService consultaService;


//    private final ClinicaFacade clinicaFacade;
//
//    public ConsultaController(ClinicaFacade clinicaFacade) {
//        this.clinicaFacade = clinicaFacade;
//    }
//
//    @PostMapping("/consultas")
//    public String salvarConsulta(@ModelAttribute ConsultaFormDTO form) throws ParseException {
//        Date data = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm").parse(form.getDate());
//        clinicaFacade.agendarConsulta(form.getPetName(), form.getTutorName(), form.getVeterinaryId(), data);
//        return "redirect:/consultas";
//    }

//    @GetMapping("/criar-consulta")
//    public String mostrarFormularioConsulta(Model model) {
//        // Adiciona um objeto vazio para o formulário (se necessário)
//        model.addAttribute("consulta", new Consulta());
//
//        // Retorna o template Thymeleaf
//        return "consultas/criar-consulta";
//    }

    @PostMapping("/criar-consulta")
    public ResponseEntity<Consulta> scheduleConsultation(@RequestBody Consulta appointment) {
        Consulta scheduledAppointment = consultaService.criarConsulta(appointment);
        return new ResponseEntity<>(scheduledAppointment, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Consulta>> getAllConsultations() {
        List<Consulta> appointments = consultaService.listarTodos();
        return ResponseEntity.ok(appointments);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Consulta>> getAppointmentById(@PathVariable String id) {
        Optional<Consulta> appointment = consultaService.buscarConsultaPorId(id);
        return ResponseEntity.ok(appointment);
    }

    @GetMapping("/pets")
    public ResponseEntity<List<Consulta>> getConsultationsByPet(@RequestBody Pet pet) {
        List<Consulta> appointments = consultaService.buscarPorPet(pet);
        return ResponseEntity.ok(appointments);
    }

    @GetMapping("/veterinarios")
    public ResponseEntity<List<Consulta>> getConsultationsByVeterinarian(@RequestBody Veterinario veterinary) {
        List<Consulta> appointments = consultaService.buscarPorVeterinario(veterinary);
        return ResponseEntity.ok(appointments);
    }

//    @GetMapping("/between")
//    public ResponseEntity<List<Consulta>> getConsultationsBetweenDates(
//            @RequestParam LocalDateTime start,
//            @RequestParam LocalDateTime end) {
//        List<Consulta> appointments = consultaService.buscarPorPeriodo(start, end);
//        return ResponseEntity.ok(appointments);
//    }



    @PostMapping("/editar/{id}")
    public String updateConsultation(@PathVariable("id") String id, @ModelAttribute Consulta appointmentDetails) {
        consultaService.atualizarConsulta(id, appointmentDetails);
        return "redirect:/consultas";
    }


    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deleteConsultation(@PathVariable("id") String id) {
        consultaService.deletarConsulta(id);
        return ResponseEntity.noContent().build();
    }
}
