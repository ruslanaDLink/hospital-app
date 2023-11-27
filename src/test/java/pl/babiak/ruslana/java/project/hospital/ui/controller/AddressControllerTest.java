package pl.babiak.ruslana.java.project.hospital.ui.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.babiak.ruslana.java.project.hospital.dao.AddressDao;
import pl.babiak.ruslana.java.project.hospital.model.Address;
import pl.babiak.ruslana.java.project.hospital.service.AddressService;

import static org.junit.jupiter.api.Assertions.*;

class AddressControllerTest {

    @Test
    void create() {
        //given
        AddressDao addressDao = new AddressDao();
        AddressService addressService = new AddressService(addressDao);
        AddressController controller = new AddressController(addressService);
        Address address = Address.builder()
                .country("Poland")
                .voivodeship("Masovian")
                .city("Warsaw)")
                .postCode("00-082")
                .street("Mickiewicza 34")
                .flatNumber("12").build();

        //when
        Address createdAddress = controller.create(address);

        //then
        Assertions.assertNotNull(createdAddress, "Address not created.");
    }
}