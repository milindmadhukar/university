#include <iostream>

class Point {
private:
    double x;
    double y;
public:
    Point() : x(0.0), y(0.0) {}

    friend std::istream& operator>>(std::istream& is, Point& point);
    friend std::ostream& operator<<(std::ostream& os, const Point& point);
};

std::istream& operator>>(std::istream& is, Point& point) {
    is >> point.x >> point.y;
    return is;
}

std::ostream& operator<<(std::ostream& os, const Point& point) {
    os << "(" << point.x << ", " << point.y << ")";
    return os;
}

int main() {
    Point point1, point2;

    std::cout << "Enter x and y coordinates for first point, separated by a space: ";
    std::cin >> point1;
    std::cout << "Enter x and y coordinates for second point, separated by a space: ";
    std::cin >> point2;

    std::cout << "First point is at " << point1 << std::endl;
    std::cout << "Second point is at " << point2 << std::endl;

    return 0;
}
