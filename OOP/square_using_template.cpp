#include <iostream>

template <class T>
T square(const T num) {
  return num*num;
}

int main() {

  int i = 10;
  float f = 12.12f;

  std::cout << "Integer square " << square<int>(i) << std::endl;
  std::cout << "Float square " << square<float>(f) << std::endl;
  return 0;
}
