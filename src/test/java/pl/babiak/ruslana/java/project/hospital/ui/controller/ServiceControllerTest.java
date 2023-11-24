package pl.babiak.ruslana.java.project.hospital.ui.controller;

import org.junit.jupiter.api.Test;
import pl.babiak.ruslana.java.project.hospital.dao.ServiceDao;
import pl.babiak.ruslana.java.project.hospital.service.ServiceService;

import static org.junit.jupiter.api.Assertions.*;

class ServiceControllerTest {

    @Test
    void create() {
        //given
        ServiceDao serviceDao = new ServiceDao();
        ServiceService service = new ServiceService(serviceDao);
        ServiceController serviceController = new ServiceController(service);

        //when
        serviceController.create();
        //then

    }
}