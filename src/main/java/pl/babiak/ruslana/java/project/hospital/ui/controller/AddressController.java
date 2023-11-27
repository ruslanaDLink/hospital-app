package pl.babiak.ruslana.java.project.hospital.ui.controller;

import pl.babiak.ruslana.java.project.hospital.model.Address;
import pl.babiak.ruslana.java.project.hospital.service.AddressService;

import java.util.logging.Logger;

public class AddressController {
    private static final Logger LOGGER = Logger.getLogger(AddressController.class.getName());

    private AddressService addressService; //dependency / zaleznosc / asocjacja

    public AddressController(AddressService addressService) { //injection / wstrzykiwanie zaleznosci
        this.addressService = addressService;
    }

    public Address create(Address address) {
        LOGGER.info("create(" + address + ")");
        Address createdAddress = addressService.create(address);//delegation / delegacja odpowiedzialnosci
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
