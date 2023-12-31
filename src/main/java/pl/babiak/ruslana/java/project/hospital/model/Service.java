package pl.babiak.ruslana.java.project.hospital.model;

public class Service {
    private Long id;
    private String service;
    private double price;

    public Service(String service, double price) {
        this.service = service;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Service{" +
                "service='" + service + '\'' +
                ", price=" + price + " zl" +
                '}';
    }
}
