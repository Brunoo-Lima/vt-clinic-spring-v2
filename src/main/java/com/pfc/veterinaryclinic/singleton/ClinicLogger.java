//package com.pfc.veterinaryclinic.singleton;
//
//import java.io.FileNotFoundException;
//import java.io.PrintWriter;
//import java.time.LocalDateTime;
//
//public class ClinicLogger {
//    private PrintWriter logFile;
//
//    private ClinicLogger(){
//        try {
//            this.logFile = new PrintWriter("clinic_logs.txt");
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException("Falha ao criar arquivo de log");
//        }
//    }
//
//    private static final class InstanceHolder {
//        private static final ClinicLogger instance = new ClinicLogger();
//    }
//
//    public  static ClinicLogger getInstance() {
//
//        return InstanceHolder.instance;
//    }
//
//    public void log(String message) {
//        logFile.println(LocalDateTime.now() + " - " + message);
//        logFile.flush();
//    }
//}
