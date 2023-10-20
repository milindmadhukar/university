package myapp.cars;

import myapp.cars.Car;
import myapp.vehicles.Engine;;

public class ElectricCar extends Car {
  public ElectricCar(String brand, String model, myapp.vehicles.Engine engine) {
    super(brand, model, engine);
  }

  @Override
  public void start() {
    System.out.println("Starting an electric car.");
  }
}
