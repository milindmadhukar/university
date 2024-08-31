// You are working on a project that involves calculating the product of
// elements in a given container. However, the container can hold elements of
// different types. Write a function template that can compute the product of
// elements in any container. The function should return the product as the same
// type as the elements in the container. Write the function template compute
// product and test it with the following test cases:

#include <iostream>
#include <iterator>
#include <vector>

template <typename Container>
typename Container::value_type calculate_product(const Container& container) {
    typename Container::value_type product = 1;
    for (const auto& element : container) {
        product *= element;
    }
    return product;
}

int main() {
  std::vector<int> v1{1, 2, 3, 4, 5};
  std::vector<double> l1{1.1, 2.2, 3.3, 4.4, 5.5};
  std::vector<long> a1{1L, 2L, 3L, 4L, 5L};

  std::cout << "Product of elements in v1: " << calculate_product(v1) << std::endl;
  std::cout << "Product of elements in l1: " << calculate_product(l1) << std::endl;
  std::cout << "Product of elements in a1: " << calculate_product(a1) << std::endl;

  return 0;
}
