package pl.babiak.ruslana.java.project.hospital.dao;

import pl.babiak.ruslana.java.project.hospital.model.Service;
import pl.babiak.ruslana.java.project.hospital.model.UniqueId;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

public class ServiceDao {
    private static final Logger LOGGER = Logger.getLogger(ServiceDao.class.getName());

    private final String URL = "jdbc:h2:~/ruslana-sql";
    private final String USERNAME = "sql";
    private final String PASSWORD = "";

    public Service create(Service service) {
        LOGGER.info("create(" + service + ")");
        String statement = "INSERT INTO SERVICES(SERVICE_ID, SERVICE, PRICE)" +
                " VALUES(?,?,?)";
        UniqueId uniqueId = new UniqueId();
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(statement)) {
            int id = uniqueId.getUniqueId();

            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, service.getService());
            preparedStatement.setDouble(3, service.getPrice());

            preparedStatement.executeUpdate();
            service.setId((long) id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        LOGGER.info("create(...)=" + service);
        return service;

    }

    public Service read(Long id) {
        LOGGER.info("read(" + id + ")");

        Service service = null;
        String statement = "SELECT * FROM SERVICES";
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(statement)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                String certainService = resultSet.getString("SERVICE");
                double price = resultSet.getDouble("PRICE");

                System.out.println("ID: " + id + "\nService: " + certainService + "\nPrice: " + price);
                service = new Service(certainService, price);
                service.setId(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        LOGGER.info("read(...)=" + id);
        return service;
    }

    public Service update(Service service) {
        LOGGER.info("update(" + service + ")");

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "UPDATE SERVICES SET PRICE=? WHERE SERVICE=?")) {

            preparedStatement.setDouble(1, service.getPrice());
            preparedStatement.setString(2, service.getService());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        LOGGER.info("update(...)=" + service);
        return service;

    }

    public void delete(Long id) {
        LOGGER.info("delete(" + id + ")");

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "DELETE FROM SERVICES SERVICE WHERE SERVICE_ID=?")) {

            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
            LOGGER.info("delete(...)=" + id);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
