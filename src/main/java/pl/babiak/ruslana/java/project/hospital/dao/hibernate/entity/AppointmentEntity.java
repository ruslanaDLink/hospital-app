package pl.babiak.ruslana.java.project.hospital.dao.hibernate.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name="APPOINTMENT_TEST")
public class AppointmentEntity {
    @Id
    @GeneratedValue
    private Long id;
    private LocalDateTime date;
    @JoinColumn(name="ID")
    private PatientEntity patient;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="ID")
    private DoctorEntity doctor;
    @JoinColumn(name="ID")
    private ServiceEntity service;


    public AppointmentEntity() {
    }

    public AppointmentEntity(PatientEntity patient, DoctorEntity doctor, ServiceEntity service, LocalDateTime date) {
        this.date = date;
        this.patient = patient;
        this.doctor = doctor;
        this.service = service;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public PatientEntity getPatient() {
        return patient;
    }

    public void setPatient(PatientEntity patient) {
        this.patient = patient;
    }

    public DoctorEntity getDoctor() {
        return doctor;
    }

    public void setDoctor(DoctorEntity doctor) {
        this.doctor = doctor;
    }

    public ServiceEntity getService() {
        return service;
    }

    public void setService(ServiceEntity service) {
        this.service = service;
    }

    @Override
    public String toString() {
        return "AppointmentEntity{" +
                "id=" + id +
                ", date=" + date +
                ", patient=" + patient +
                ", doctor=" + doctor +
                ", service=" + service +
                '}';
    }
}
