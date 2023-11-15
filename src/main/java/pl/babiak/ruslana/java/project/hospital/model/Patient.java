package pl.babiak.ruslana.java.project.hospital.model;


public class Patient {
    private Long id;
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
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", passportNumber='" + passportNumber + '\'' +
                ", address=" + address +
                ", hasInsurance=" + hasInsurance +
                '}';
    }
}
