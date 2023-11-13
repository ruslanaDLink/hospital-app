package pl.babiak.ruslana.java.project.hospital.model;


public class Patient {
    private int clientNumber;
    private String name;
    private int age;
    private String passportNumber;
    private Address address;
    private boolean hasInsurance;

    public Patient() {
    }

    public Patient(String name, int age, String passportNumber, Address address, boolean hasInsurance) {
        this.name = name;
        this.age = age;
        this.passportNumber = passportNumber;
        this.address = address;
        this.hasInsurance = hasInsurance;
    }

    public void cancelAppointment(Clinic clinic, Appointment appointment) {
        clinic.removeAppointmentFromList(appointment);
        System.out.println(getName() + " canceled appointment ");
    }

    public int getClientNumber() {
        return clientNumber;
    }

    public void setClientNumber(int clientNumber) {
        this.clientNumber = clientNumber;
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
        return "Patient{" +
                "name = '" + name + '\'' +
                ", age = " + age +
                ", passport number = '" + passportNumber + '\'' +
                ", address = " + address +
                '}';
    }
}
