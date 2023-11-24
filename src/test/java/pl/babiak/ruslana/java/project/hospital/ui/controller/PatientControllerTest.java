package pl.babiak.ruslana.java.project.hospital.ui.controller;

import org.junit.jupiter.api.Test;
import pl.babiak.ruslana.java.project.hospital.dao.PatientDao;
import pl.babiak.ruslana.java.project.hospital.service.PatientService;

import static org.junit.jupiter.api.Assertions.*;

class PatientControllerTest {

    @Test
    void create() {
        //given
        PatientDao patientDao = new PatientDao();
        PatientService patientService = new PatientService(patientDao);
        PatientController patientController = new PatientController(patientService);

        //when
        patientController.create();

        //then

    }
}