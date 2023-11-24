package pl.babiak.ruslana.java.project.hospital.service;

import pl.babiak.ruslana.java.project.hospital.dao.PatientDao;
import pl.babiak.ruslana.java.project.hospital.model.Patient;

import java.util.logging.Logger;

public class PatientService {
    private static final Logger LOGGER = Logger.getLogger(PatientService.class.getName());

    private PatientDao patientDao;

    public PatientService(PatientDao patientDao) {
        this.patientDao = patientDao;
    }

    public void create(){
        LOGGER.info("create()");
        Patient patient = new Patient();
        patientDao.insertValues(patient);
        LOGGER.info("create(...)=");
    }
}
