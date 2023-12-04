package pl.babiak.ruslana.java.project.hospital.dao.hibernate.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

@Entity
@Table(name = "CLINIC_TEST")
public class ClinicEntity {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "ADDRESS")
    private AddressEntity address;
    @Column(name = "APPOINTMENTS")
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "ClinicEntity")
    private List<AppointmentEntity> appointmentEntityList;

    public ClinicEntity() {
    }

    public ClinicEntity(String name, AddressEntity address, List<AppointmentEntity> appointmentEntityList) {
        this.name = name;
        this.address = address;
        this.appointmentEntityList = appointmentEntityList;
    }

    public AddressEntity getAddress() {
        return address;
    }

    public void setAddress(AddressEntity address) {
        this.address = address;
    }

    public List<AppointmentEntity> getAppointmentEntityList() {
        return appointmentEntityList;
    }

    public void setAppointmentEntityList(List<AppointmentEntity> appointmentEntityList) {
        this.appointmentEntityList = appointmentEntityList;
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
                ", appointmentList=" + appointmentEntityList +
                '}';
    }
}
