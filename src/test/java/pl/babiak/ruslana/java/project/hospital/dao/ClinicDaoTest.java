package pl.babiak.ruslana.java.project.hospital.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.babiak.ruslana.java.project.hospital.model.Address;
import pl.babiak.ruslana.java.project.hospital.model.Clinic;
import pl.babiak.ruslana.java.project.hospital.model.UniqueId;

import static org.junit.jupiter.api.Assertions.*;

class ClinicDaoTest {

    @Test
    void create() {
        //given
        ClinicDao clinicDao = new ClinicDao();
        Address clinicAddress = Address.builder()
                .country("Poland")
                .city("Warsaw")
                .voivodeship("Masovian")
                .postCode("02-943")
                .street("Urle 1")
                .build();
        String clinicName = "Przychodnia Lekarska NFZ. Centrum Medyczne Sadyba. Poradnia POZ";
        Clinic clinic = new Clinic(clinicAddress, clinicName);

        //when
        Clinic createdClinic = clinicDao.create(clinic);

        //then
        Assertions.assertNotNull(createdClinic, "Creation failed.");
    }

    @Test
    void read() {
        //given
        ClinicDao clinicDao = new ClinicDao();
        Address clinicAddress = Address.builder()
                .country("Poland")
                .city("Warsaw")
                .voivodeship("Masovian")
                .postCode("02-943")
                .street("Urle 1")
                .build();
        String clinicName = "Przychodnia Lekarska NFZ. Centrum Medyczne Sadyba. Poradnia POZ";
        Clinic clinic = new Clinic(clinicAddress, clinicName);
        UniqueId uniqueId = new UniqueId();
        //when
        Clinic clinicInfo = clinicDao.read(uniqueId);

        //then
       Assertions.assertNotNull(clinicDao, "There are nothing to read.");
    }
}