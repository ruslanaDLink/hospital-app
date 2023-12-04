package pl.babiak.ruslana.java.project.hospital.dao.hibernate.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ADDRESS_TEST")
public class AddressEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name="STREET")
    private String street;
    @Column(name = "POST_CODE")
    private String postCode;
    @Column(name="FLAT_NUMBER")
    private String flatNumber;
    @Column(name="CITY")
    private String city;
    @Column(name="VOIVODESHIP")
    private String voivodeship;
    @Column(name="COUNTRY")
    private String country;

    public AddressEntity() {
    }

    public AddressEntity(String street, String postCode, String flatNumber, String city, String voivodeship, String country) {
        this.street = street;
        this.postCode = postCode;
        this.flatNumber = flatNumber;
        this.city = city;
        this.voivodeship = voivodeship;
        this.country = country;
    }

    public String getFlatNumber() {
        return flatNumber;
    }

    public void setFlatNumber(String flatNumber) {
        this.flatNumber = flatNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getVoivodeship() {
        return voivodeship;
    }

    public void setVoivodeship(String voivodeship) {
        this.voivodeship = voivodeship;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    @Override
    public String toString() {
        return "AddressEntity{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", postCode='" + postCode + '\'' +
                ", flatNumber='" + flatNumber + '\'' +
                ", city='" + city + '\'' +
                ", voivodeship='" + voivodeship + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
