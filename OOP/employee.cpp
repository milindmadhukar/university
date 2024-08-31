// Write a program that would print the information (name, year of joining,
// salary, address) of three employees by creating a class named 'Employee'. The
// output should be as follows:
//
// Name Year of joining Address
// Robert 1994 64C- WallsStreat
// Sam 2000 68D- WallsStreat
// John 1999 26B- WallsStreat

#include <iostream>
#include <string>

class Employee {
private:
  std::string name, address;
  int year_of_joining, salary;

public:
  Employee(std::string name, int yoj, int salary, std::string address) {
    this->name = name;
    this->year_of_joining = yoj;
    this->salary = salary;
    this->address = address;
  }

public:
  void display() {
    std::cout << name << "\t" << year_of_joining << "\t" << address
              << std::endl;
  }
};

int main() {
  Employee e1 = Employee("Robert", 1994, 10, "64C- WallsStreat");
  Employee e2 = Employee("Sam", 2000, 10, "68D- WallsStreat");
  Employee e3 = Employee("John", 1999, 10, "26B- WallsStreat");
  std::cout << "Name" << "\t" << "Year of joining" << "\t" << "Address" << std::endl;
  e1.display();
  e2.display();
  e3.display();
  return 0;
}
