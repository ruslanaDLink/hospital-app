package pl.babiak.ruslana.java.project.hospital.ui.controller;


import pl.babiak.ruslana.java.project.hospital.service.PatientService;

import java.util.logging.Logger;

public class PatientController {
    private static final Logger LOGGER = Logger.getLogger(PatientController.class.getName());

    private PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    public void create(){
        LOGGER.info("create()");
        patientService.create();
        LOGGER.info("create(...)=");
    }
}
