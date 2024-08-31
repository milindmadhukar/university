// Convert int to string
#include <algorithm>
#include <cmath>
#include <iostream>
#include <ostream>
#include <string>

std::string to_string(int n) {
  std::string s;

  while (n > 0) {
    s += (n % 10) + '0';
    n /= 10;
  }

  std::reverse(s.begin(), s.end());
  return s;
}

long karatsuba(int num1, int num2) {

  // std ::cout << "Current call is: " << num1 << ", " << num2 << std::endl;

  int n = std::max(to_string(num1).length(), to_string(num2).length());

  if (num1 <= 10 || num2  <= 10) {
    return num1 * num2;
  }


  int nby2 = n / 2;

  int a = num1 / pow(10, nby2);
  int b = num1 % (int)pow(10, nby2);

  // std ::cout << "(a, b): " << a << ", " << b << std::endl;

  int c = num2 / pow(10, nby2);
  int d = num2 % (int)pow(10, nby2);

  // std ::cout << "(c, d): " << c << ", " << d << std::endl;

  long X = karatsuba(a, c);
  long Y = karatsuba(b, d);
  long Z = karatsuba(a + b, c + d) - X - Y;

  long res = X * pow(10, 2 * nby2) + Z * pow(10, nby2) + Y;

  return res;
}

int main() {

  int num1 = 14613;
  int num2 = 35210;

  std :: cout << num1 << " * " << num2 << " = ";

  std::cout <<  karatsuba(num1, num2) << std::endl;

  return 0;
}
