package myapp.vehicles;

public class Vehicle {
    private String brand;
    private String model;

    public Vehicle(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    public void display() {
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
    }

    public void start() {
        System.out.println("Vehicle started");
    }

    public void stop() {
        System.out.println("Vehicle stopped");
    }
}
