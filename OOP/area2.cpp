// Write a program to print the area of a rectangle by creating a class named
// 'Area' taking the values of its length and breadth as parameters of its
// constructor and having a function named 'returnArea' which returns the area
// of the rectangle. Length and breadth of the rectangle are entered through
// keyboard.

#include <iostream>

class Area {
private:
  int length, breadth;

public:
  Area(int length, int breadth) {
    this->length = length;
    this->breadth = breadth;
  }

  int returnArea() { return length * breadth; }
};

int main() {
  int l, b;
  std::cin >> l >> b;

  Area a(l, b);
  std::cout << "Area is: " << a.returnArea() << std::endl;
  return 0;
}
