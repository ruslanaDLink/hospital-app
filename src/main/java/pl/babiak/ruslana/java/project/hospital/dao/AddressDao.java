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

    private static final Logger LOGGER = Logger.getLogger(AddressDao.class.getName());

    private static final String ADDRESSES_INSERT_SQL = "INSERT INTO ADDRESS(STREET, FLAT_NUMBER, CITY, VOIVODESHIP, POSTCODE, COUNTRY)" +
            " VALUES (?,?,?,?,?,?)";

    private final String URL = "jdbc:h2:~/ruslana-sql";
    private final String USERNAME = "sql";
    private final String PASSWORD = "";


    //create
    public void createTable() {
        String tableCreationSQL = "CREATE TABLE ADDRESS(ADDRESS_ID IDENTITY, STREET VARCHAR (100) NOT NULL, " +
                "FLAT_NUMBER VARCHAR(50) NOT NULL, CITY VARCHAR(50) NOT NULL, VOIVODESHIP VARCHAR(50) NOT NULL, " +
                "POSTCODE VARCHAR(20), COUNTRY VARCHAR(50) NOT NULL)";
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement()) {

            statement.execute(tableCreationSQL);
            System.out.println("Table 'ADDRESS' created successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void list() {
        System.out.println("Getting address list");

        try (Connection connection = DriverManager.getConnection(
                URL, USERNAME, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT * FROM ADDRESS;")) {

            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("Result Set " + resultSet);
            while (resultSet.next()) {
                String city = resultSet.getString("CITY");
                System.out.println("CITY: " + city);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // C - create
    public Address create(Address address) {
        LOGGER.info("create(" + address + ")");

        String statement = "INSERT INTO ADDRESS VALUES (?,?,?,?,?,?,?)";
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(statement)) {

            int id = new UniqueId().getUniqueId();
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, address.getCountry());
            preparedStatement.setString(3, address.getCity());
            preparedStatement.setString(4, address.getVoivodeship());
            preparedStatement.setString(5, address.getPostCode());
            preparedStatement.setString(6, address.getStreet());
            preparedStatement.setString(7, address.getFlatNumber());

            preparedStatement.executeUpdate();
            address.setId((long) id);
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
    public Address read(Long addressId) {
        LOGGER.info("read(" + addressId + ")");

        Address address = null;
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM ADDRESS")) {

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
                String formatString = String.format("Id: %d;\nStreet: %s;\nFlat number: %s;\nCity: %s;\nVoivodeship: %s;\nPostcode: %s;\nCountry: %s",
                        id, street, flatNumber, city, voivodeship, postcode, country);
                System.out.println(formatString);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        LOGGER.info("read(...)=" + addressId);
        return address;
    }

    // U - update-SQL UPDATE
    public Address update(Address address) {
        LOGGER.info("update(" + address + ")");

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "UPDATE ADDRESS SET STREET = ? WHERE STREET=?")) {

            preparedStatement.setString(1, address.getStreet());
            preparedStatement.setString(2, address.getStreet());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        LOGGER.info("update(...)=" + address);
        return address;
    }

    // D - delete
    public void delete(Long id) {
        LOGGER.info("delete(" + id + ")");

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "DELETE FROM ADDRESS WHERE ADDRESS_ID=?;")) {

            preparedStatement.setLong(1, 1L);
            preparedStatement.executeUpdate();
            LOGGER.info("delete(...)=" + id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

