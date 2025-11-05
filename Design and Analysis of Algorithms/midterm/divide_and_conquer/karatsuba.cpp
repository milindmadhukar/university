#include <algorithm>
#include <iostream>
#include <ostream>
#include <string>

using namespace std;

string convert_to_string(long long n) {
  if (n == 0)
    return "0";

  string s;

  bool is_neg = n < 0;
  if (is_neg)
    n = -n;

  while (n > 0) {
    s += n % 10 + '0'; // Number + 48 to make it into a char
    n /= 10;
  }

  if (is_neg)
    s += '-';

  reverse(s.begin(), s.end());
  return s;
}

long long integer_power(int exp) {
  long long res = 1;
  for (int i = 0; i < exp; ++i) {
    res *= 10;
  }
  return res;
}

long long karatsuba(long long num1, long long num2) {
  int n =
      max(convert_to_string(num1).length(), convert_to_string(num2).length());

  if (n < 2) {
    return num1 * num2;
  }

  int nby2 = n / 2;

  long long p = integer_power(nby2);
  long long p2 = integer_power(2 * nby2);

  long long a = num1 / p;
  long long b = num1 % p;

  long long c = num2 / p;
  long long d = num2 % p;

  long long X = karatsuba(a, c);
  long long Y = karatsuba(b, d);
  long long Z = karatsuba(a + b, c + d) - X - Y;

  long long res = X * p2 + Z * p + Y;

  return res;
}

int main() {

  // Use long long for main variables
  long long num1 = 14613;
  long long num2 = 35210;

  cout << num1 << " * " << num2 << " = ";
  cout << karatsuba(num1, num2) << endl; // Output: 514523730

  return 0;
}
