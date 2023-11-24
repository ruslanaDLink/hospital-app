package pl.babiak.ruslana.java.project.hospital.ui.controller;

import org.junit.jupiter.api.Test;
import pl.babiak.ruslana.java.project.hospital.dao.DoctorDao;
import pl.babiak.ruslana.java.project.hospital.service.DoctorService;

import static org.junit.jupiter.api.Assertions.*;

class DoctorControllerTest {

    @Test
    void create() {
        //given
        DoctorDao doctorDao = new DoctorDao();
        DoctorService doctorService = new DoctorService(doctorDao);
        DoctorController doctorController = new DoctorController(doctorService);

        //when
        doctorController.create();

        //then

    }
}