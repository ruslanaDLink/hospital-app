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

    @Test
    void insertValues() {
        PatientDao patientDao = new PatientDao();
        Patient patient = new Patient();
        Patient insertedPatient = patientDao.insertValues(patient);
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
