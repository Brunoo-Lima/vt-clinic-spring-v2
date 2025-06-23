package com.pfc.veterinaryclinic.adapter;

import org.springframework.stereotype.Component;

@Component("notificacaoAdapter")
public class NotificacaoAdapter implements NotificadorAdapter {

    @Override
    public void notificar(String destino, String mensagem) {
        // aparecer um alert na tela
        System.out.println("Enviando notificação para" + destino + ": " + mensagem);
    }
}
