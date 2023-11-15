package pl.babiak.ruslana.java.project.hospital.dao;

import pl.babiak.ruslana.java.project.hospital.model.Address;
import pl.babiak.ruslana.java.project.hospital.model.Clinic;
import pl.babiak.ruslana.java.project.hospital.model.UniqueId;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

public class ClinicDao {
    private static final Logger LOGGER = Logger.getLogger(ClinicDao.class.getName());

    private final String URL = "jdbc:h2:~/ruslana-sql";
    private final String USERNAME = "sql";
    private final String PASSWORD = "";

    //create
    public Clinic create(Clinic clinic) {
        LOGGER.info("create(" + clinic + ")");
        String statement = "INSERT INTO CLINICS(ID, NAME, ADDRESS_ID)" +
                " VALUES(?,?,?)";
        UniqueId uniqueId = new UniqueId();
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(statement)) {
            int id = uniqueId.getUniqueId();

            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, clinic.getName());
            preparedStatement.setInt(3, -1);

            preparedStatement.executeUpdate();
            clinic.setId((long) id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        LOGGER.info("create(...)=" + clinic);
        return clinic;
    }

    //read
    public Clinic read(Integer id) {
        LOGGER.info("read(" + id + ")");

        Clinic clinic = null;
        String statement = "SELECT * FROM CLINICS";
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(statement)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                String name = resultSet.getString("NAME");
                String address = resultSet.getString("ADDRESS");
                Address clinicAddress = clinic.getAddress();
                System.out.println(name + "\n " + address);
                clinic = new Clinic(clinicAddress, name);
                clinic.setId(Long.valueOf(id));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        LOGGER.info("read(...)=" + id);

        return clinic;
    }

    //update

    //delete
}