#include <iostream>
#include <string>
using namespace std;

int lcs(const string &X, const string &Y, int m, int n, int **dp) {
  for (int i = 0; i <= m; i++) {
    for (int j = 0; j <= n; j++) {
      if (i == 0 || j == 0) {
        dp[i][j] = 0;
      } else if (X[i - 1] == Y[j - 1]) {
        dp[i][j] = dp[i - 1][j - 1] + 1;
      } else {
        dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]);
      }
    }
  }
  return dp[m][n];
}

void find_sequence(const string &X, const string &Y, int m, int n,
                   string &result, int **dp, int choice) {
  if (m == 0 || n == 0) {
    return;
  }

  if (X[m - 1] == Y[n - 1]) {
    find_sequence(X, Y, m - 1, n - 1, result, dp, choice);
    result += X[m - 1];
  } else if (dp[m - 1][n] > dp[m][n - 1]) {
    find_sequence(X, Y, m - 1, n, result, dp, choice);
  } else if (dp[m - 1][n] < dp[m][n - 1]) {
    find_sequence(X, Y, m, n - 1, result, dp, choice);
  } else {
    if (choice == 1) {
      find_sequence(X, Y, m, n - 1, result, dp, choice);
    } else {
      find_sequence(X, Y, m - 1, n, result, dp, choice);
    }
  }
}

int main() {
  int m, n;
  string X, Y;

  cin >> m;
  cin >> X;
  cin >> n;
  cin >> Y;
  int choice;
  cin >> choice;

  int **dp = new int *[m + 1];
  for (int i = 0; i <= m; i++) {
    dp[i] = new int[n + 1];
  }

  int length = lcs(X, Y, m, n, dp);

  string result = "";
  find_sequence(X, Y, m, n, result, dp, choice);

  cout << length << endl;
  cout << result << endl;

  for (int i = 0; i <= m; i++) {
    delete[] dp[i];
  }
  delete[] dp;

  return 0;
}
