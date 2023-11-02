package pl.babiak.ruslana.java.project.hospital.dao;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddressDaoTest {

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
        AddressDao addressDao = new AddressDao();
        addressDao.create();
    }

    @Test
    void read() {
        AddressDao addressDao = new AddressDao();
        addressDao.read();
    }

    @Test
    void update() {
        AddressDao addressDao = new AddressDao();
        addressDao.update();
    }

    @Test
    void delete() {
        AddressDao addressDao = new AddressDao();
        addressDao.delete();
    }
}