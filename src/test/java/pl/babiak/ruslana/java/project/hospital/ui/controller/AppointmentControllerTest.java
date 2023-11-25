package pl.babiak.ruslana.java.project.hospital.ui.controller;

import org.junit.jupiter.api.Test;
import pl.babiak.ruslana.java.project.hospital.dao.AppointmentDao;
import pl.babiak.ruslana.java.project.hospital.service.AddressService;
import pl.babiak.ruslana.java.project.hospital.service.AppointmentService;

import static org.junit.jupiter.api.Assertions.*;

class AppointmentControllerTest {

    @Test
    void create() {
        //given
        AppointmentDao appointmentDao = new AppointmentDao();
        AppointmentService appointmentService = new AppointmentService(appointmentDao);
        AppointmentController appointmentController = new AppointmentController(appointmentService);

        //when
        appointmentController.create();

        //then

    }
}