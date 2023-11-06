package pl.babiak.ruslana.java.project.hospital.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.babiak.ruslana.java.project.hospital.model.Patient;

public class PatientDaoTest {
    @Test
    void createTable() {
        PatientDao patientDao = new PatientDao();
        patientDao.createTable();
    }

    // TODO: 06/11/2023
    // dodac sekscje gwt do wszystkich testow
    @Test
    void insertValues() {
        //given
        PatientDao patientDao = new PatientDao();
        Patient patient = new Patient();

        //when
        Patient insertedPatient = patientDao.insertValues(patient);

        //then
        Assertions.assertNotNull(insertedPatient, "Patient not inserted");
    }

    @Test
    void read() {
        PatientDao patientDao = new PatientDao();
        patientDao.read();
    }

    @Test
    void update() {
        PatientDao patientDao = new PatientDao();
        patientDao.update();
    }

    @Test
    void delete() {
        PatientDao patientDao = new PatientDao();
        patientDao.delete();
    }
}
