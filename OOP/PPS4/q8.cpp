#include <iostream>

class Test {
private:
    int x;
    int y;
    int z;

public:
    Test(int a, int b, int c) : x(a), y(b), z(c) {}

    void display() const {
        std::cout << x << ", " << y << ", " << z << std::endl;
    }

    Test& operator++() {
        ++x;
        ++y;
        ++z;
        return *this;
    }
};

int main() {
    int a, b, c;

    std::cout << "Enter the values of a, b, c: ";
    std::cin >> a >> b >> c;

    Test obj(a, b, c);

    obj.display();
    ++obj;
    obj.display();
    ++obj;
    obj.display();

    return 0;
}
