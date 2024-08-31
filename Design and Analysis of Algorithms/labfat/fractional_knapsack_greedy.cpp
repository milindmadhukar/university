#include <cstdlib>
#include <iostream>
#include <sstream>
#include <string>

int main() {
  int n = 5;

  int weights[] = {5, 10, 15, 22, 25};
  int profits[] = {30, 40, 45, 77, 90};
  int capacity = 60;

  float ratios[] = {0, 0, 0, 0, 0};

  for (int i = 0; i < n; i++) {
    std::cout << "profit per weight" << i << ": "
              << profits[i] * 1.0f / weights[i] << std::endl;
  }

  // Sort on basis of profit per weight using bubble
  for (int i = 0; i < n - 1; i++) {
    for (int j = 0; j < n - i - 1; j++) {
      if (profits[j] * 1.0f / weights[j] <
          profits[j + 1] * 1.0f / weights[j + 1]) {
        std::swap(profits[j], profits[j + 1]);
        std::swap(weights[j], weights[j + 1]);
      }
    }
  }

  for (int i = 0; i < n; i++) {
    std::cout << "Weights" << i << " " << weights[i] << std::endl;
  }

  for (int i = 0; i < n; i++) {
    std::cout << "Profits" << i << " " << profits[i] << std::endl;
  }

  int i = 0;
  float total_profit = 0;
  int remaining_capacity = capacity;

  while (remaining_capacity > 0 && i < n) {
    if (weights[i] <= remaining_capacity) {
      ratios[i] = 1;
      remaining_capacity -= weights[i];
      total_profit += profits[i];
    } else {
      float ratio = remaining_capacity * 1.0f / weights[i];
      ratios[i] = ratio;
      total_profit += profits[i] * ratio;
      break;
    }
    i++;
  }

  std::cout << "Total profit is: " << total_profit << std::endl;

  for (int i = 0; i < n; i++) {
    std::cout << "Ratio " << i << " " << ratios[i] << std::endl;
  }

  return 0;
}
