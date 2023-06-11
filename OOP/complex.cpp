// Print the sum, difference and product of two complex numbers by creating a
// class named 'Complex' with separate functions for each operation whose real
// and imaginary parts are entered by the user.
//
#include <iostream>

class Complex {
public:
  int real, cmplx;

  Complex(int real, int cmplx) {
    this->real = real;
    this->cmplx = cmplx;
  }

  void display() {
    std::cout << "Complex Number is: " << real << " + " << cmplx << "j"
              << std::endl;
  }
};

Complex sum(Complex c1, Complex c2) {
  Complex res = Complex(c1.real + c2.real, c1.cmplx + c2.cmplx);
  return res;
}

Complex diff(Complex c1, Complex c2) {
  Complex res = Complex(c1.real - c2.real, c1.cmplx - c2.cmplx);
  return res;
}

Complex product(Complex c1, Complex c2) {
  int real = (c1.real * c2.real) - (c1.cmplx * c2.cmplx);
  int cmplx = (c1.real * c2.cmplx) + (c2.real * c1.cmplx);
  Complex res = Complex(real, cmplx);
  return res;
}

int main() {
  Complex c1 = Complex(5, 7);
  Complex c2 = Complex(6, 2);
  Complex res1 = sum(c1, c2);
  res1.display();

  Complex res2 = diff(c1, c2);
  res2.display();

  Complex res3 = product(c1, c2);
  res3.display();

  return 0;
}
