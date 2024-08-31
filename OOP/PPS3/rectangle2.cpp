// 5. Create a class called "Rectangle" that has private attributes "length" and "width" and public
// methods "getArea" and "getPerimeter" that return the area and perimeter of the rectangle.
// Write a program that creates an object of the class and tests the methods. 

#include <iostream>
using namespace std;

class Rectangle {
    private:
        double length;
        double width;

    public:
        Rectangle(double l, double w) {
            if(l < 0 || w < 0) {
                cout << "Invalid." << endl;
                exit(0);
            }
            length = l;
            width = w;
        }

        double getArea() {
            return length * width;
        }

        double getPerimeter() {
            return 2 * (length + width);
        }
};

int main() {
    Rectangle r1(4, 5);
    cout << r1.getArea() << endl;        // Output: 20
    cout << r1.getPerimeter() << endl;   // Output: 18

    Rectangle r2(5, 10);
    cout << r2.getArea() << endl;        // Output: 50
    cout << r2.getPerimeter() << endl;   // Output: 30

    Rectangle r3(-5, -10);              // Output: Invalid.
    return 0;
}

