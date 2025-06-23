package com.pfc.veterinaryclinic.service;

import com.pfc.veterinaryclinic.adapter.NotificadorAdapter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class NotificacaoService {

    private final NotificadorAdapter notificador;

    public NotificacaoService(
            @Qualifier("notificacaoAdapter") NotificadorAdapter notificador
    ) {
        this.notificador = notificador;
    }

    public void notificar(String emailOuNumero, String mensagem) {
        notificador.notificar(emailOuNumero, mensagem);
    }
}

