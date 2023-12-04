package pl.babiak.ruslana.java.project.hospital.dao.hibernate.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import pl.babiak.ruslana.java.project.hospital.model.Address;
import pl.babiak.ruslana.java.project.hospital.model.Appointment;

import java.util.List;

@Entity
@Table(name = "CLINIC_TEST")
public class ClinicEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Address address;
    @JoinColumn(name="APPOINTMENTS")
    private List<Appointment> appointmentList;

    public ClinicEntity() {
    }

    public ClinicEntity(String name, Address address, List<Appointment> appointmentList) {
        this.name = name;
        this.address = address;
        this.appointmentList = appointmentList;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Appointment> getAppointmentList() {
        return appointmentList;
    }

    public void setAppointmentList(List<Appointment> appointmentList) {
        this.appointmentList = appointmentList;
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
                "name='" + name + '\'' +
                ", address=" + address +
                ", appointmentList=" + appointmentList +
                '}';
    }
}
