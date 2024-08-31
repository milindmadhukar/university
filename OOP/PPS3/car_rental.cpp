#include <iostream>
#include <string>
using namespace std;

class Car {
public:
  string make;
  string model;
  int year;
  double rentalPrice;
  Car(string make, string model, int year, double rentalPrice) {
    this->make = make;
    this->model = model;
    this->year = year;
    this->rentalPrice = rentalPrice;
  }
  double getRentalPrice() { return rentalPrice; }
  void setRentalPrice(double price) { rentalPrice = price; }
};

int main() {
  Car car1("Maruti", "Swift", 2022, 15000);

  cout << "Make: " << car1.make << endl;
  cout << "Model: " << car1.model << endl;
  cout << "Year: " << car1.year << endl;
  cout << "Rental Price: " << car1.getRentalPrice() << endl;

  return 0;
}
