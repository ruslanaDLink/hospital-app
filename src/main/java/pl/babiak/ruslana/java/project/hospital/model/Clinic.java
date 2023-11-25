package pl.babiak.ruslana.java.project.hospital.model;

import java.util.ArrayList;
import java.util.List;

public class Clinic {
    private Long id;
    private String name;
    private Address address;
    private List<Appointment> appointmentList;
    private List<Patient> patientList;
    private List<Doctor> doctorsList;
    private List<Service> serviceList;


    public Clinic(Address address, String name) {
        this.address = address;
        this.name = name;
        appointmentList = new ArrayList<>();
        patientList = new ArrayList<>();
        doctorsList = new ArrayList<>();
        serviceList = new ArrayList<>();
    }

    public void reserve(Appointment appointment) {
        if (appointment != null) {
            appointmentList.add(appointment);
            System.out.println("Patient " + appointment.getPatient().getName() + " reserved appointment to Dr. " + appointment.getDoctor().getName());
        }
    }

    public Patient register(Patient patient) {
        System.out.println("New patient registered to clinic.");
        return patient;
    }

    public double givePaymentCheck(Appointment appointment) {
        System.out.print("Payment Check: ");
        if (appointment.getPatient().isHasInsurance()) {
            return 0.0;
        }
        return appointment.getService().getPrice();
    }

    public void removeAppointmentFromList(Appointment appointment) {
        appointmentList.remove(appointment);
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Appointment> getAppointmentList() {
        return appointmentList;
    }

    public List<Patient> getPatientList() {
        return patientList;
    }

    public List<Doctor> getDoctorsList() {
        return doctorsList;
    }

    public List<Service> getServiceList() {
        return serviceList;
    }

    @Override
    public String toString() {
        return "Clinic{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address +
                ", appointmentList=" + appointmentList +
                '}';
    }
}
