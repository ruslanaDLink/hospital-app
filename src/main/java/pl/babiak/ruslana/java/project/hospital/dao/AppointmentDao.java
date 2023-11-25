package pl.babiak.ruslana.java.project.hospital.dao;


import pl.babiak.ruslana.java.project.hospital.model.Appointment;
import pl.babiak.ruslana.java.project.hospital.model.Doctor;
import pl.babiak.ruslana.java.project.hospital.model.Patient;
import pl.babiak.ruslana.java.project.hospital.model.Service;
import pl.babiak.ruslana.java.project.hospital.model.UniqueId;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.sql.Date;
import java.sql.Time;
import java.util.logging.Logger;

public class AppointmentDao {
    private static final Logger LOGGER = Logger.getLogger(ClinicDao.class.getName());

    private final String URL = "jdbc:h2:~/ruslana-sql";
    private final String USERNAME = "sql";
    private final String PASSWORD = "";

    public Appointment create(Appointment appointment) {
        LOGGER.info("create(" + appointment + ")");
        String statement = "INSERT INTO APPOINTMENTS(ID, DATE, TIME, PATIENT_ID, DOCTOR_ID, SERVICE_ID)" +
                " VALUES(?,?,?,?,?,?)";
        UniqueId uniqueId = new UniqueId();
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(statement)) {
            int id = uniqueId.getUniqueId();
            LocalDateTime localDateTime = LocalDateTime.now();
            Date date = Date.valueOf(localDateTime.toLocalDate());
            Time time = Time.valueOf(localDateTime.toLocalTime());
            preparedStatement.setInt(1, id);
            preparedStatement.setDate(2, date);
            preparedStatement.setTime(3, time);
            preparedStatement.setLong(4, appointment.getPatient().getId());
            preparedStatement.setLong(4, appointment.getDoctor().getId());
            preparedStatement.setLong(4, appointment.getService().getId());

            preparedStatement.executeUpdate();
            appointment.setId((long) id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        LOGGER.info("create(...)=" + appointment);
        return appointment;
    }

    public Appointment read(Long id) {
        LOGGER.info("read(" + id + ")");

        Appointment appointment = null;
        String statement = "SELECT * FROM APPOINTMENTS";
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(statement)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                long patientId = resultSet.getLong("PATIENT_ID");
                long doctorId = resultSet.getLong("DOCTOR_ID");
                long serviceId = resultSet.getLong("SERVICE_ID");

                Patient patient = new Patient();
                patient.setId(patientId);

                Doctor doctor = new Doctor();
                doctor.setId(doctorId);

                Service service = new Service();
                service.setId(serviceId);

                appointment = new Appointment(patient,
                     doctor, service, LocalDateTime.now());
                appointment.setId(id);
                System.out.println(
                        "Patient: " + appointment.getPatient()
                                + "\nDoctor: " + appointment.getDoctor()
                                + "\nService: " + appointment.getService()
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        LOGGER.info("read(...)=" + id);
        return appointment;
    }

    public Appointment update(Appointment appointment) {
        LOGGER.info("update(" + appointment + ")");
        UniqueId uniqueId = new UniqueId();
        appointment.setId((long) uniqueId.getUniqueId());

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "UPDATE APPOINTMENTS SET DATE=? WHERE ID=?")) {

            preparedStatement.setObject(1, appointment.getDate());
            preparedStatement.setLong(2, appointment.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        LOGGER.info("update(...)=" + appointment);
        return appointment;
    }

    public void delete(Long id) {
        LOGGER.info("delete(" + id + ")");

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "DELETE FROM APPOINTMENT DATE WHERE ID=?")) {

            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
            LOGGER.info("delete(...)=" + id);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
