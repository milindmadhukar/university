#include <iostream>

int fractional_knapsack(const int weights[], const int profits[], float *ratios,
                        int size, int capacity) {
  int total_profit = 0;
  int i = 0;
  while (capacity > 0 && i < size) {
    if (weights[i] <= capacity) {
      capacity -= weights[i];
      ratios[i] = 1;
      total_profit += profits[i];
    } else {
      float ratio = capacity * 1.0f / weights[i];
      total_profit += profits[i] * ratio;
      ratios[i] = ratio;
      break;
    }
    i++;
  }

  return total_profit;
}

int main() {
  int weights[] = {5 , 10, 15, 22, 25};
  int profits[] = {30, 40, 45, 77, 90};

  float ratios[] = {0, 0, 0, 0, 0};
  int capacity = 60;
  int size = sizeof(weights) / sizeof(weights[0]);

  for (int i = 0; i < size; i++) {
    for (int j = i + 1; j < size; j++) {
      float profit_per_weight_i = profits[i] * 1.0f / weights[i];
      float profit_per_weight_j = profits[j] * 1.0f / weights[j];
      if (profit_per_weight_i < profit_per_weight_j) {
        int temp = weights[i];
        weights[i] = weights[j];
        weights[j] = temp;

        temp = profits[i];
        profits[i] = profits[j];
        profits[j] = temp;
      }
    }
  }

  int total_profit =
      fractional_knapsack(weights, profits, ratios, size, capacity);

  std::cout << "Total profit is: " << total_profit << std::endl;

  std::cout << "Ratios of selection are: ";

  for (int i = 0; i < size; i++)
    std::cout << ratios[i] << ", ";

  std::cout << std::endl;

  return 0;
}
