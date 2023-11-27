package pl.babiak.ruslana.java.project.hospital.dao.hibernate.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "CLINIC_TEST")
public class ClinicEntity {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    public ClinicEntity() {
    }

    public ClinicEntity(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return "ClinicEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
