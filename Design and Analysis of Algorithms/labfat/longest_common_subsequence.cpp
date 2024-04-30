#include <algorithm>
#include <iostream>
#include <string>

int dp[100][100];

int lcs(const std::string &X, const std::string &Y, const int m, const int n) {
  for (int i = 0; i <= m; i++) {
    for (int j = 0; j <= n; j++) {
      if (i == 0 || j == 0) {
        dp[i][j] = 0;
      } else if (X[i - 1] == Y[j - 1]) {
        dp[i][j] = dp[i - 1][j - 1] + 1;
      } else {
        dp[i][j] = std::max(dp[i - 1][j], dp[i][j - 1]);
      }
    }
  }

  return dp[m][n];
}

void find_sequence(const std::string &X, const int m, const int n) {
  if (dp[m][n] == dp[m - 1][n]) {
    find_sequence(X, m - 1, n);
  } else if (dp[m][n] == dp[m][n - 1]) {
    find_sequence(X, m, n - 1);
  } else if (dp[m][n] == dp[m - 1][n - 1] + 1) {
    find_sequence(X, m - 1, n - 1);
    std::cout << X[m - 1];
  }
}

int main() {
  std::string X = "longest";
  std::string Y = "stone";
  int m = X.size();
  int n = Y.size();

  // Function call
  std::cout << "Length of LCS is " << lcs(X, Y, m, n) << std::endl;
  std::cout << "LCS is: ";
  find_sequence(X, m, n);
  std::cout << std::endl;

  return 0;
}
