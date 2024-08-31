// 7. Consider creating a program to simulate various vehicle types. In addition to making a
// basic class named Vehicle that has universally applicable properties and methods, you
// also want to make distinct classes for various kinds of vehicles, such as cars and
// airplanes. The distinct traits and procedures that distinguish each vehicle class from other
// sorts of vehicles are their own. Nonetheless, several vehicle types might have things in
// common and work in similar ways. A plane, for instance, also has an altitude, while both
// a car and a plane have a maximum speed and a present speed. you can create a Vehicle
// class that contains general properties and methods, and then create specific vehicle
// classes that inherit from Vehicle as well as from each other. Create a C++ code snippet for
// the above scenario that demonstrates inheritance


#include <iostream>
using namespace std;

// Base class
class Vehicle {
public:
    int maxSpeed;
    int currentSpeed;
    Vehicle(int speed) {
        maxSpeed = speed;
        currentSpeed = 0;
    }

    void accelerate(int speed) {
        if (currentSpeed + speed > maxSpeed) {
            cout << "Cannot exceed maximum speed of " << maxSpeed << endl;
        } else {
            currentSpeed += speed;
            cout << "Accelerating to " << currentSpeed << " mph." << endl;
        }
    }

    void brake() {
        currentSpeed = 0;
        cout << "Vehicle is now stopped." << endl;
    }
};

// Derived class for cars
class Car : public Vehicle {
public:
    int numWheels;
    Car(int speed, int wheels) : Vehicle(speed) {
        numWheels = wheels;
    }

    void drive() {
        cout << "Driving!" << endl;
    }

    void honk() {
        cout << "Honk honk!" << endl;
    }
};

// Derived class for airplanes
class Airplane : public Vehicle {
public:
    int altitude;
    Airplane(int speed) : Vehicle(speed) {
        altitude = 0;
    }

    void fly(int alt) {
        if (alt > 0) {
            altitude = alt;
            cout << "Flying!" << endl;
            cout << "Altitude: " << altitude << " feet." << endl;
        } else {
            cout << "Invalid altitude." << endl;
        }
    }

    void land() {
        altitude = 0;
        cout << "Landing..." << endl;
    }
};

// Derived class for flying cars
class FlyingCar : public Car, public Airplane {
public:
    FlyingCar(int speed, int wheels) : Car(speed, wheels), Airplane(speed) {}

    void fly(int alt) {
        Airplane::fly(alt);
        if (altitude > 0) {
            cout << "Flying car speed: " << currentSpeed << endl;
            cout << "Flying car altitude: " << altitude << endl;
        }
    }
};

int main() {
    // Example usage of FlyingCar
    FlyingCar myCar(150, 4);
    myCar.accelerate(80);
    myCar.fly(1000);
    myCar.brake();
    myCar.land();

    return 0;
}

