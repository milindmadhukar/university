#include <iostream>

template <class T> class Complex {
private:
  T real;
  T imaginary;

public:
  Complex(T r, T i) : real(r), imaginary(i) {}

  T get_real() const { return real; }

  T get_im() const { return imaginary; }
};

int main() {
  double x = 500, y = 100;
  // Uncomment the line below to initialize the object
  Complex<double> comp(x, y);

  std::cout << "The complex number is: " << x << " + " << y << "i" << std::endl;
  std::cout << "Real part of the complex number is: " << comp.get_real()
            << std::endl;
  std::cout << "Imaginary part of the complex number is: " << comp.get_im()
            << std::endl;

  return 0;
}

