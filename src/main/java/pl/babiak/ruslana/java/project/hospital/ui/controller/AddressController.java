package pl.babiak.ruslana.java.project.hospital.ui.controller;

import pl.babiak.ruslana.java.project.hospital.service.AddressService;

import java.util.logging.Logger;

public class AddressController {
    private static final Logger LOGGER = Logger.getLogger(AddressController.class.getName());

    private AddressService addressService; //dependency / zaleznosc / asocjacja

    public AddressController(AddressService addressService) { //injection / wstrzykiwanie zaleznosci
        this.addressService = addressService;
    }

    public void create(){
        LOGGER.info("create()");
        addressService.create(); //delegation / delegacja odpowiedzialnosci
        LOGGER.info("create(...)=");
    }

    public void read(){

    }

    public void update(){

    }

    public void delete(){

    }
}
