#include <iostream>
#include <ostream>
#include <string>

class Student {
private:
  std::string name;
  int roll;
  long phone;
  std::string addr;

public:
  Student(std::string name, int roll, long phone, std::string addr) {
    this->name = name;
    this->roll = roll;
    this->phone = phone;
    this->addr = addr;
  }
  void display() {
    std::cout << "Name is: " << name << std::endl;
    std::cout << "Roll is: " << roll << std::endl;
    std::cout << "Phone is: " << phone << std::endl;
    std::cout << "Address is: " << addr << std::endl;
  }
};

int main() {
  Student s1 = Student("Sam", 2, 1234567890, "Ghar");
  Student s2 = Student("John", 2, 9087654321, "Houzeeee");
  s1.display();
  s2.display();
  return 0;
}
