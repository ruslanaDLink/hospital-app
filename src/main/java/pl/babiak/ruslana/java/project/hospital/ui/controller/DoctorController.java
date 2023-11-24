package pl.babiak.ruslana.java.project.hospital.ui.controller;

import pl.babiak.ruslana.java.project.hospital.dao.DoctorDao;
import pl.babiak.ruslana.java.project.hospital.model.Doctor;
import pl.babiak.ruslana.java.project.hospital.model.DoctorType;
import pl.babiak.ruslana.java.project.hospital.model.UniqueId;
import pl.babiak.ruslana.java.project.hospital.service.DoctorService;

import java.util.logging.Logger;

public class DoctorController {
    private static final Logger LOGGER = Logger.getLogger(DoctorController.class.getName());

    private DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    public void create(){
        LOGGER.info("create(" + ")");
        doctorService.create();
        LOGGER.info("create(...)=");
    }
}
