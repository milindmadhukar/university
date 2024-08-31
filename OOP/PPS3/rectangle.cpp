
#include <iostream>
using namespace std;

class Rectangle {
private:
    int length;
    int width;
public:
    Rectangle(int l, int w) {
        length = l;
        width = w;
    }
    void calculateArea() {
        cout << "Area: " << length * width << endl;
    }
};

int main() {
    Rectangle r1(5, 10);
    r1.calculateArea(); // Expected output: 50
    
    Rectangle r2(3, 8);
    r2.calculateArea(); // Expected output: 24
    
    Rectangle r3(6, 2);
    r3.calculateArea(); // Expected output: 12
    
    return 0;
}
