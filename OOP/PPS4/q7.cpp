
#include <iostream>

class MathSymbol {
public:
    virtual int doOperation(int x, int y) const = 0;
};

class Plus : public MathSymbol {
public:
    int doOperation(int x, int y) const override {
        return x + y;
    }
};

class Minus : public MathSymbol {
public:
    int doOperation(int x, int y) const override {
        return x - y;
    }
};

int main() {
    int x, y;

    std::cout << "Enter the value of x and y: " << std::endl;
    std::cin >> x >> y;

    MathSymbol* plus = new Plus();
    MathSymbol* minus = new Minus();

    int addition = plus->doOperation(x, y);
    int subtraction = minus->doOperation(x, y);

    std::cout << "Addition: " << addition << std::endl;
    std::cout << "Subtraction: " << subtraction << std::endl;

    return 0;
}
