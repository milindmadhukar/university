#include <cmath>
#include <iostream>
#include <math.h>

using std::endl;

class Rectangle {

private:
  int length, breadth, side3;

public:
  Rectangle(int side1, int side2, int side3) {
    this->length = side1;
    this->breadth = side2;
    this->side3 = side3;
  }

  void area() {
    float s = (length + breadth + side3) / 2.0;
    float area = std::sqrt(s * (s - length) * (s - breadth) * (s - side3));
    std::cout << "Area is " << area << endl;
  }

  void perimeter() {
    int perm = length + breadth + side3;
    std::cout << "Perimeter is " << perm << endl;
  }
};

int main() {
  Rectangle t = Rectangle(3, 4, 5);
  t.area();
  t.perimeter();
  return 0;
}
