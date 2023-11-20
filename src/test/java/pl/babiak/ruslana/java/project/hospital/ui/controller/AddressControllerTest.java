package pl.babiak.ruslana.java.project.hospital.ui.controller;

import org.junit.jupiter.api.Test;
import pl.babiak.ruslana.java.project.hospital.service.AddressService;

import static org.junit.jupiter.api.Assertions.*;

class AddressControllerTest {

    @Test
    void create() {
        //given
        AddressService addressService = new AddressService();
        AddressController controller = new AddressController(addressService);

        //when
        controller.create();

        //then

    }
}