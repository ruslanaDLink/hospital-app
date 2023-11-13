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
            // preparedStatement.setInt(1, 1);
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
    public Clinic read(UniqueId id) {
        Clinic clinic = null;
        String query = "SELECT NAME FROM CLINIC JOIN ADDRESS ON CLINIC.CLINIC_ID=CLINIC.ADDRESS_ID";
        try {

            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("NAME");
                Object address = resultSet.getObject("ADDRESS");
                System.out.println(name + "\n " + address);
                clinic = new Clinic((Address) address, name);
            }

            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clinic;
    }

    //update

    //delete
}
