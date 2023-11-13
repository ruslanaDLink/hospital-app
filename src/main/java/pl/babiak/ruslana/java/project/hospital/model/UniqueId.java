package pl.babiak.ruslana.java.project.hospital.model;

import java.util.Random;
import java.util.logging.Logger;


public class UniqueId {
    private static final Logger LOGGER = Logger.getLogger(UniqueId.class.getName());

    public int getUniqueId() {
       // System.out.println("getUniqueId()");
        LOGGER.info("getUniqueId()");
        Random random = new Random();
        int id = random.nextInt();
       // System.out.println("getUniqueId(...)=" + id);
        LOGGER.info("getUniqueId(...)=" + id);
        return id;
    }
}
