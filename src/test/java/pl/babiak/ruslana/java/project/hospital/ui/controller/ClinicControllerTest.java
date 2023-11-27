package pl.babiak.ruslana.java.project.hospital.ui.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.babiak.ruslana.java.project.hospital.dao.ClinicDao;
import pl.babiak.ruslana.java.project.hospital.model.Address;
import pl.babiak.ruslana.java.project.hospital.model.Clinic;
import pl.babiak.ruslana.java.project.hospital.service.ClinicService;

import static org.junit.jupiter.api.Assertions.*;

class ClinicControllerTest {

    @Test
    void create() {
        //given
        String clinicName = "Przychodnia Lekarska NFZ. Centrum Medyczne Sadyba. Poradnia POZ";
        Address clinicAddress = Address.builder()
                .country("Poland")
                .city("Warsaw")
                .voivodeship("Masovian")
                .postCode("02-943")
                .street("Urle 1")
                .build();
        ClinicDao clinicDao = new ClinicDao();
        ClinicService clinicService = new ClinicService(clinicDao);
        ClinicController controller = new ClinicController(clinicService);
        Clinic clinic = new Clinic(clinicAddress, clinicName);

        //when
        Clinic createdClinic = controller.create(clinic);

        //then
        Assertions.assertNotNull(createdClinic, "Created clinic is null.");
    }
}