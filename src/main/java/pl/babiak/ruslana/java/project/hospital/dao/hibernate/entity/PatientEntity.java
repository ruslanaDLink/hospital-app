package pl.babiak.ruslana.java.project.hospital.dao.hibernate.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import pl.babiak.ruslana.java.project.hospital.model.Address;

@Entity
@Table(name = "PATIENT_TEST")
public class PatientEntity {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "AGE")
    private int age;
    @Column(name = "PASSPORT_NUMBER")
    private String passportNumber;
    @Column(name = "ADDRESS")
    private Address address;
    @Column(name = "HAS_INSURANCE")
    private boolean hasInsurance;

    public PatientEntity() {
    }

    public PatientEntity(String name, int age, String passportNumber, Address address, boolean hasInsurance) {
        this.name = name;
        this.age = age;
        this.passportNumber = passportNumber;
        this.address = address;
        this.hasInsurance = hasInsurance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public boolean isHasInsurance() {
        return hasInsurance;
    }

    public void setHasInsurance(boolean hasInsurance) {
        this.hasInsurance = hasInsurance;
    }

    @Override
    public String toString() {
        return "PatientEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", passportNumber='" + passportNumber + '\'' +
                ", address=" + address +
                ", hasInsurance=" + hasInsurance +
                '}';
    }
}
