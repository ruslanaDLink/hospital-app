package pl.babiak.ruslana.java.project.hospital.ui.controller;

import pl.babiak.ruslana.java.project.hospital.service.ServiceService;

import java.util.logging.Logger;

public class ServiceController {
    private static final Logger LOGGER = Logger.getLogger(ServiceController.class.getName());

    private ServiceService service;

    public ServiceController(ServiceService service) {
        this.service = service;
    }

    public void create() {
        LOGGER.info("create(" + ")");
        service.create();
        LOGGER.info("create(...)=");
    }
}
