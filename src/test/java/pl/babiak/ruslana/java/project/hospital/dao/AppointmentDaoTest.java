package pl.babiak.ruslana.java.project.hospital.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.babiak.ruslana.java.project.hospital.model.Address;
import pl.babiak.ruslana.java.project.hospital.model.Appointment;
import pl.babiak.ruslana.java.project.hospital.model.Doctor;
import pl.babiak.ruslana.java.project.hospital.model.DoctorType;
import pl.babiak.ruslana.java.project.hospital.model.Patient;
import pl.babiak.ruslana.java.project.hospital.model.Service;
import pl.babiak.ruslana.java.project.hospital.model.UniqueId;

import javax.print.Doc;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class AppointmentDaoTest {

    @Test
    void create() {
        //given
        Address address = Address.builder()
                .country("Poland")
                .voivodeship("Masovian")
                .postCode("00-002")
                .city("Warsaw")
                .street("Pulawska")
                .flatNumber("2A")
                .build();
        Patient patient = new Patient("Agata Kowalska", 28, "FA345", address, true);
        Doctor doctor = new Doctor("Jacob Russel", DoctorType.DERMATOLOGIST);
        Service service = new Service("Acne Treatment", 50.00);
        Appointment appointment = new Appointment(patient, doctor, service, LocalDateTime.now());
        AppointmentDao appointmentDao = new AppointmentDao();

        //when
        Appointment createdAppointment = appointmentDao.create(appointment);

        //then
        Assertions.assertNotNull(createdAppointment, "Appointment failed to be reserved.");
    }

    @Test
    void read() {
        //given
        Address address = Address.builder()
                .country("Poland")
                .voivodeship("Masovian")
                .postCode("00-002")
                .city("Warsaw")
                .street("Pulawska")
                .flatNumber("2A")
                .build();
        Patient patient = new Patient("Agata Kowalska", 28, "FA345", address, true);
        Doctor doctor = new Doctor("Jacob Russel", DoctorType.DERMATOLOGIST);
        Service service = new Service("Acne Treatment", 50.00);
        Appointment appointment = new Appointment(patient, doctor, service, LocalDateTime.now());
        UniqueId uniqueId = new UniqueId();
        patient.setId((long) uniqueId.getUniqueId());
        doctor.setId((long) uniqueId.getUniqueId());
        service.setId((long) uniqueId.getUniqueId());
        address.setId((long) uniqueId.getUniqueId());
        appointment.setId((long) uniqueId.getUniqueId());
        AppointmentDao appointmentDao = new AppointmentDao();

        //when
        //Appointment appointmentInformation = );

        //then
        Assertions.assertNotNull(appointmentDao.read(appointment.getId()), "No information for such appointment.");
    }

    @Test
    void update() {
        //given
        Address address = Address.builder()
                .country("Poland")
                .voivodeship("Masovian")
                .postCode("00-002")
                .city("Warsaw")
                .street("Pulawska")
                .flatNumber("2A")
                .build();
        Patient patient = new Patient("Agata Kowalska", 28, "FA345", address, true);
        Doctor doctor = new Doctor("Jacob Russel", DoctorType.DERMATOLOGIST);
        Service service = new Service("Acne Treatment", 50.00);
        Appointment appointment = new Appointment(patient, doctor, service, LocalDateTime.now());
        AppointmentDao appointmentDao = new AppointmentDao();
        //when
        Appointment updatedAppointment = appointmentDao.update(appointment);

        //then
        Assertions.assertNotNull(updatedAppointment, "Update failed.");
    }

    @Test
    void delete() {
        //given
        Address address = Address.builder()
                .country("Poland")
                .voivodeship("Masovian")
                .postCode("00-002")
                .city("Warsaw")
                .street("Pulawska")
                .flatNumber("2A")
                .build();
        Patient patient = new Patient("Agata Kowalska", 28, "FA345", address, true);
        Doctor doctor = new Doctor("Jacob Russel", DoctorType.DERMATOLOGIST);
        Service service = new Service("Acne Treatment", 50.00);
        Appointment appointment = new Appointment(patient, doctor, service, LocalDateTime.now());
        AppointmentDao appointmentDao = new AppointmentDao();
        UniqueId uniqueId = new UniqueId();
        appointment.setId((long) uniqueId.getUniqueId());

        //when
        appointmentDao.delete(appointment.getId());

        //then

    }
}