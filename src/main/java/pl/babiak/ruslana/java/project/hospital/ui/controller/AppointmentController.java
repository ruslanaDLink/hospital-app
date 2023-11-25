package pl.babiak.ruslana.java.project.hospital.ui.controller;

import pl.babiak.ruslana.java.project.hospital.service.AppointmentService;

import java.util.logging.Logger;

public class AppointmentController {
    private static final Logger LOGGER = Logger.getLogger(AppointmentController.class.getName());

    private AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    public void create() {
        LOGGER.info("create(" + ")");
        appointmentService.create();
        LOGGER.info("create(...)=");
    }
}
