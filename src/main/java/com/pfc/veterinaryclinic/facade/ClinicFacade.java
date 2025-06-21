//package com.pfc.veterinaryclinic.facade;
//
//
//import com.pfc.veterinaryclinic.entity.MedicalConsultation;
//import com.pfc.veterinaryclinic.entity.Pet;
//import com.pfc.veterinaryclinic.entity.Tutor;
//import com.pfc.veterinaryclinic.entity.Veterinary;
//import com.pfc.veterinaryclinic.interfaces.IConsulta;
//import com.pfc.veterinaryclinic.interfaces.IPet;
//import com.pfc.veterinaryclinic.interfaces.ITutor;
//import com.pfc.veterinaryclinic.interfaces.IVeterinario;
//import com.pfc.veterinaryclinic.singleton.ClinicManager;
//
//import java.util.List;
//
//public class ClinicFacade {
//
//    private final ITutor tutorDAO ;
//    private final IPet petDAO;
//    private final IConsulta consultationDAO;
//    private final IVeterinario veterinaryDAO;
//    private final ClinicManager clinicManager;
//
//    public ClinicFacade() {
//        this.tutorDAO = DAOFactory.createTutorDAO();
//        this.petDAO = DAOFactory.createPetDAO();
//        this.consultationDAO = DAOFactory.createConsultationDAO();
//        this.veterinaryDAO = DAOFactory.createVeterinaryDAO();
//        this.clinicManager = ClinicManager.getInstance();
//    }
//
//    public void cadastrarTutorComPet(Tutor tutor, Pet pet) {
//        tutorDAO.salvar(tutor);
//        petDAO.salvar(pet);
//
//        // Adiciona à memória (singleton)
//        clinicManager.registerPet(pet);
//
//        System.out.println("Tutor e Pet cadastrados com sucesso!");
//    }
//
//    public void registrarVeterinario(Veterinary vet) {
//        veterinaryDAO.salvar(vet);
//        clinicManager.registerVeterinary(vet);
//        System.out.println("Veterinário registrado com sucesso!");
//    }
//
//    public void consultarConsultasDoTutor(int tutorId) {
//        Tutor tutor = tutorDAO.buscarPorId(tutorId);
//        List<Pet> pets = petDAO.buscarPorTutor(tutor);
//        for (Pet pet : pets) {
//            List<MedicalConsultation> consultas = consultationDAO.buscarPorPet(pet);
//            System.out.println("Consultas do pet " + pet.getName() + ": " + consultas.size());
//        }
//    }
//
//    public void listarPetsEMedicosDisponiveis() {
//        List<String> nomesPets = clinicManager.getPets();
//        List<String> vetsDisponiveis = clinicManager.getAvailableVeterinaries();
//
//        System.out.println("🐾 Pets registrados: " + String.join(", ", nomesPets));
//        System.out.println("🩺 Veterinários disponíveis: " + String.join(", ", vetsDisponiveis));
//    }
//}
