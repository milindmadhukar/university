// • Write a program to print the area of a rectangle by creating a class named
// 'Area' having two functions. First function named as 'setDim' takes the
// length and breadth of the rectangle as parameters and the second function
// named as 'getArea' returns the area of the rectangle. Length and breadth of
// the rectangle are entered through keyboard.

#include <iostream>

class Area {
private:
  int length, breadth;

public:
  void setDim(int l, int b) {
    length = l;
    breadth = b;
  }

  int returnArea() { return length * breadth; }
};

int main() {
  Area a;
  int l, b;
  std::cin >> l >> b;
  a.setDim(l, b);
  std::cout << "Area is: " << a.returnArea() << std::endl;
  return 0;
}
