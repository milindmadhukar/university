#include <climits>
#include <cmath>
#include <iostream>

#define pi 3.14159265358979323846

struct Point {
  int x, y;
};

float angleBetweenPoints(Point p1, Point p2) {
  int slope;
  if (p1.x - p2.x == 0) {
    slope = INT_MAX;
  } else {
    slope = (p2.y - p1.y) * 1.0f / (p2.x - p1.x);
  }

  int angle = std::atan(slope) * 180 / pi;
  if (angle < 0)
    angle += 180;
  return angle;
}

int main() {
  Point p1 = {3, 1};
  Point p2 = {2, 2};
  std::cout << "lmao " << angleBetweenPoints(p1, p2);
}

