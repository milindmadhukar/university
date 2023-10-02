// 1. Design a simple vehicle management system for a transportation company. The system needs to handle different types of vehicles, including cars and bicycles and should demonstrate the use of polymorphism, abstract classes, multilevel inheritance, constructor overloading, and method overriding.
//
// Problem Statement:
//
// 1. Create an abstract class called "Vehicle" with the following properties and methods:
//
//    - Properties:
//
//      - String "vehicleType" (to store the type of vehicle)
//
//      - String "model" (to store the model of the vehicle)
//
//      - int "year" (to store the manufacturing year of the vehicle)
//
//    - Abstract Method:
//
//      - void start() (to be overridden by derived classes)
//
// 2. Create two concrete classes that inherit from the "Vehicle" class: "Car" and "Bicycle." Implement the "start" method for each class as follows:
//
//    - For the "Car" class, the "start" method should print "Starting the car engine."
//
//    - For the "Bicycle" class, the "start" method should print "Pedaling the bicycle."
//
// 3. Implement constructor overloading in both the "Car" and "Bicycle" classes:
//
//    - For the "Car" class, create two constructors:
//
//      - One that takes parameters for "model" and "year."
//
//      - Another that takes parameters for "model," "year," and "fuelType" (a string to store the type of fuel the car uses).
//
//    - For the "Bicycle" class, create two constructors:
//
//      - One that takes parameters for "model" and "year."
//
//      - Another that takes parameters for "model" and "year," along with an additional parameter for "gearCount" (an integer representing the number of gears on the bicycle).
//
// 4. Create instances of both the "Car" and "Bicycle" classes, demonstrating the use of the different constructors.
//
// 5. Demonstrate polymorphism by creating an array of "Vehicle" objects and initialize it with instances of both "Car" and "Bicycle." Then, iterate through the array and call the "start" method for each vehicle.
//
// Note: Create an instance for the abstract base class using the dynamic method instance
abstract class Vehicle {
  String vehicleType;
  String model;
  int year;

  abstract void start();
}

class Car extends Vehicle {
  String fuelType;

  Car(String model, int year) {
    this.model = model;
    this.year = year;
  }

  Car(String model, int year, String fuelType) {
    this.model = model;
    this.year = year;
    this.fuelType = fuelType;
  }

  void start() {
    System.out.println("Starting the car engine.");
  }

  @Override
  public String toString() {
    return "Car Detials:\nModel: " + this.model + "\nYear: " + this.year + "\nFuel Type: " + this.fuelType;
  }
}

class Bicycle extends Vehicle {
  int gearCount;

  Bicycle(String model, int year) {
    this.model = model;
    this.year = year;
  }

  Bicycle(String model, int year, int gearCount) {
    this.model = model;
    this.year = year;
    this.gearCount = gearCount;
  }

  void start() {
    System.out.println("Pedaling the bicycle.");
  }
  
  @Override
  public String toString() {
    return "Bicycle Detials:\nModel: " + this.model + "\nYear: " + this.year + "\nGear Count: " + this.gearCount;
  }
}

public class Excercise44 {
  public static void main(String[] args) {
    Car car1 = new Car("Porsche 911", 1963);
    Car car2 = new Car("Nissan GT-R", 2002, "Gasoline");

    Bicycle bicycle1 = new Bicycle("Firefox Road Runner Pro", 2017);
    Bicycle bicycle2 = new Bicycle("Trek 3700", 2015, 21);

    Vehicle[] vehicles = {car1, car2, bicycle1, bicycle2};

    for(Vehicle vehicle : vehicles) {
      System.out.println(vehicle);
      vehicle.start();
      System.out.println();
    }
  }
}
