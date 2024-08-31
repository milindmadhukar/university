package myapp;

import myapp.cars.Car;
import myapp.cars.ElectricCar;
import myapp.vehicles.Engine;

public class MainApp {
  public static void main(String[] args) {
    Engine gasEngine = new Engine("gas");
    Car car = new Car("Toyota", "Camry", gasEngine);
    car.start();
    car.drive();
    car.stop();
    
    Engine electricEngine = new Engine("electric");
    ElectricCar electricCar = new ElectricCar("Tesla", "Model S", electricEngine);
    electricCar.start();
    electricCar.drive();
    electricCar.stop();

  }
}
