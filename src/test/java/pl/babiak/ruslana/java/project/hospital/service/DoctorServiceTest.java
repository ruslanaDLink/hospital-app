package pl.babiak.ruslana.java.project.hospital.service;

import org.junit.jupiter.api.Test;
import pl.babiak.ruslana.java.project.hospital.dao.DoctorDao;

import static org.junit.jupiter.api.Assertions.*;

class DoctorServiceTest {

    @Test
    void create() {
        //given
        DoctorDao doctorDao = new DoctorDao();
        DoctorService doctorService = new DoctorService(doctorDao);

        //when
        doctorService.create();
        //then

    }
}