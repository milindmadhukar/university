
#include <iostream>
#include <vector>

template <typename Container>
typename Container::value_type calulate_sum(const Container &container) {
  typename Container::value_type sum = 0;
  for (const auto &element : container) {
    sum += element;
  }
  return sum;
}

int main() {
  std::vector<int> v1{1, 2, 3, 4, 5};
  std::vector<double> l1{1.1, 2.2, 3.3, 4.4, 5.5};
  std::vector<long> a1{1000000L, 2000000L, 3000000L, 4000000L, 5000000L};

  std::cout << "Sum of elements in v1: " << calulate_sum(v1) << std::endl;
  std::cout << "Sum of elements in l1: " << calulate_sum(l1) << std::endl;
  std::cout << "Sum of elements in a1: " << calulate_sum(a1) << std::endl;

  return 0;
}
