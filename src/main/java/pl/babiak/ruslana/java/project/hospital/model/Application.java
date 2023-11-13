package pl.babiak.ruslana.java.project.hospital.model;

import java.time.LocalDateTime;

public class Application {
    private static final String clinicName = "Przychodnia Lekarska NFZ. Centrum Medyczne Sadyba. Poradnia POZ";

    public static void main(String[] args) {

        Address clinicAddress = Address.builder()
                .country("Poland")
                .city("Warsaw")
                .voivodeship("Masovian")
                .postCode("02-943")
                .street("Urle 1")
                .build();
        Clinic warsawClinicOnUrleStreet = new Clinic(clinicAddress, clinicName);
        Doctor johnCardiologist = new Doctor("John Peterson", DoctorType.CARDIOLOGIST);
       UniqueId generatorId = new UniqueId();
        Address dariaAddress = Address.builder()
                .country("Poland")
                .voivodeship("Masovian")
                .city("Warsaw)")
                .postCode("00-082")
                .street("Mickiewicza 34")
                .flatNumber("12").build();

        Patient daria = new Patient("Daria Nowak", 24, "FA6742", dariaAddress, false);
        Patient dariaRegistration = warsawClinicOnUrleStreet.register(daria);
        System.out.println(dariaRegistration);

        LocalDateTime dariaNowakAppointmentDate = LocalDateTime.of(2023, 10, 12, 9, 0);
        Service cardiologistService = new Service("Check patient and give treatment", 200);
        Appointment dariaAppointment = new Appointment(daria, johnCardiologist, cardiologistService, dariaNowakAppointmentDate);
        warsawClinicOnUrleStreet.reserve(dariaAppointment);
        double checkSumForDaria = warsawClinicOnUrleStreet.givePaymentCheck(dariaAppointment);
        System.out.println(checkSumForDaria);
    }
}
