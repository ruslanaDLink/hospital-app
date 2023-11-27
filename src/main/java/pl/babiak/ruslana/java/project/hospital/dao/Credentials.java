package pl.babiak.ruslana.java.project.hospital.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Credentials {
    private static final File file = new File("src/main/java/pl/babiak/ruslana/java/project/hospital/credentials.properties");

    public static Properties loadCredentials() {
        Properties properties = new Properties();
        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
