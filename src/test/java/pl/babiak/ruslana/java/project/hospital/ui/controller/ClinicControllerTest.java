package pl.babiak.ruslana.java.project.hospital.ui.controller;

import org.junit.jupiter.api.Test;
import pl.babiak.ruslana.java.project.hospital.dao.ClinicDao;
import pl.babiak.ruslana.java.project.hospital.service.ClinicService;

import static org.junit.jupiter.api.Assertions.*;

class ClinicControllerTest {

    @Test
    void create() {
        //given
        ClinicDao clinicDao = new ClinicDao();
        ClinicService clinicService = new ClinicService(clinicDao);
        ClinicController controller = new ClinicController(clinicService);

        //when
        controller.create();

        //then

    }
}