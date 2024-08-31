#include "string"
#include <algorithm>
#include <cstring>
#include <iostream>
#include <string>

int dp[100][100];

int lcs(const std::string &a, const std::string &b, int i, int j) {
  if (dp[i][j] != -1)
    return dp[i][j];

  if (a[i] == '\0' || b[j] == '\0')
    return 0;

  else if (a[i] == b[j]) {
    int val = lcs(a, b, i + 1, j + 1);
    dp[i + 1][j + 1] = val;
    return 1 + val;
  } else {
    int lcs1 = lcs(a, b, i + 1, j);
    dp[i + 1][j] = lcs1;
    int lcs2 = lcs(a, b, i, j + 1);
    dp[i][j + 1] = lcs2;
    return std::max(lcs1, lcs2);
  }
}

int main() {
  std::memset(dp, -1, sizeof dp);
  std::string a = "bd";
  std::string b = "abcd";
  int res = lcs(a, b, 0, 0);

  std::cout << "Longest subsequence length: " << res << std::endl;
  return 0;
}
