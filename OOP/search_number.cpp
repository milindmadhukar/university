#include <iostream>

template <class T>

int searchNumber(const T arr[], int size, const T &number) {
  for (int i = 0; i < size; i++) {
    if (arr[i] == number) {
      return i; // Found at index i
    }
  }
  return -1; // Not found
}

int main() {
  int intArray[] = {2, 4, 6, 8, 10};
  double doubleArray[] = {1.5, 2.5, 3.5, 4.5, 5.5};

  int intNumber = 8;
  double doubleNumber = 3.5;

  int intIndex = searchNumber<int>(intArray, 5, intNumber);
  int doubleIndex = searchNumber<double>(doubleArray, 5, doubleNumber);

  std::cout << "Integer number " << intNumber << " found at index " << intIndex
            << std::endl;
  std::cout << "Double number " << doubleNumber << " found at index "
            << doubleIndex << std::endl;
  return 0;
}

