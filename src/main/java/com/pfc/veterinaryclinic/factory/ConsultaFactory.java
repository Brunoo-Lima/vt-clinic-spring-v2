package com.pfc.veterinaryclinic.factory;

import com.pfc.veterinaryclinic.entity.Consulta;
import com.pfc.veterinaryclinic.entity.Pet;
import com.pfc.veterinaryclinic.entity.Tutor;
import com.pfc.veterinaryclinic.entity.Veterinario;
import com.pfc.veterinaryclinic.enums.TipoConsulta;

import java.time.LocalDateTime;

public class ConsultaFactory {

    public static Consulta criarConsulta(TipoConsulta tipoConsulta, Pet pet, Tutor tutor, Veterinario vet, LocalDateTime date) {
        if (tipoConsulta == null) {
            throw new IllegalArgumentException("TipoConsulta não pode ser nulo");
        }

        switch (tipoConsulta) {
            case PRESENCIAL:
                return Consulta.criarConsultaPresencial(pet, tutor, vet, date);
            case ONLINE:
                return Consulta.criarConsultaOnline(pet, tutor, vet, date);
            default:
                throw new UnsupportedOperationException("Tipo de consulta não suportado: " + tipoConsulta);
        }
    }
}
