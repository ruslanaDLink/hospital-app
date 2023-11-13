package pl.babiak.ruslana.java.project.hospital.dao;

import pl.babiak.ruslana.java.project.hospital.model.Patient;
import pl.babiak.ruslana.java.project.hospital.model.UniqueId;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PatientDao {
    private final String URL = "jdbc:h2:~/ruslana-sql";
    private final String USERNAME = "sql";
    private final String PASSWORD = "";

    //create
    public void createTable() {
        String tableCreationSQL = "CREATE TABLE PATIENT (PATIENT_ID INT NOT NULL UNIQUE, NAME VARCHAR(100) NOT NULL," +
                "AGE INT NOT NULL, PASSPORT_NUMBER VARCHAR(20) NOT NULL, HAS_INSURANCE BOOLEAN)";
        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();
            statement.execute(tableCreationSQL);
            System.out.println("Table 'PATIENT' created successfully.");
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // TODO: 06/11/2023
    // stworzyc oddzilna klase z metoda ktora bedzie generowala unikalne numery klientow + test jednostkowy
    //             preparedStatement.setInt(1, patient.getClientNumber());
    // zastapic powyzszy kod generatorem unikalnych numerow klientow
    public Patient insertValues(Patient patient) {
        String valuesInsertion = "INSERT INTO PATIENT (PATIENT_ID, NAME, AGE, PASSPORT_NUMBER, HAS_INSURANCE) " +
                "VALUES (?,?,?,?,?)";
        UniqueId uniqueId = new UniqueId();
        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(valuesInsertion);
            preparedStatement.setInt(1, uniqueId.getUniqueId());
            preparedStatement.setString(2, patient.getName());
            preparedStatement.setInt(3, patient.getAge());
            preparedStatement.setString(4, patient.getPassportNumber());
            preparedStatement.setBoolean(5, patient.isHasInsurance());

            preparedStatement.executeUpdate();
            // TODO: 06/11/2023
            // pobrac wygenerowane przez baza danych klucz glowny

            System.out.println("Insertion went successfully.");
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return patient;
    }

    //read
    public Patient read(UniqueId generatorId) {
        Patient patient = new Patient();
        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM PATIENT;");

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString("NAME");
                int age = resultSet.getInt("AGE");
                String passportNumber = resultSet.getString("PASSPORT_NUMBER");
                boolean hasInsurance = resultSet.getBoolean("HAS_INSURANCE");

                System.out.println("Patient: " + name + "\nAge: " + age + "\nPassport number: " + passportNumber + "\nInsurance presented? " + hasInsurance);
                patient = new Patient(name, age, passportNumber, patient.getAddress(), hasInsurance);
                preparedStatement.close();
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return patient;
    }

    //update
    public Patient update(Patient patient) {
        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE PATIENT SET AGE=? WHERE NAME=?");
            preparedStatement.setInt(1, patient.getAge() + 1);
            preparedStatement.setString(2, patient.getName());
            if (preparedStatement.executeUpdate() > 0) {
                System.out.println("Information updated successfully.");
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return patient;
    }

    //delete
    public void delete(UniqueId id) {
        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM PATIENT PASSPORT_NUMBER WHERE PATIENT_ID=?");
            preparedStatement.setInt(1, id.getUniqueId());
            preparedStatement.executeUpdate();
            System.out.println("Selected information deleted.");
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
