package pl.babiak.ruslana.java.project.hospital.service;

import org.junit.jupiter.api.Test;
import pl.babiak.ruslana.java.project.hospital.dao.ServiceDao;

import static org.junit.jupiter.api.Assertions.*;

class ServiceServiceTest {

    @Test
    void create() {
        //given
        ServiceDao serviceDao = new ServiceDao();
        ServiceService service = new ServiceService(serviceDao);

        //when
        service.create();
        //then

    }
}