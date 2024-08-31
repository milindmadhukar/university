// CPP program to check if two line segments intersect

#include <iostream>
using namespace std;

struct Point {
  int x, y;
};

float direction(Point p1, Point p2, Point p3);
bool on_segment(Point p1, Point p2, Point p3);

bool does_intersect(Point p1, Point p2, Point p3, Point p4) {
  float d1 = direction(p3, p4, p1);
  float d2 = direction(p3, p4, p2);
  float d3 = direction(p1, p2, p3);
  float d4 = direction(p1, p2, p4);

  if (((d1 > 0 && d2 < 0) || (d1 < 0 && d2 > 0)) &&
      ((d3 > 0 && d4 < 0) || (d3 < 0 && d4 > 0))) {
    return true;
  } else if (d1 == 0 && on_segment(p3, p4, p1)) {
    return true;
  } else if (d2 == 0 && on_segment(p3, p4, p2)) {
    return true;
  } else if (d3 == 0 && on_segment(p1, p2, p3)) {
    return true;
  } else if (d4 == 0 && on_segment(p1, p2, p4)) {
    return true;
  }
  return false;
}

float direction(Point p1, Point p2, Point p3) {
  // p3 - p1 * p2 - p1
  // cross product of the vectors p1p3 and p1p2
  return (p3.x - p1.x) * (p2.y - p1.y) - (p2.x - p1.x) * (p3.y - p1.y);
}

bool on_segment(Point p1, Point p2, Point p3) {
  cout << "On Segment\n"
       << p1.x << " " << p1.y << " " << p2.x << " " << p2.y << " " << p3.x
       << " " << p3.y << endl;

  if (p3.x >= min(p1.x, p2.x) && p3.x <= max(p1.x, p2.x) &&
      p3.y >= min(p1.y, p2.y) && p3.y <= max(p1.y, p2.y)) {
    return true;
  }
  return false;
}

int main() {
  Point p1 = {2, 1}, p2 = {6, 5}, p3 = {5, 4}, p4 = {7, 3};
  if (does_intersect(p1, p2, p3, p4)) {
    cout << "Yes\n";
  } else {
    cout << "No\n";
  }

  return 0;
}
