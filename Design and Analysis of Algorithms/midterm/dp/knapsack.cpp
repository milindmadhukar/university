#include <algorithm>
#include <iostream>
using namespace std;

int knapSack(int W, int weights[], int profits[], int n, int **dp) {
  // Initialize dp table to 0
  for (int i = 0; i <= n; i++) {
    for (int w = 0; w <= W; w++) {
      dp[i][w] = 0;
    }
  }

  for (int i = 1; i <= n; i++) {
    for (int w = 1; w <= W; w++) {
      if (weights[i - 1] > w) {
        dp[i][w] = dp[i - 1][w];
      } else {
        dp[i][w] =
            max(profits[i - 1] + dp[i - 1][w - weights[i - 1]], dp[i - 1][w]);
      }
    }
  }
  return dp[n][W];
}

void printSelectedItems(int n, int W, int total_profit, int weights[],
                        int profits[], int **dp) {
  int w = W;
  cout << "\nSelected items:" << endl;
  for (int i = n; i > 0 && total_profit > 0; i--) {
    if (total_profit == dp[i - 1][w]) {
      continue;
    } else {
      cout << "Item " << i << " with weight " << weights[i - 1]
           << " and profit " << profits[i - 1] << " is selected" << endl;
      total_profit -= profits[i - 1];
      w -= weights[i - 1];
    }
  }
}

int main() {
  int n, W;
  cin >> n;

  // Knapscak capacity
  cin >> W;

  int *profits = new int[n];
  int *weights = new int[n];

  for (int i = 0; i < n; i++) {
    cin >> profits[i];
  }

  for (int i = 0; i < n; i++) {
    cin >> weights[i];
  }

  // Dynamically allocate 2D dp array
  int **dp = new int *[n + 1];
  for (int i = 0; i <= n; i++) {
    dp[i] = new int[W + 1];
  }

  int max_profit = knapSack(W, weights, profits, n, dp);

  cout << "\nMaximum profit is: " << max_profit << endl;
  printSelectedItems(n, W, max_profit, weights, profits, dp);

  // Clean up
  for (int i = 0; i <= n; i++) {
    delete[] dp[i];
  }
  delete[] dp;
  delete[] weights;
  delete[] profits;

  return 0;
}
