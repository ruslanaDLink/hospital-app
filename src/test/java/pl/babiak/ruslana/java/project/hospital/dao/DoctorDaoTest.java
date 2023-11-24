package pl.babiak.ruslana.java.project.hospital.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.babiak.ruslana.java.project.hospital.model.Doctor;
import pl.babiak.ruslana.java.project.hospital.model.DoctorType;
import pl.babiak.ruslana.java.project.hospital.model.UniqueId;

import static org.junit.jupiter.api.Assertions.*;

class DoctorDaoTest {

    @Test
    void create() {
        //given
        DoctorDao doctorDao = new DoctorDao();
        UniqueId uniqueId = new UniqueId();
        Doctor doctor = new Doctor("Alec Smith", DoctorType.ONCOLOGIST);
        doctor.setId((long) uniqueId.getUniqueId());

        //when
        Doctor createdDoctor = doctorDao.create(doctor);

        //then
        Assertions.assertNotNull(createdDoctor, "Doctor is not created.");
    }

    @Test
    void read() {
        //given
        DoctorDao doctorDao = new DoctorDao();
        UniqueId uniqueId = new UniqueId();
        Doctor doctor = new Doctor("Alec Smith", DoctorType.ONCOLOGIST);
        doctor.setId((long) uniqueId.getUniqueId());

        //when
        Doctor readDoctor = doctorDao.read(doctor.getId());

        //then
        Assertions.assertNotNull(readDoctor, "Doctor doesn't have any information to read.");
    }

    @Test
    void update() {
        //given
        DoctorDao doctorDao = new DoctorDao();
        UniqueId uniqueId = new UniqueId();
        Doctor doctor = new Doctor("Alec Smith", DoctorType.ONCOLOGIST);
        doctor.setId((long) uniqueId.getUniqueId());

        //when
        Doctor updatedDoctor = doctorDao.update(doctor);

        //then
        Assertions.assertNotNull(updatedDoctor, "Doctor is not updated.");
    }

    @Test
    void delete() {
        //given
        DoctorDao doctorDao = new DoctorDao();
        UniqueId uniqueId = new UniqueId();
        Doctor doctor = new Doctor("Alec Smith", DoctorType.ONCOLOGIST);
        doctor.setId((long) uniqueId.getUniqueId());

        //when
        doctorDao.delete(doctor.getId());

        //then
    }
}