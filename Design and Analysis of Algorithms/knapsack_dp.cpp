#include <bits/stdc++.h>

int dp[100][100];

int knapSack(int W, int weights[], int profits[], int n) {
  memset(dp, 0, sizeof(dp));

  for (int i = 1; i <= n; i++) {
    for (int w = 1; w <= W; w++) {
      if (weights[i - 1] > w) {
        dp[i][w] = dp[i - 1][w];
      } else {
        dp[i][w] = std::max(profits[i - 1] + dp[i - 1][w - weights[i - 1]],
                            dp[i - 1][w]);
      }
    }
  }

  return dp[n][W];
}

void printSelectedItems(int n, int W, int total_profit, int weights[],
                        int profits[]) {
  int w = W;
  for (int i = n; i > 0 && total_profit > 0; i--) {
    if (total_profit == dp[i - 1][w]) {
      continue;
    } else {
      std::cout << "Item " << i << " with weight " << weights[i - 1]
                << " and value " << profits[i - 1] << " is selected"
                << std::endl;
      total_profit -= profits[i - 1];
      w -= weights[i - 1];
    }
  }
}

int main() {
  int profits[] = {1, 6, 18, 22, 28};
  int weights[] = {1, 2, 5, 6, 7};
  int W = 11;
  int n = sizeof(profits) / sizeof(profits[0]);
  int max_profit = knapSack(W, weights, profits, n);
  std::cout << "Maximum profit is: " << max_profit << std::endl;

  printSelectedItems(n, W, max_profit, weights, profits);
  return 0;
}
