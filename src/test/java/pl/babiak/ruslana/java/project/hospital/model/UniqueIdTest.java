package pl.babiak.ruslana.java.project.hospital.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UniqueIdTest {

    @Test
    void getUniqueId() {
        //given
        UniqueId uniqueId = new UniqueId();

        //when
        int firstId = uniqueId.getUniqueId();
        int secondId = uniqueId.getUniqueId();

        //then
        Assertions.assertNotEquals(firstId, secondId, "Ids are equal.");
    }
}