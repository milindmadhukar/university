#include <bits/stdc++.h>

int dp[100][100];
char dir[100][100];

int lcs(const std::string &X, const std::string &Y, int m, int n) {

  // Initializing a matrix of size
  // (m+1)*(n+1)

  // Following steps build L[m+1][n+1]
  // in bottom up fashion. Note that
  // L[i][j] contains length of LCS of
  // X[0..i-1] and Y[0..j-1]
  for (int i = 0; i <= m; i++) {
    for (int j = 0; j <= n; j++) {
      if (i == 0 || j == 0) {
        dp[i][j] = 0;
      }

      else if (X[i - 1] == Y[j - 1])
        dp[i][j] = dp[i - 1][j - 1] + 1;

      else
        dp[i][j] = fmax(dp[i - 1][j], dp[i][j - 1]);
    }
  }

  // L[m][n] contains length of LCS
  // for X[0..n-1] and Y[0..m-1]
  return dp[m][n];
}

// Driver code
int main() {
  std::string S1 = "longest";
  std::string S2 = "stone";
  int m = S1.size();
  int n = S2.size();

  // Function call
  std::cout << "Length of LCS is " << lcs(S1, S2, m, n) << std::endl;

  return 0;
}
