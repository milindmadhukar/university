#include <iostream>
using namespace std;

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
  int n, capacity;

  cout << "Enter the number of items: ";
  cin >> n;

  if (n <= 0) {
    cout << "Invalid number of items!" << endl;
    return 1;
  }

  // Dynamically allocate arrays
  int *weights = new int[n];
  int *profits = new int[n];
  float *ratio = new float[n];

  cout << "Enter the capacity of the knapsack: ";
  cin >> capacity;

  cout << "\nEnter weights of " << n << " items: ";
  for (int i = 0; i < n; i++) {
    cin >> weights[i];
  }

  cout << "Enter profits of " << n << " items: ";
  for (int i = 0; i < n; i++) {
    cin >> profits[i];
  }

  // Calculate profit/weight ratio
  for (int i = 0; i < n; i++) {
    ratio[i] = (float)profits[i] / weights[i];
  }

  // Sort by ratio in descending order using bubble sort
  float temp;
  int tempInt;
  for (int i = 0; i < n - 1; i++) {
    for (int j = 0; j < n - i - 1; j++) {
      if (ratio[j] < ratio[j + 1]) {
        // Swap ratios
        temp = ratio[j];
        ratio[j] = ratio[j + 1];
        ratio[j + 1] = temp;

        // Swap weights
        tempInt = weights[j];
        weights[j] = weights[j + 1];
        weights[j + 1] = tempInt;

        // Swap profits
        tempInt = profits[j];
        profits[j] = profits[j + 1];
        profits[j + 1] = tempInt;
      }
    }
  }

  cout << "\nAfter sorting by profit/weight ratio:" << endl;
  for (int i = 0; i < n; i++) {
    cout << "Item " << i + 1 << " - Weight: " << weights[i]
         << ", Profit: " << profits[i] << ", Ratio: " << ratio[i] << endl;
  }

  float total_profit = knapsack(weights, profits, n, capacity);
  cout << "\nTotal profit: " << total_profit << endl;

  cout << "\nItems selected:" << endl;
  int remaining_capacity = capacity;
  for (int i = 0; i < n; i++) {
    cout << "Item " << i + 1 << ": ";
    if (weights[i] <= remaining_capacity) {
      cout << "1 (fully included)" << endl;
      remaining_capacity -= weights[i];
    } else if (remaining_capacity > 0) {
      cout << (float)remaining_capacity / weights[i] << " (fractional)" << endl;
      remaining_capacity = 0;
    } else {
      cout << "0 (not included)" << endl;
    }
  }

  // Clean up
  delete[] weights;
  delete[] profits;
  delete[] ratio;

  return 0;
}
