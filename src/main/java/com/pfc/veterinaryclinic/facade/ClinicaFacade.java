//package com.pfc.veterinaryclinic.facade;
//
//import com.pfc.veterinaryclinic.entity.Consulta;
//import com.pfc.veterinaryclinic.entity.Pet;
//import com.pfc.veterinaryclinic.entity.Tutor;
//import com.pfc.veterinaryclinic.entity.Veterinario;
//import com.pfc.veterinaryclinic.service.ConsultaService;
//import com.pfc.veterinaryclinic.service.PetService;
//import com.pfc.veterinaryclinic.service.TutorService;
//import com.pfc.veterinaryclinic.service.VeterinarioService;
//import org.springframework.stereotype.Service;
//
//import java.util.Date;
//
//@Service
//public class ClinicaFacade {
//
//    private final PetService petService;
//    private final TutorService tutorService;
//    private final VeterinarioService veterinarioService;
//    private final ConsultaService consultaService;
//
//    public ClinicaFacade(PetService petService, TutorService tutorService,
//                         VeterinarioService veterinarioService, ConsultaService consultaService) {
//        this.petService = petService;
//        this.tutorService = tutorService;
//        this.veterinarioService = veterinarioService;
//        this.consultaService = consultaService;
//    }
//
//
//    public Consulta agendarConsulta(String nomePet, String nomeTutor, String veterinarioId, Date data) {
//        // Buscar ou criar tutor
//        Tutor tutor = tutorService.buscarPorNome(nomeTutor);
//        if (tutor == null) {
//            tutor = new Tutor();
//            tutor.setName(nomeTutor);
//            tutorService.criarTutor(tutor);
//        }
//
//        // Buscar ou criar pet
//        Pet pet = petService.buscarPorNomeETutor(nomePet, tutor);
//        if (pet == null) {
//            pet = new Pet.Builder(nomePet, tutor).build();
//            petService.criarPet(pet);
//        }
//
//        // Buscar veterinário
//        Veterinario vet = veterinarioService.buscarPorId(veterinarioId);
//
//        // Criar consulta
//        Consulta consulta = new Consulta.Builder(pet, tutor, vet)
//                .withDate(data)
//                .build();
//
//        return consultaService.criarConsulta(consulta);
//    }
//
//    // Outros métodos "fachada" para simplificar operações complexas
//}
