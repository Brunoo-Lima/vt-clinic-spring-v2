package com.pfc.veterinaryclinic.singleton;

import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

@Component
public class ClinicLogger {

    private PrintWriter logFile;

    public ClinicLogger() {
        try {
            this.logFile = new PrintWriter("clinic_logs.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Falha ao criar arquivo de log");
        }
    }

    public void log(String message) {
        logFile.println(LocalDateTime.now() + " - " + message);
        logFile.flush();
    }
}
