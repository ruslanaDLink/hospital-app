package pl.babiak.ruslana.java.project.hospital.ui.controller;


import pl.babiak.ruslana.java.project.hospital.service.ClinicService;

import java.util.logging.Logger;

public class ClinicController {
    private static final Logger LOGGER = Logger.getLogger(ClinicController.class.getName());

    private ClinicService clinicService;

    public ClinicController(ClinicService clinicService) {
        this.clinicService = clinicService;
    }

    public void create(){
        LOGGER.info("create()");
        clinicService.create();
        LOGGER.info("create(...)=");
    }
}
