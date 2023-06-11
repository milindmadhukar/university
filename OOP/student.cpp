#include <iostream>
#include <ostream>
#include <string>


class Student {
private:
  std::string name;
  int roll;
public:
  Student(std::string name, int roll) {
    this -> name = name;
    this -> roll = roll;
  }
  void display() {
    std::cout << "Name is: " << name << std::endl;
    std::cout << "Roll is: " << roll << std::endl;
  }
};

int main() { 
  Student s1 = Student("John", 2);
  s1.display();
  return 0;
}
