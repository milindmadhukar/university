// • Write a program to print the volume of a box by creating a class named
// 'Volume' with an initialization list to initialize its length, breadth and
// height. (just to make you familiar with initialization lists)

#include <iostream>
using namespace std;

class Volume {
private:
  float length, breadth, height;

public:
  Volume(float l, float b, float h) : length(l), breadth(b), height(h) {}

  float calculate_volume() { return length * breadth * height; }
};

int main() {
  Volume box(10.0, 20.0, 30.0);
  cout << "The volume of the box is: " << box.calculate_volume() << endl;
  return 0;
}
