#include <iostream>

template <class T> T add(const T &n1, const T &n2) { return n1 + n2; }

template <class T>
T subtract(const T &n1, const T &n2) {
  return n1 - n2;
}

template <class T>
T multiply(const T &n1, const T &n2) {
  return n1 * n2;
}

template <class T>
T divide(const T &n1, const T &n2) {
  return n1 / n2;
}

int main() {

  int i1, i2;
  float f1, f2;
  std::cout << "Enter ints: ";
  std::cin >> i1 >> i2;

  std::cout << "Numbers are " << i1 << " and " << i2 << std::endl;
  std::cout << "Addition: " << add<int>(i1, i2) << std::endl;
  std::cout << "Subtraction: " << subtract<int>(i1, i2) << std::endl;
  std::cout << "Multiplication: " << multiply<int>(i1, i2) << std::endl;
  std::cout << "Division: " << divide<int>(i1, i2) << std::endl;


  std::cout << "Enter floats: ";
  std::cin >> f1 >> f2;

  std::cout << "Numbers are " << f1 << " and " << f2 << std::endl;
  std::cout << "Addition: " << add<float>(f1, f2) << std::endl;
  std::cout << "Subtraction: " << subtract<float>(f1, f2) << std::endl;
  std::cout << "Multiplication: " << multiply<float>(f1, f2) << std::endl;
  std::cout << "Division: " << divide<float>(f1, f2) << std::endl;

  return 0;
}

