#include <iostream>

using namespace std;

class Complex {
private:
  int real, imag;

public:
  Complex(int r = 0, int i = 0) {
    real = r;
    imag = i;
  }

  Complex operator+(Complex const &cmp) {
    Complex res;
    res.real = real + cmp.real;
    res.imag += imag + cmp.imag;
    return res;
  }

  Complex operator-(Complex const &cmp) {
    Complex res;
    res.real = real - cmp.real;
    res.imag += imag - cmp.imag;
    return res;
  }

  void display() {
    cout << "The complex number is " << real << " + " << imag << "j" << endl;
  }
};

int main() {
  Complex c1(10, 5);
  Complex c2(5, 1);

  Complex res = c1 - c2;
  res.display();
}
