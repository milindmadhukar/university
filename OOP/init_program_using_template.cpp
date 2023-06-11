#include <iostream>

template <class T1, class T2> T1 init(T1 num1, T1 num2, T2 &start) {
  start = static_cast<T2>(1);
  return num1 + num2;
}

int main() {
  int num1 = 10;
  int num2 = 20;
  double start = 0.0;

  int result = init<int, double>(num1, num2, start);

  std::cout << "start value: " << start << std::endl;
  std::cout << "result: " << result << std::endl;

  return 0;
}
