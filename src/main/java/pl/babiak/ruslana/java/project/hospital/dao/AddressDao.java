package pl.babiak.ruslana.java.project.hospital.dao;

import pl.babiak.ruslana.java.project.hospital.model.Address;
import pl.babiak.ruslana.java.project.hospital.model.UniqueId;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AddressDao {
    private final String URL = "jdbc:h2:~/ruslana-sql";
    private final String USERNAME = "sql";
    private final String PASSWORD = "";


    //create
    public void createTable() {
        String tableCreationSQL = "CREATE TABLE ADDRESS(ADDRESS_ID INT PRIMARY KEY, STREET VARCHAR (100) NOT NULL, " +
                "FLAT_NUMBER VARCHAR(50) NOT NULL, CITY VARCHAR(50) NOT NULL, VOIVODESHIP VARCHAR(50) NOT NULL, " +
                "POSTCODE VARCHAR(20), COUNTRY VARCHAR(50) NOT NULL)";
        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();
            statement.execute(tableCreationSQL);
            System.out.println("Table 'ADDRESS' created successfully.");
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

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
    public Address create(Address address) {

        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO ADDRESS VALUES (?,?,?,?,?,?,?)");
            preparedStatement.setInt(1, 1);
            preparedStatement.setString(2, address.getCountry());
            preparedStatement.setString(3, address.getCity());
            preparedStatement.setString(4, address.getVoivodeship());
            preparedStatement.setString(5, address.getPostCode());
            preparedStatement.setString(6, address.getStreet());
            preparedStatement.setString(7, address.getFlatNumber());

            preparedStatement.executeUpdate();
            System.out.println("Address created.");
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return address;
    }

    // R - read
    public Address read() {
        Address address = null;
        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM ADDRESS");
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("Hospital Address");
            if (resultSet.next()) {
                int id = resultSet.getInt("ADDRESS_ID");
                String country = resultSet.getString("COUNTRY");
                String city = resultSet.getString("CITY");
                String voivodeship = resultSet.getString("VOIVODESHIP");
                String postcode = resultSet.getString("POSTCODE");
                String street = resultSet.getString("STREET");
                String flatNumber = resultSet.getString("FLAT_NUMBER");
                address = Address.builder()
                        .country(country)
                        .voivodeship(voivodeship)
                        .city(city)
                        .postCode(postcode)
                        .street(street)
                        .flatNumber(flatNumber)
                        .build();
                String formatString = id + ". Country: %s;\nCity: %s;\nVoivodeship: %s;\nPostcode: %s;\nStreet: %s;\nFlat number: %s";
                System.out.printf(formatString, country, city, voivodeship, postcode, street, flatNumber);
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return address;
    }

    // U - update-SQL UPDATE
    public Address update(Address address) {
        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE ADDRESS SET STREET = ? WHERE STREET=?");
            preparedStatement.setString(1, "Leszczynowa");
            preparedStatement.setString(2, address.getStreet());
            if (preparedStatement.executeUpdate() > 0) {
                System.out.println("Street name successfully updated.");
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return address;
    }

    // D - delete
    public void delete() {
        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM ADDRESS WHERE STREET=?;");
            preparedStatement.setString(1, "Pulawska");
            preparedStatement.executeUpdate();
            System.out.println("Deleted successfully.");
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

