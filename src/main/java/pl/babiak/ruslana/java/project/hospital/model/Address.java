package pl.babiak.ruslana.java.project.hospital.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Address {
    private Long id;
    private String street;
    private String flatNumber;
    private String city;
    private String voivodeship;
    private String postCode;
    private String country;
}
