#include <climits>
#include <cstring>
#include <iostream>
#include <vector>

int dp[100][100];

int matrixChainMultiplication(int *matrices, int i, int j) {
  if (i == j) {
    return 0;
  }
  if (dp[i][j] != -1) {
    return dp[i][j];
  }
  dp[i][j] = INT_MAX;
  for (int k = i; k < j; k++) {
    dp[i][j] =
        std::min(dp[i][j], matrixChainMultiplication(matrices, i, k) +
                               matrixChainMultiplication(matrices, k + 1, j) +
                               matrices[i - 1] * matrices[k] * matrices[j]);
  }
  return dp[i][j];
}

int main() {
  std::memset(dp, -1, sizeof dp);
  int matrices[] = {2, 5, 10, 5, 6, 10};
  int i = 1, j = sizeof(matrices) / sizeof(matrices[0]) - 1;
  int result = matrixChainMultiplication(matrices, i, j);

  for (int i = 0; i < 5; i++) {
    for (int j = 0; j < 5; j++) {
      std::cout << dp[i][j] << "\t\t\t";
    }
    std::cout << "\n";
  }

  std::cout << "Minumum number of multiplications: " << result << "\n";
  return 0;
}
