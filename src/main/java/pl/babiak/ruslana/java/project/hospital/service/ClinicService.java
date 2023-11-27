package pl.babiak.ruslana.java.project.hospital.service;

import pl.babiak.ruslana.java.project.hospital.dao.ClinicDao;
import pl.babiak.ruslana.java.project.hospital.model.Address;
import pl.babiak.ruslana.java.project.hospital.model.Clinic;

import java.util.logging.Logger;

public class ClinicService {
    private static final Logger LOGGER = Logger.getLogger(ClinicService.class.getName());

    private ClinicDao clinicDao;

    public ClinicService(ClinicDao clinicDao) {
        this.clinicDao = clinicDao;
    }

    public Clinic create(Clinic clinic){
        LOGGER.info("create()");
        Clinic createdClinic = clinicDao.create(clinic);
        LOGGER.info("create(...)=");
        return createdClinic;
    }
}
// TODO: 27/11/2023
// poprawic clinicService oraz ClinicController zgodnie z CRUD
