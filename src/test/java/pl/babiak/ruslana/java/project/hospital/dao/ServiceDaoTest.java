package pl.babiak.ruslana.java.project.hospital.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.babiak.ruslana.java.project.hospital.model.Service;
import pl.babiak.ruslana.java.project.hospital.model.UniqueId;

import static org.junit.jupiter.api.Assertions.*;

class ServiceDaoTest {

    @Test
    void create() {
        //given
        ServiceDao serviceDao = new ServiceDao();
        Service service = new Service("Mammogram", 80.00);
        UniqueId uniqueId = new UniqueId();
        service.setId((long) uniqueId.getUniqueId());

        //when
        Service mammogramService = serviceDao.create(service);

        //then
        Assertions.assertNotNull(mammogramService, "Service is not created.");
    }

    @Test
    void read() {
        //given
        ServiceDao serviceDao = new ServiceDao();
        Service service = new Service("Mammogram", 80.00);
        UniqueId uniqueId = new UniqueId();
        service.setId((long) uniqueId.getUniqueId());

        //when
        Service mammogramService = serviceDao.read(service.getId());

        //then
        Assertions.assertNotNull(mammogramService, "Service doesn't contain any information.");
    }

    @Test
    void update() {
        //given
        ServiceDao serviceDao = new ServiceDao();
        Service service = new Service("Mammogram", 80.00);

        //when
        Service mammogramService = serviceDao.update(service);

        //then
        Assertions.assertNotNull(mammogramService, "Service is not created.");
    }

    @Test
    void delete() {
        //given
        ServiceDao serviceDao = new ServiceDao();
        Service service = new Service("Mammogram", 80.00);
        UniqueId uniqueId = new UniqueId();
        service.setId((long) uniqueId.getUniqueId());

        //when
        serviceDao.delete(service.getId());

        //then

    }
}