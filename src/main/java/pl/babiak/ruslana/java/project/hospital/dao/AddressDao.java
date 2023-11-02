package pl.babiak.ruslana.java.project.hospital.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AddressDao {
    public void list() {
        System.out.println("Getting address list");
        //kroki do komunikacji z baza danych za pomoca JDBC
        //1. DriverManager
        //2. Connection
        //3. Statement/PreparedStatement
        //4. ResultSet
//CREATE TABLE ADDRESSES(ID INT PRIMARY KEY, NAME VARCHAR(255));
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:h2:~/test", "sa", "");
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM ADDRESSES;");
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("Result Set " + resultSet);
            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String name = resultSet.getString("NAME");
                System.out.println("ID: " + id + " " + "NAME: " + name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // TODO: 01/11/2023
    // dla ponizszych metod CRUD stworzyc kod JDBC ktory zawiera ponizsze
    // kroki do komunikacji z baza danych za pomoca JDBC
    // dla kazdej metody CRUD napisac test jednostkowy

    // C - create-SQL insert
    public void create() {
    }

    // R - read-SQL SELECT
    public void read() {
    }

    // U - update-SQL UPDATE
    public void update() {
    }

    // D - delete-SQL DELETE
    public void delete() {
    }
}

