package pl.babiak.ruslana.java.project.hospital.dao.hibernate.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="SERVICE_TEST")
public class ServiceEntity {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "SERVICE")
    private String service;
    @Column(name = "PRICE")
    private double price;


    public ServiceEntity() {
    }

    public ServiceEntity(String service, double price) {
        this.service = service;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ServiceEntity{" +
                "id=" + id +
                ", service='" + service + '\'' +
                ", price=" + price +
                '}';
    }
}
