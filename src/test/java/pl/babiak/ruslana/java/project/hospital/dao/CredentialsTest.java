package pl.babiak.ruslana.java.project.hospital.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Properties;

import static org.junit.jupiter.api.Assertions.*;

class CredentialsTest {

    @Test
     void loadCredentialsTest() {
        //given

        //when
        Properties properties = Credentials.loadCredentials();

        //then
        Assertions.assertNotNull(properties, "Failed to load properties.");
    }
}