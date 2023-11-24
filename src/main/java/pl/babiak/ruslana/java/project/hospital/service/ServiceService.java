package pl.babiak.ruslana.java.project.hospital.service;

import pl.babiak.ruslana.java.project.hospital.dao.ServiceDao;
import pl.babiak.ruslana.java.project.hospital.model.Service;

import java.util.logging.Logger;

public class ServiceService {
    private static final Logger LOGGER = Logger.getLogger(ServiceService.class.getName());

    private ServiceDao serviceDao;

    public ServiceService(ServiceDao serviceDao) {
        this.serviceDao = serviceDao;
    }

    public void create() {
        LOGGER.info("create(" + ")");
        Service service = new Service("Mammogram", 80.00);
        serviceDao.create(service);
        LOGGER.info("create(...)=");
    }
}
