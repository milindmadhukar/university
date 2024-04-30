#include "iostream"
#include <climits>
#include <cmath>
#include <stack>
#include <vector>

struct Point {
  int x, y;
};

std::stack<Point> hullPoints;

void swap(Point &p1, Point &p2) {
  Point temp = p1;
  p1 = p2;
  p2 = temp;
}

float angleBetweenPoints(Point p1, Point p2) {
  int slope;
  if (p1.x - p2.x == 0) {
    slope = INT_MAX;
  } else {
    slope = (p2.y - p1.y) * 1.0f / (p2.x - p1.x);
  }

  return std::atan(slope);
}

int ccw(Point a, Point b, Point c) {
  float area = (b.x - a.x) * (c.y - a.y) - (b.y - a.y) * (c.x - a.x);
  if (area > 0)
    return 1;
  else if (area < 0)
    return -1;
  else
    return 0;
}

Point pointNextToTop(std::stack<Point> &currentStack) {
  std::cout << currentStack.size() << std::endl;
  Point top = currentStack.top();
  currentStack.pop();

  Point next = currentStack.top();
  currentStack.push(top);

  return next;
}

void GrahamScan(Point *points, int n) {
  int ymin = points[0].y, minIdx = 0;

  for (int i = 1; i < n; i++) {
    int y = points[i].y;

    if ((y < ymin) || (ymin == y && points[i].x < points[minIdx].x))
      ymin = points[i].y, minIdx = i;
  }

  Point minPoint = points[minIdx];
  hullPoints.push(minPoint);

  swap(points[0], minPoint); // Put at start
  points++;                  // Removes the minimum
  n--;

  for (int i = 0; i < n; i++) {
    for (int j = 0; j < n - i - 1; j++) {
      float a1 = angleBetweenPoints(minPoint, points[j]);
      float a2 = angleBetweenPoints(minPoint, points[j + 1]);

      if (a1 > a2) {
        swap(points[j], points[j + 1]);
      }
    }
  }

  hullPoints.push(points[0]);
  points++;
  n--;

  for (int i = 0; i < n; i++) {
    Point a = pointNextToTop(hullPoints);
    Point b = hullPoints.top();
    Point c = points[i];
    if (ccw(a, b, c) == 1) {
      hullPoints.push(c);
    } else {
      hullPoints.pop();
    }
  }

  while (!hullPoints.empty()) {
    Point p = hullPoints.top();
    std::cout << "(" << p.x << ", " << p.y << ")" << std::endl;
    hullPoints.pop();
  }
}

int main() {

  Point points[] = {{0, 3}, {1, 1}, {2, 2}, {4, 4},
                    {0, 0}, {1, 2}, {3, 1}, {3, 3}};

  int n = sizeof(points) / sizeof(points[0]);
  GrahamScan(points, n);
  return 0;
}
