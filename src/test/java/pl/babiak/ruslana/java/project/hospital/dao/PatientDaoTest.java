package pl.babiak.ruslana.java.project.hospital.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.babiak.ruslana.java.project.hospital.model.Address;
import pl.babiak.ruslana.java.project.hospital.model.Patient;
import pl.babiak.ruslana.java.project.hospital.model.UniqueId;

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
        Address address = Address.builder()
                .country("Poland")
                .voivodeship("Masovian")
                .postCode("00-002")
                .city("Warsaw")
                .street("Pulawska")
                .flatNumber("2A")
                .build();
        UniqueId uniqueId = new UniqueId();
        Patient patient = new Patient("Agata Kowalska", 28, "FA345", address, true);

        //when
        Patient insertedPatient = patientDao.insertValues(patient);

        //then
        Assertions.assertNotNull(insertedPatient, "Patient not inserted");
    }

    @Test
    void read() {
        //given
        PatientDao patientDao = new PatientDao();
        UniqueId id = new UniqueId();

        //when
        Patient readPatient = patientDao.read(id);

        //then
        Assertions.assertNotNull(readPatient, "Method does not read any information.");
    }

    @Test
    void update() {
        //given
        PatientDao patientDao = new PatientDao();
        Address address = Address.builder()
                .country("Poland")
                .voivodeship("Masovian")
                .postCode("00-002")
                .city("Warsaw")
                .street("Pulawska")
                .flatNumber("2A")
                .build();
        UniqueId id = new UniqueId();
        Patient patient = new Patient("Agata Kowalska", 28, "FA345", address, true);

        //when
        Patient updatedPatient = patientDao.update(patient);

        //then
        Assertions.assertNotNull(updatedPatient, "No updated changes.");
    }

    @Test
    void delete() {
        PatientDao patientDao = new PatientDao();
        UniqueId uniqueId = new UniqueId();
        patientDao.delete(uniqueId);
    }
}
