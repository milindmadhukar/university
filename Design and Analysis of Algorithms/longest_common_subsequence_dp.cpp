#include <bits/stdc++.h>

int dp[100][100];
char dir[100][100];

int lcs(const std::string &X, const std::string &Y, int m, int n) {
  for (int i = 0; i <= m; i++) {
    for (int j = 0; j <= n; j++) {
      if (i == 0 || j == 0) {
        dp[i][j] = 0;
      } else if (X[i - 1] == Y[j - 1]) {
        dp[i][j] = dp[i - 1][j - 1] + 1;
        dir[i][j] = 'd';
      } else {
        if (dp[i - 1][j] > dp[i][j - 1]) {
          dp[i][j] = dp[i - 1][j];
          dir[i][j] = 'u';
        } else {
          dp[i][j] = dp[i][j - 1];
          dir[i][j] = 'l';
        }
      }
    }
  }
  return dp[m][n];
}

void find_sequence(const std::string &X, int m, int n) {
  if (dp[m][n] == dp[m-1][n]) { // up
    find_sequence(X, m-1, n);
  } else if (dp[m][n] == dp[m][n-1]) { // left
    find_sequence(X, m, n-1);
  } else if (dp[m][n] == dp[m-1][n-1] + 1) { // diagonal
    find_sequence(X, m-1, n-1);
    std::cout << X[m-1];
  }
}

// Driver code
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
