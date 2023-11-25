package pl.babiak.ruslana.java.project.hospital.service;

import org.junit.jupiter.api.Test;
import pl.babiak.ruslana.java.project.hospital.dao.AppointmentDao;

import static org.junit.jupiter.api.Assertions.*;

class AppointmentServiceTest {

    @Test
    void create() {
        //given
        AppointmentDao appointmentDao = new AppointmentDao();
        AppointmentService appointmentService = new AppointmentService(appointmentDao);

        //when
        appointmentService.create();

        //then

    }
}