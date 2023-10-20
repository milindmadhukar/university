// Within the myapp.cars sub-package, create a Car class that inherits from the Vehicle class. It includes an Engine attribute as a property and introduces a drive method to show the engine type of the vehicle. The start and stop methods are overridden to demonstrate method overriding.

package myapp.cars;

import myapp.vehicles.Vehicle;
import myapp.vehicles.Engine;

public class Car extends Vehicle {
  private myapp.vehicles.Engine engine;

  public Car(String brand, String model, myapp.vehicles.Engine engine) {
    super(brand, model);
    this.engine = engine;
  }

  public void drive() {
    System.out.println("Driving a car with " + engine.getType() + " engine.");
  }

  @Override
  public void start() {
    System.out.println("Starting a car.");
  }

  @Override
  public void stop() {
    System.out.println("Stopping a car.");
  }
}
