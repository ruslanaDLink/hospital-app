package pl.babiak.ruslana.java.project.hospital.model;

import java.time.LocalDateTime;

public class Appointment {
    private LocalDateTime date;
    private Patient patient;
    private Doctor doctor;
    private Service service;

    public Appointment(Patient patient, Doctor doctor, Service service, LocalDateTime date) {
        this.date = date;
        this.patient = patient;
        this.doctor = doctor;
        this.service = service;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "date=" + date +
                ", patient=" + patient +
                ", doctor=" + doctor +
                ", service=" + service +
                '}';
    }
}
