package pl.babiak.ruslana.java.project.hospital.dao;

import pl.babiak.ruslana.java.project.hospital.model.Patient;
import pl.babiak.ruslana.java.project.hospital.model.UniqueId;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

public class PatientDao {
    private static final Logger LOGGER = Logger.getLogger(PatientDao.class.getName());

    private static final Connection connection = DatabaseManager.connectToJdbc();

    //create
    public void createTable() {
        LOGGER.info("createTable()");

        String tableCreationSQL = "CREATE TABLE PATIENT (PATIENT_ID IDENTITY, NAME VARCHAR(100) NOT NULL," +
                "AGE INT NOT NULL, PASSPORT_NUMBER VARCHAR(20) NOT NULL, HAS_INSURANCE BOOLEAN)";
        try (Statement statement = connection.createStatement()) {

            statement.execute(tableCreationSQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        LOGGER.info("createTable(...)=");
    }

    // TODO: 13/11/2023
    // napisac ponizsza metode analogicznie do metody ClinicDao create()

    public Patient insertValues(Patient patient) {
        LOGGER.info("insertValues(" + patient + ")");

        String valuesInsertion = "INSERT INTO PATIENT (PATIENT_ID, NAME, AGE, PASSPORT_NUMBER, HAS_INSURANCE) " +
                "VALUES (?,?,?,?,?)";
        UniqueId uniqueId = new UniqueId();
        try (PreparedStatement preparedStatement = connection.prepareStatement(valuesInsertion)) {

            int id = uniqueId.getUniqueId();
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, patient.getName());
            preparedStatement.setInt(3, patient.getAge());
            preparedStatement.setString(4, patient.getPassportNumber());
            preparedStatement.setBoolean(5, patient.isHasInsurance());

            preparedStatement.executeUpdate();
            patient.setId((long) id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        LOGGER.info("insertValues(...)=" + patient);
        return patient;
    }

    //read
    public Patient read(Long id) {
        LOGGER.info("read(" + id + ")");

        Patient patient = new Patient();

        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM PATIENT;")) {
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString("NAME");
                int age = resultSet.getInt("AGE");
                String passportNumber = resultSet.getString("PASSPORT_NUMBER");
                boolean hasInsurance = resultSet.getBoolean("HAS_INSURANCE");
                System.out.println("Patient: " + name + "\nAge: " + age + "\nPassport number: " + passportNumber + "\nInsurance presented? " + hasInsurance);
                patient = new Patient(name, age, passportNumber, patient.getAddress(), hasInsurance);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        LOGGER.info("read(...)=" + id);
        return patient;
    }

    //update
    public Patient update(Patient patient) {
        LOGGER.info("update(" + patient + ")");
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                     "UPDATE PATIENT SET AGE=? WHERE NAME=?")) {
            preparedStatement.setInt(1, patient.getAge() + 1);
            preparedStatement.setString(2, patient.getName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        LOGGER.info("update(...)=" + patient);
        return patient;
    }

    //delete
    public void delete(Integer id) {
        LOGGER.info("delete(" + id + ")");
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                     "DELETE FROM PATIENT PASSPORT_NUMBER WHERE PATIENT_ID=?")) {

            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            LOGGER.info("delete(...)=" + id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
