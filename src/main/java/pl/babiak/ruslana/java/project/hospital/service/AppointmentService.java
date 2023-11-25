package pl.babiak.ruslana.java.project.hospital.service;

import pl.babiak.ruslana.java.project.hospital.dao.AppointmentDao;
import pl.babiak.ruslana.java.project.hospital.model.Appointment;
import pl.babiak.ruslana.java.project.hospital.model.Doctor;
import pl.babiak.ruslana.java.project.hospital.model.Patient;
import pl.babiak.ruslana.java.project.hospital.model.Service;

import java.time.LocalDateTime;
import java.util.logging.Logger;

public class AppointmentService {
    private static final Logger LOGGER = Logger.getLogger(AppointmentService.class.getName());

    private AppointmentDao appointmentDao;

    public AppointmentService(AppointmentDao appointmentDao) {
        this.appointmentDao = appointmentDao;
    }

    public void create() {
        LOGGER.info("create(" + ")");
        Appointment appointment = new Appointment(new Patient(), new Doctor(),
                new Service(), LocalDateTime.now());
        appointmentDao.create(appointment);
        LOGGER.info("create(...)=");
    }
}
