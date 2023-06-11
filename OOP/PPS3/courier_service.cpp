// 2. Create a parent class named ‘Courier’ with the following:
// 1. Data members CourierID, Name_of_Courier.
// 2. Method named PrintBill() to accept the Base_fare of type double as parameter
// and display the CourierID, Name_of_Courier , and Shipping_Cost, where
// Shipping_Cost = Base_fare + 30.
// • Create a subclass names ‘Internatial_services’ which inherits from the Courier
// class. The class include the following:
// 1. Data members Destination, Weight.
// 2. Method named FinalBill()to print the CourierID, Name_of_Courier, Destination,
// Weight and Total_ ShippingCost, where Total_ShippingCost = Base_fare *
// Weight. Print the message “More Sale” when Total_ShippingCost is more than
// 100, otherwise print the message “Less Sale”. 

#include <iostream>

class Courier {
public:
  int CourierID;
  std::string Name_of_Courier;

  void PrintBill(double Base_fare) {
    std::cout << "CourierID: " << CourierID << std::endl;
    std::cout << "Name_of_Courier: " << Name_of_Courier << std::endl;
    double Shipping_Cost = Base_fare + 30;
    std::cout << "The Shipping cost is: " << Shipping_Cost << std::endl;
  }
};

class International_services : public Courier {
public:
  std::string Destination;
  double Weight;

  void FinalBill(double Base_fare) {
    double Total_ShippingCost = Base_fare * Weight;
    std::cout << "CourierID: " << CourierID << std::endl;
    std::cout << "Name_of_Courier: " << Name_of_Courier << std::endl;
    std::cout << "Destination: " << Destination << std::endl;
    std::cout << "Weight: " << Weight << "KG" << std::endl;
    std::cout << "Total Shipping Cost=" << Total_ShippingCost << std::endl;
    if (Total_ShippingCost > 100) {
      std::cout << "More Sale" << std::endl;
    } else {
      std::cout << "Less Sale" << std::endl;
    }
  }
};

int main() {
  International_services s;
  std::cout << "Enter the Courier ID:";
  std::cin >> s.CourierID;
  std::cout << "Enter the Name of the Courier:";
  std::cin >> s.Name_of_Courier;
  std::cout << "Enter the Base Fare:";
  double Base_fare;
  std::cin >> Base_fare;
  s.PrintBill(Base_fare);
  std::cout << "Enter the Destination:";
  std::cin >> s.Destination;
  std::cout << "Enter the Weight in KG:";
  std::cin >> s.Weight;
  s.FinalBill(Base_fare);
  return 0;
}
