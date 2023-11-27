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

    private String street;
    @Column(name = "POST_CODE")
    private String postCode;

    public AddressEntity() {
    }

    public AddressEntity(String street, String postCode) {
        this.street = street;
        this.postCode = postCode;
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
                '}';
    }
}
