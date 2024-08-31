#include <iostream>
#define pi 3.1415

using namespace std;

class Shape {
public:
  static float volume(int side) {
    float volume = side * side * side;
    return volume;
  }
  static float volume(int radius, int height) {
    float volume = pi * radius * radius * height;
    return volume;
  }
  static float volume(int lenght, int breadth, int height) {
    float volume = lenght * breadth * height;
    return volume;
  }
};

int main() {
  cout << "The volume of cube is: "  << Shape::volume(10) << endl;
  cout << "The volume of cylinder is: "  << Shape::volume(10, 5) << endl;
  cout << "The volume of cuboid is: "  << Shape::volume(2, 4, 5) << endl;
}
