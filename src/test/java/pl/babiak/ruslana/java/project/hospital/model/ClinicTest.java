package pl.babiak.ruslana.java.project.hospital.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

class ClinicTest {

    @Test
    void reserveDateInClinic() {
        //given - tworzenie obiektu klasy testowanej
        Address address = Address.builder()
                .country("Poland")
                .city("Warsaw")
                .voivodeship("Masovian")
                .postCode("02-943")
                .street("Urle 1")
                .build();
        UniqueId generatorId = new UniqueId();
        String clinicName = "NFZ";
        Clinic clinic = new Clinic(address, clinicName);
        Patient patient = new Patient("Agata Kowalska", 28, "FA345", address, true);
        Doctor doctor = new Doctor("", DoctorType.ONCOLOGIST);
        Service service = new Service("",0);
        Appointment appointment = new Appointment(patient,doctor,service,LocalDateTime.now());
        //when - wywolanie metody dla klasy testowanej
        clinic.reserve(appointment);

        //then - sprawdzenie wyniku metody testowanej
        Assertions.assertNotNull(appointment, "reserved date is null");
    }

    @Test
    void registerPatientInClinic() {
        //given
        Address address = Address.builder()
                .country("Poland")
                .city("Warsaw")
                .voivodeship("Masovian")
                .postCode("02-943")
                .street("Urle 1")
                .build();
        UniqueId generatorId = new UniqueId();
        String clinicName = "NFZ";
        Clinic clinic = new Clinic(address, clinicName);
        Patient patient = new Patient("Agata Kowalska", 28, "FA345", address, true);

        //when
        Patient registerPatient = clinic.register(patient);

        //then
        Assertions.assertNotNull(registerPatient, "registered patient must not be null");
    }

    @Test
    void givePaymentSumToPatientWithNoInsurance() {
        Address address = Address.builder()
                .country("Poland")
                .city("Warsaw")
                .voivodeship("Masovian")
                .postCode("02-943")
                .street("Urle 1")
                .build();
        String clinicName = "NFZ";
        Clinic clinic = new Clinic(address, clinicName);
        UniqueId generatorId = new UniqueId();

        Patient patient = new Patient("Agata Kowalska", 28, "FA345", address, true);

        Doctor doctor = new Doctor("", DoctorType.ONCOLOGIST);
        Service service = new Service("",200);

        Appointment appointment = new Appointment(patient,doctor,service,LocalDateTime.now());
        double payment = clinic.givePaymentCheck(appointment);
        if (!patient.isHasInsurance()) {
            Assertions.assertEquals(200, payment);
        }
    }

    @Test
    void givePaymentSumToPatientWithInsurance(){
        Address address = new Address(1L,
                "",
                "",
                "",
                "",
                "",
                "");
        String clinicName = "NFZ";

        Clinic clinic = new Clinic(address, clinicName);
        UniqueId generatorId = new UniqueId();
        Patient patient = new Patient("Agata Kowalska", 28, "FA345", address, true);
        Doctor doctor = new Doctor("", DoctorType.ONCOLOGIST);
        Service service = new Service("",0);
        Appointment appointment = new Appointment(patient,doctor,service,LocalDateTime.now());
        double payment = clinic.givePaymentCheck(appointment);
        if (patient.isHasInsurance()) {
            Assertions.assertEquals(0, payment);
        }
    }
}
/*
CREATE TABLE CLINICS(
   ID INT PRIMARY KEY,
   NAME VARCHAR(255),
   ADDRESS_ID INT,
   foreign key (ADDRESS_ID) references ADDRESSES(ID)
);
--public class Clinic{
-- private int id;
-- private String name;
-- private Address address;
--}

CREATE TABLE ADDRESSES(
    ID INT PRIMARY KEY, --ID IDENTITY
    STREET VARCHAR(255)
);
--public class Address{
-- private int id;
-- private String street;
--}

--INSERT INTO CLINICS(ID, NAME, ADDRESS_ID) VALUES (1, 'NFZ', NULL);
--INSERT INTO CLINICS(ID, NAME, ADDRESS_ID) VALUES(2, 'Przychodnia', 3);
--INSERT INTO ADDRESSES(ID, STREET) VALUES (3, 'Leszczynowa');
--INSERT INTO ADDRESSES(ID, STREET) VALUES (4, 'Paderewskiego');
SELECT * FROM CLINICS;
SELECT * FROM ADDRESSES;

SELECT *
FROM CLINICS AS C
JOIN ADDRESSES AS A
ON C.ADDRESS_ID = A.ID;
 */
// TODO: 13/11/2023
// dla powyzszych tabel wykonac polecenia insert pamietajac o kluczu obcym tabeli clinics
// napisac zapytanie join dla powyzszych tabel uwzgledniajac pk i fk
// https://www.w3schools.com/sql/sql_join.asp
// dla tabeli Clinics dodac klucz obcy do tabeli Addresses
// UWAGA! TYLKO W H2 CONSOLE
