package pl.babiak.ruslana.java.project.hospital.service;

import pl.babiak.ruslana.java.project.hospital.dao.ClinicDao;
import pl.babiak.ruslana.java.project.hospital.model.Address;
import pl.babiak.ruslana.java.project.hospital.model.Clinic;

import java.util.logging.Logger;

public class ClinicService {
    private static final Logger LOGGER = Logger.getLogger(ClinicService.class.getName());

    private ClinicDao clinicDao;

    public ClinicService(ClinicDao clinicDao) {
        this.clinicDao = clinicDao;
    }

    public void create(){
        LOGGER.info("create()");
        Address defaultAddress = Address.builder()
                .country("")
                .voivodeship("")
                .city("")
                .postCode("")
                .street("")
                .flatNumber("")
                .build();
        Clinic clinic = new Clinic(defaultAddress, "Medical Centre");
        clinicDao.create(clinic);
        LOGGER.info("create(...)=");
    }
}
