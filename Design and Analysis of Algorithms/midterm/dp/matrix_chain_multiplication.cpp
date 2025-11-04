#include <climits>
#include <iostream>
using namespace std;

int matrixChainMultiplication(int *matrices, int i, int j, int **dp,
                              int **split) {
  if (i == j) {
    return 0;
  }
  if (dp[i][j] != -1) {
    return dp[i][j];
  }
  dp[i][j] = INT_MAX;
  for (int k = i; k < j; k++) {
    int cost = matrixChainMultiplication(matrices, i, k, dp, split) +
               matrixChainMultiplication(matrices, k + 1, j, dp, split) +
               matrices[i - 1] * matrices[k] * matrices[j];
    if (cost < dp[i][j]) {
      dp[i][j] = cost;
      split[i][j] = k;
    }
  }
  return dp[i][j];
}

void printParenthesis(int i, int j, int **split) {
  if (i == j) {
    cout << "A" << i;
    return;
  }
  cout << "(";
  printParenthesis(i, split[i][j], split);
  printParenthesis(split[i][j] + 1, j, split);
  cout << ")";
}

int main() {
  int n;

  cout << "Enter the number of matrices: ";
  cin >> n;

  if (n <= 0) {
    cout << "Invalid number of matrices!" << endl;
    return 1;
  }

  int *matrices = new int[n + 1];

  cout << "Enter " << (n + 1) << " dimensions: ";
  for (int i = 0; i <= n; i++) {
    cin >> matrices[i];
  }

  // Dynamically allocate 2D dp and split arrays
  int **dp = new int *[n + 1];
  int **split = new int *[n + 1];
  for (int i = 0; i <= n; i++) {
    dp[i] = new int[n + 1];
    split[i] = new int[n + 1];
    for (int j = 0; j <= n; j++) {
      dp[i][j] = -1;
      split[i][j] = -1;
    }
  }

  int result = matrixChainMultiplication(matrices, 1, n, dp, split);

  cout << "Minimum number of multiplications: " << result << endl;
  cout << "Optimal parenthesization: ";
  printParenthesis(1, n, split);
  cout << endl;

  // Clean up
  for (int i = 0; i <= n; i++) {
    delete[] dp[i];
    delete[] split[i];
  }
  delete[] dp;
  delete[] split;
  delete[] matrices;

  return 0;
}
