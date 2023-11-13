package pl.babiak.ruslana.java.project.hospital.dao;

import pl.babiak.ruslana.java.project.hospital.model.Address;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

public class AddressDao {
    private static final Logger LOGGER = Logger.getLogger(AddressDao.class.getName());

    private static final String ADDRESSES_INSERT_SQL = "INSERT INTO ADDRESS(STREET, FLAT_NUMBER, CITY, VOIVODESHIP, POSTCODE, COUNTRY)" +
            " VALUES (?,?,?,?,?,?)";

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
        LOGGER.info("create(" + address + ")");
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(ADDRESSES_INSERT_SQL, Statement.RETURN_GENERATED_KEYS)) {
            //  preparedStatement.setInt(1, 1);

            int i = 1;
            preparedStatement.setString(i++, address.getCountry());
            preparedStatement.setString(i++, address.getCity());
            preparedStatement.setString(i++, address.getVoivodeship());
            preparedStatement.setString(i++, address.getPostCode());
            preparedStatement.setString(i++, address.getStreet());
            preparedStatement.setString(i++, address.getFlatNumber());

            preparedStatement.executeUpdate();
            try (ResultSet keys = preparedStatement.getGeneratedKeys()) {
                if (keys.next()) {
                    long generatedId = keys.getLong(1);
                    //LOGGER.info("Generated Id: " + generatedId);
                    address.setId(generatedId);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        LOGGER.info("create(...)=" + address);
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
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            preparedStatement = connection.prepareStatement("UPDATE ADDRESS SET STREET = ? WHERE STREET=?");
            preparedStatement.setString(1, address.getStreet());
            preparedStatement.setString(2, address.getStreet());
            if (preparedStatement.executeUpdate() > 0) {
                System.out.println("Street name successfully updated.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
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

