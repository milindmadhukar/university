#include <cmath>
#include <iostream>
#include <math.h>

using std::endl;

class Rectangle {

private:
  int length, breadth;

public:
  Rectangle(int length, int breadth) {
    this->length = length;
    this->breadth = breadth;
  }

  void area() {
    int area = length * breadth;
    std::cout << "Area is " << area << endl;
  }

  void perimeter() {
    int perm = 2 * (length + breadth);
    std::cout << "Perimeter is " << perm << endl;
  }
};

int main() {
  Rectangle r1 = Rectangle(4, 5);
  r1.area();
  r1.perimeter();

  Rectangle r2 = Rectangle(5, 8);
  r2.area();
  r2.perimeter();
  return 0;
}
