// Write a Program to read an odd number N. and overload the Prefix ++ increment
// operator and Prefix -- decrement operator. [Module 7, Easy] Note: Let us
// assume that N=11 then ++N should print N=13 and --N should print N=9 #include
// <iostream>

#include <iostream>

class Number {
private:
  int value;

public:
  Number(int n) : value(n) {}

  void display() { std::cout << "N=" << value << std::endl; }

  Number operator++() {
    value += 2;
    return *this;
  }

  Number operator--() {
    if (value <= 1) {
      std::cout << "Negative value" << std::endl;
      return *this;
    }
    value -= 2;
    return *this;
  }
};

int main() {
  int input;
  std::cout << "Enter an odd number: ";
  std::cin >> input;

  if (input % 2 == 0) {
    std::cout << "Invalid input! The number should be odd." << std::endl;
    return 0;
  }

  Number n(input);

  std::string choice;
  std::cout << "Enter '++' to increment or '--' to decrement: ";
  std::cin >> choice;

  if (choice.compare("++") == 0) {
    ++n;
  } else if (choice.compare("--") == 0) {
    --n;
  } else {
    std::cout << "Invalid choice! Only '++' and '--' are allowed." << std::endl;
    return 0;
  }

  n.display();

  return 0;
}
