//package com.pfc.veterinaryclinic.singleton;
//
//
//import com.pfc.veterinaryclinic.entity.Pet;
//import com.pfc.veterinaryclinic.entity.Veterinary;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.Collectors;
//
//public class ClinicManager {
//    private static ClinicManager instance;
//    private List<Veterinary> veterinaries;
//    private List<Pet> pets;
//
//    private ClinicManager() {
//        this.veterinaries = new ArrayList<>();
//        this.pets = new ArrayList<>();
//    }
//
//    public static synchronized ClinicManager getInstance(){
//        if(instance == null) {
//            instance = new ClinicManager();
//        }
//        return instance;
//    }
//
//
//    public void registerVeterinary(Veterinary vet) {
//        veterinaries.add(vet);
//    }
//
//    public void registerPet (Pet pet) {
//        pets.add(pet);
//    }
//
//    public List<String> getPets(){
//        return pets.stream().map(Pet::getName).collect(Collectors.toList());
//    }
//
//    public List<String> getAvailableVeterinaries(){
//        return veterinaries.stream()
//                .filter(Veterinary::isAvailable)
//                .map(Veterinary::getName) // Extrai apenas o nome
//                .collect(Collectors.toList());
//
//    }
//}
