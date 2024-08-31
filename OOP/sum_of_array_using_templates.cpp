#include <iostream>

template <class T>

T sum(const T arr[], int size) {
  T sum = 0.0;
  for (int i = 0; i < size; i++) {
    sum += arr[i];
  }
  return sum;
}

int main() {
  int intArray[] = {2, 4, 6, 8, 10};
  double doubleArray[] = {1.5, 2.5, 3.5, 4.52, 5.55};


  int intSum = sum<int>(intArray, 5);
  double doubleSum = sum<double>(doubleArray, 5);

  std::cout << "Integer sum " << intSum << std::endl;
  std::cout << "Double sum " << doubleSum << std::endl;
  return 0;
}


