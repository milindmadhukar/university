// Create the C++ Function Template named multiples so that it has
// three parameters sum, x, and n. The first two parameters will have
// the type represented by the function template type parameter. n will
// always be int. The return type is void. All parameters are
// passed by value except for sum which is passed by reference. A
// Template Function created from multiples will compute...
// sum = 1 + x + 2x + 3x + ... + nx

#include <iostream>

template <class T> void multiplies(T &sum, T x, int n) {
  sum = 1;
  for (int i = 1; i <= n; i++) {
    sum += x * i;
  }
}

int main() {
  
  int sum = 0;

  multiplies<int>(sum, 2, 5);

  std::cout << "The sum is: " << sum << std::endl;

  return 0;
}
