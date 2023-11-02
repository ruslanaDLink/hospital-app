package pl.babiak.ruslana.java.project.hospital.model;

import java.util.ArrayList;
import java.util.List;

public class Clinic {
    private Address address;
    private List<Appointment> appointmentList;

    public Clinic(Address address) {
        this.address = address;
        appointmentList = new ArrayList<>();
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
        if(appointment.getPatient().isHasInsurance()){
            return 0.0;
        }
        return appointment.getService().getPrice();
    }

    public void removeAppointmentFromList(Appointment appointment) {
        appointmentList.remove(appointment);
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
