package pl.babiak.ruslana.java.project.hospital.dao;

import pl.babiak.ruslana.java.project.hospital.model.Doctor;
import pl.babiak.ruslana.java.project.hospital.model.DoctorType;
import pl.babiak.ruslana.java.project.hospital.model.UniqueId;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

public class DoctorDao {
    private static final Logger LOGGER = Logger.getLogger(DoctorDao.class.getName());

    private static final Connection connection = DatabaseManager.connectToJdbc();

    public Doctor create(Doctor doctor) {
        LOGGER.info("create(" + doctor + ")");
        String statement = "INSERT INTO DOCTORS(DOCTOR_ID, NAME, DOCTOR_TYPE) VALUES (?,?,?);";
        UniqueId uniqueId = new UniqueId();
        try (PreparedStatement preparedStatement = connection.prepareStatement(statement)) {
            int id = uniqueId.getUniqueId();
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, doctor.getName());
            preparedStatement.setString(3, doctor.getType().name());

            preparedStatement.executeUpdate();
            doctor.setId((long) id);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        LOGGER.info("create(...)=" + doctor);
        return doctor;
    }

    public Doctor read(Long id) {
        LOGGER.info("read(" + id + ")");

        Doctor doctor = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM DOCTORS;")) {
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                long doctorsId = resultSet.getLong("DOCTOR_ID");
                String name = resultSet.getString("NAME");
                String doctorType = resultSet.getString("DOCTOR_TYPE");
                doctor = new Doctor(name, DoctorType.valueOf(doctorType));
                System.out.println("ID: " + doctorsId + "\nName: " + name + "\nDoctor type: " + doctorType);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        LOGGER.info("read(...)=" + id);

        return doctor;
    }

    public Doctor update(Doctor doctor) {
        LOGGER.info("update(" + doctor + ")");

        try (PreparedStatement preparedStatement = connection.prepareStatement(
                        "UPDATE DOCTORS SET DOCTOR_TYPE=? WHERE DOCTOR_ID=?")) {
            preparedStatement.setString(1, doctor.getType().name());
            preparedStatement.setLong(2, doctor.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        LOGGER.info("update(...)=" + doctor);
        return doctor;
    }

    public void delete(Long id) {
        LOGGER.info("delete(" + id + ")");

        try (PreparedStatement preparedStatement = connection.prepareStatement(
                        "DELETE FROM DOCTORS NAME WHERE DOCTOR_ID=?")) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
            LOGGER.info("delete(...)=" + id);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
