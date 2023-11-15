package pl.babiak.ruslana.java.project.hospital.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.babiak.ruslana.java.project.hospital.model.Address;

import static org.junit.jupiter.api.Assertions.*;

class AddressDaoTest {

    @Test
    void createTable() {
        AddressDao addressDao = new AddressDao();
        addressDao.createTable();
    }

    @Test
    void list() {
        //given
        AddressDao addressDao = new AddressDao();
        //when
        addressDao.list();
        //then
    }

    @Test
    void create() {
        //given
        AddressDao addressDao = new AddressDao();
        Address address = Address.builder()
                .country("Poland")
                .voivodeship("Masovian")
                .postCode("00-002")
                .city("Warsaw")
                .street("Pulawska")
                .flatNumber("2A")
                .build();

        //when
        Address createdAddress = addressDao.create(address);

        //then
        Assertions.assertAll(
                () -> Assertions.assertNotNull(createdAddress, "Address not inserted."),
                () -> Assertions.assertNotNull(createdAddress.getId(), "Id is null.")
        );
    }

    @Test
    void read() {
        //given
        AddressDao addressDao = new AddressDao();

        Address address = Address.builder()
                .street("Pulawska")
                .flatNumber("2A")
                .city("Warsaw")
                .voivodeship("Masovian")
                .postCode("00-002")
                .country("Poland")
                .build();

        //when
        Address readAddressInfo = addressDao.read(address.getId());

        //then
        Assertions.assertNotNull(readAddressInfo, "Address is null.");
    }

    @Test
    void update() {
        //given
        AddressDao addressDao = new AddressDao();
        Address address = Address.builder()
                .country("Poland")
                .voivodeship("Masovian")
                .postCode("00-002")
                .city("Warsaw")
                .street("Pulawska")
                .flatNumber("2A")
                .build();
        //when
        Address updatedAddress = addressDao.update(address);

        //then
        Assertions.assertNotNull(updatedAddress, "Failed update.");
    }

    @Test
    void delete() {
        //given
        AddressDao addressDao = new AddressDao();
        Address address = Address.builder()
                .country("Poland")
                .voivodeship("Masovian")
                .postCode("00-002")
                .city("Warsaw")
                .street("Pulawska")
                .flatNumber("2A")
                .build();

        //when
        addressDao.delete(address.getId());
        //then
    }
}