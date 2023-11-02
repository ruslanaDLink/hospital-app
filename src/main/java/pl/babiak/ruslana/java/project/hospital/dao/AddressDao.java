package pl.babiak.ruslana.java.project.hospital.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AddressDao {
    private final String URL = "jdbc:h2:~/ruslana-sql";
    private final String USERNAME = "sql";
    private final String PASSWORD = "";

    public void list() {
        System.out.println("Getting address list");

        try {
            Connection connection = DriverManager.getConnection(
                    URL, USERNAME, PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM ADDRESS;");
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("Result Set " + resultSet);
            while (resultSet.next()) {
                String city = resultSet.getString("CITY");
                System.out.println("CITY: " + city);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // C - create
    public void create() {
        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO ADDRESS VALUES (?,?,?,?,?)");
            preparedStatement.setString(1, "Poland");
            preparedStatement.setString(2, "Warsaw");
            preparedStatement.setString(3, "Masovian");
            preparedStatement.setString(4, "02-943");
            preparedStatement.setString(5, "Urle 1");

            int resultSet = preparedStatement.executeUpdate();
            System.out.println("CREATE");
            if (resultSet > 0) {
                System.out.println("Record created: " + resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // R - read
    public void read() {
        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM ADDRESS");
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("Hospital Address");
            if (resultSet.next()) {
                String country = resultSet.getString("COUNTRY");
                String city = resultSet.getString("CITY");
                String voivodeship = resultSet.getString("VOIVODESHIP");
                String postcode = resultSet.getString("POSTCODE");
                String street = resultSet.getString("STREET");

                System.out.println("Country: " + country + "\nCity: " + city + "\nVoivodeship: " + voivodeship + "\nPostcode: " + postcode
                        + "\nStreet: " + street);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // U - update-SQL UPDATE
    public void update() {
        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE ADDRESS SET STREET = ?");
            preparedStatement.setString(1, "Leszczynowa");
            if (preparedStatement.executeUpdate() > 0) {
                System.out.println("Street name successfully updated.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // D - delete
    public void delete() {
        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE ADDRESS");
            preparedStatement.executeUpdate();
            System.out.println("Address deletion went with success.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

