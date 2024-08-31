#include <iostream>

float knapsack(int weights[], int profits[], int n, int capacity) {
  int i = 0;
  float total_profit = 0;
  while (capacity > 0 && i < n) {
    if (weights[i] <= capacity) {
      capacity -= weights[i];
      total_profit += profits[i];
    } else {
      total_profit += (float)capacity / weights[i] * profits[i];
      capacity = 0;
    }
    i++;
  }

  return total_profit;
}

int main() {
  int weights[] = {5, 10, 15, 22, 25};
  int profits[] = {30, 40, 45, 77, 90};
  float ratio[] = {0, 0, 0, 0, 0};
  int capacity = 60;

  int n = sizeof(ratio) / sizeof(ratio[0]);

  for (int i = 0; i < n; i++) {
    ratio[i] = (float)profits[i] / weights[i];
  }

  // Sort ratio array and move the indexes in weights and profits array
  // accordingly

  float temp;
  for (int i = 0; i < n; i++) {
    for (int j = i + 1; j < n; j++) {
      if (ratio[i] < ratio[j]) {

        temp = ratio[i];
        ratio[i] = ratio[j];
        ratio[j] = temp;

        temp = weights[i];
        weights[i] = weights[j];
        weights[j] = temp;

        temp = profits[i];
        profits[i] = profits[j];
        profits[j] = temp;
      }
    }
  }

  for (int i = 0; i < n; i++) {
    std::cout << "Weights" << i << " " << weights[i] << std::endl;
  }

  for (int i = 0; i < n; i++) {
    std::cout << "Profits" << i << " " << profits[i] << std::endl;
  }

  float total_profit = knapsack(weights, profits, n, capacity);

  std::cout << "Total profit: " << total_profit << std::endl;

  for (int i = 0; i < n; i++) {
    std::cout << "Item " << i + 1 << ": ";
    if (weights[i] <= capacity) {
      std::cout << "1" << std::endl;
      capacity -= weights[i];
    } else {
      std::cout << (float)capacity / weights[i] << std::endl;
      capacity = 0;
    }
  }

  return 0;
}
