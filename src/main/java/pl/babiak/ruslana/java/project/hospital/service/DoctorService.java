package pl.babiak.ruslana.java.project.hospital.service;

import pl.babiak.ruslana.java.project.hospital.dao.DoctorDao;
import pl.babiak.ruslana.java.project.hospital.model.Doctor;
import pl.babiak.ruslana.java.project.hospital.model.DoctorType;
import pl.babiak.ruslana.java.project.hospital.model.UniqueId;

import java.util.logging.Logger;

public class DoctorService {
    private static final Logger LOGGER = Logger.getLogger(DoctorService.class.getName());

    private DoctorDao doctorDao;

    public DoctorService(DoctorDao doctorDao) {
        this.doctorDao = doctorDao;
    }

    public void create() {
        LOGGER.info("create(" + ")");
        UniqueId uniqueId = new UniqueId();
        Doctor doctor = new Doctor("Alec Smith", DoctorType.ONCOLOGIST);
        doctor.setId((long) uniqueId.getUniqueId());
        doctorDao.create(doctor);
        LOGGER.info("create(...)=");
    }
}
