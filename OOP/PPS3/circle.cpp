
#include <iostream>

inline double areaOfCircle(double radius) {
  if (radius < 0) {
    std::cout << "Invalid." << std::endl;
    exit(0);
  }
  return 3.1415 * radius * radius;
}

int main() {
  double radius1 = 5;
  std::cout << "Radius = " << radius1 << ", Area = " << areaOfCircle(radius1)
       << std::endl; // Output: Radius = 5, Area = 78.5398

  double radius2 = 10;
  std::cout << "Radius = " << radius2 << ", Area = " << areaOfCircle(radius2)
       << std::endl; // Output: Radius = 10, Area = 314.159

  double radius3 = 2.5;
  std::cout << "Radius = " << radius3 << ", Area = " << areaOfCircle(radius3)
       << std::endl; // Output: Radius = 2.5, Area = 19.6349

  double radius4 = -9.5;
  std::cout << "Radius = " << radius4 << ", Area = " << areaOfCircle(radius4)
       << std::endl; // Output: Invalid.
  return 0;
}
