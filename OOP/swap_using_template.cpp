#include <iostream>

template <class T>

void swap(T &n1, T &n2) {
  T temp;
  temp = n1;
  n1 = n2;
  n2 = temp;
}

int main() {

  int i1 = 10;
  int i2 = 20;
  
  float f1 = 10.2f;
  float f2 = 20.4f;

  swap<int>(i1, i2);
  swap<float>(f1, f2);

  std::cout << "I1 is " << i1 << std::endl;
  std::cout << "I2 is " << i2 << std::endl;
  std::cout << "F1 is " << f1 << std::endl;
  std::cout << "F2 is " << f2 << std::endl;
  
  return 0;
}

