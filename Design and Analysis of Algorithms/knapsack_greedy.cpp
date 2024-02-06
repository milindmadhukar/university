#include <iostream>

float knapsack(int weights[], int profits[], int size, int capacity) {
  int i = 0;
  float total_profit = 0;
  while (capacity > 0 && i < size) {
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
  int n = 5;
  int weights[] = {5, 10, 15, 22, 25};
  int profits[] = {30, 40, 45, 77, 90};
  float ratio[] = {0, 0, 0, 0, 0};
  int capacity = 60;

  int size = sizeof(ratio) / sizeof(ratio[0]);

  for (int i = 0; i < size; i++) {
    ratio[i] = (float)profits[i] / weights[i];
  }

  // Sort ratio array and move the indexes in weights and profits array
  // accordingly

  for (int i = 0; i < size; i++) {
    float temp;
    for (int j = i + 1; j < size; j++) {
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

  float total_profit = knapsack(weights, profits, size, capacity);

  std::cout << "Total profit: " << total_profit << std::endl;

  return 0;
}
