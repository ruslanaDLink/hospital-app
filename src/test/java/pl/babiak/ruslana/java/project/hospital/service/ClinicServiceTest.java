package pl.babiak.ruslana.java.project.hospital.service;

import org.junit.jupiter.api.Test;
import pl.babiak.ruslana.java.project.hospital.dao.ClinicDao;

import static org.junit.jupiter.api.Assertions.*;

class ClinicServiceTest {

    @Test
    void create() {
        //given
        ClinicDao clinicDao = new ClinicDao();
        ClinicService clinicService = new ClinicService(clinicDao);

        //when
        clinicService.create();

        //then

    }
}