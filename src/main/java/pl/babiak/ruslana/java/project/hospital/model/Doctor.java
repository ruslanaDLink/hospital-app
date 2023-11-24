package pl.babiak.ruslana.java.project.hospital.model;

public class Doctor {
    private Long id;
    private String name;
    private DoctorType type;

    public Doctor(String name, DoctorType type) {
        this.name = name;
        this.type = type;
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

    public DoctorType getType() {
        return type;
    }

    public void setType(DoctorType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
