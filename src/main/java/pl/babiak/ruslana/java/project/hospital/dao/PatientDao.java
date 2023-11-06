package pl.babiak.ruslana.java.project.hospital.dao;

import pl.babiak.ruslana.java.project.hospital.model.Patient;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PatientDao {
    // TODO: 01/11/2023
    // dla ponizszych metod CRUD stworzyc kod JDBC ktory zawiera ponizsze
    // kroki do komunikacji z baza danych za pomoca JDBC
    // dla kazdej metody CRUD napisac test jednostkowy

    private final String URL = "jdbc:h2:~/ruslana-sql";
    private final String USERNAME = "sql";
    private final String PASSWORD = "";

    //create
    public void createTable() {
        String tableCreationSQL = "CREATE TABLE PATIENT (CLIENT_NUMBER INT PRIMARY KEY, NAME VARCHAR(100) NOT NULL," +
                "AGE INT NOT NULL, PASSPORT_NUMBER VARCHAR(20) NOT NULL, HAS_INSURANCE BOOLEAN)";
        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();
            statement.execute(tableCreationSQL);
            System.out.println("Table 'PATIENT' created successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Patient insertValues (Patient patient) {
        String valuesInsertion = "INSERT INTO PATIENT (CLIENT_NUMBER, NAME, AGE, PASSPORT_NUMBER, HAS_INSURANCE) " +
                "VALUES (?,?,?,?,?)";
        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(valuesInsertion);
            preparedStatement.setInt(1, patient.getClientNumber());
            preparedStatement.setString(2, patient.getName());
            preparedStatement.setInt(3, patient.getAge());
            preparedStatement.setString(4, patient.getPassportNumber());
            preparedStatement.setBoolean(5, patient.isHasInsurance());

            preparedStatement.executeUpdate();

            System.out.println("Insertion went successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //read
    public void read() {
        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM PATIENT");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int patientNumber = resultSet.getInt("CLIENT_NUMBER");
                String name = resultSet.getString("NAME");
                int age = resultSet.getInt("AGE");
                String passportNumber = resultSet.getString("PASSPORT_NUMBER");
                boolean hasInsurance = resultSet.getBoolean("HAS_INSURANCE");

                String readingContent = "Patient %d: %s, age: %d; passport number: %s; insurance presented: %b";
                System.out.printf((readingContent) + "%n", patientNumber, name, age, passportNumber, hasInsurance);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //update
    public void update() {
        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE PATIENT SET AGE=? WHERE CLIENT_NUMBER=1");
            preparedStatement.setInt(1, 25);
            if (preparedStatement.executeUpdate() > 0) {
                System.out.println("Patient`s update age went successfully.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //delete
    public void delete() {
        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM PATIENT WHERE CLIENT_NUMBER=2");
            preparedStatement.executeUpdate();
            System.out.println("Patient deleted.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
