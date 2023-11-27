package pl.babiak.ruslana.java.project.hospital.service;

import pl.babiak.ruslana.java.project.hospital.dao.AddressDao;
import pl.babiak.ruslana.java.project.hospital.model.Address;

import java.util.logging.Logger;

public class AddressService {
    private static final Logger LOGGER = Logger.getLogger(AddressService.class.getName());
    private AddressDao addressDao;

    // TODO: 20/11/2023
    //praca domowa
    //dla pozostalych wybranych modeli stworzyc warstwe controller oraz service
    //dla poszczegolnych warstw zrobic DID
    //napisac test jednostkowydla controllerow


    public AddressService(AddressDao addressDao) {
        this.addressDao = addressDao;
    }

    public Address create(Address address) {
        LOGGER.info("create(" + address + ")");
        Address createdAddress = addressDao.create(address);
        LOGGER.info("create(...)=" + createdAddress);
        return createdAddress;
    }

    public void read() {

    }

    public void update() {

    }

    public void delete() {

    }

}
