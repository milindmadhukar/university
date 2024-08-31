#include <iostream>
#include <type_traits>
#include <vector>

template <typename Container>
typename std::enable_if<std::is_arithmetic<typename Container::value_type>::value,
    typename Container::value_type>::type
findMax(const Container& container) {
    typename Container::value_type maxElement = container[0];
    for (const auto& element : container) {
        if (element > maxElement) {
            maxElement = element;
        }
    }
    return maxElement;
}

template <typename Container>
typename std::enable_if<!std::is_arithmetic<typename Container::value_type>::value,
    typename Container::value_type>::type
findMax(const Container& container) {
    typename Container::value_type maxElement = container[0];
    for (const auto& element : container) {
        if (element > maxElement) {
            maxElement = element;
        }
    }
    return maxElement;
}

int main() {
    std::vector<int> v1 = {1, 3, 5, 7, 9};
    std::vector<double> l1 = {1.1, 2.2, 3.3, 4.4, 5.5};
    std::vector<long> a1 = {1000000L, 2000000L, 3000000L, 4000000L, 5000000L};

    std::cout << "Max element in v1: " << findMax(v1) << std::endl;
    std::cout << "Max element in l1: " << findMax(l1) << std::endl;
    std::cout << "Max element in a1: " << findMax(a1) << std::endl;

    return 0;
}
