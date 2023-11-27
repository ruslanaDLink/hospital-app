package pl.babiak.ruslana.java.project.hospital.dao;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.sql.Connection;

class DatabaseManagerTest {

    @Test
    void getInstance() {
        //given

        //when
        DatabaseManager databaseManager = DatabaseManager.getInstance();

        //then
        Assertions.assertNotNull(databaseManager, "Test went wrong.");
    }

    @Test
    void connectToJdbc() {
        //given

        //when
        Connection connection = DatabaseManager.connectToJdbc();

        //then
        Assertions.assertNotNull(connection, "Connection not established.");
    }
}