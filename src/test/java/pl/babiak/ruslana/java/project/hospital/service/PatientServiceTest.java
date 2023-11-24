package pl.babiak.ruslana.java.project.hospital.service;

import org.junit.jupiter.api.Test;
import pl.babiak.ruslana.java.project.hospital.dao.PatientDao;

import static org.junit.jupiter.api.Assertions.*;

class PatientServiceTest {

    @Test
    void create() {
        //given
        PatientDao patientDao = new PatientDao();
        PatientService patientService = new PatientService(patientDao);

        //when
        patientService.create();

        //then

    }
}