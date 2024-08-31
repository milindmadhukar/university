#include "string"
#include <algorithm>
#include <iostream>
#include <string>

int lcs(const std::string &a, const std::string &b, int i, int j) {
  if (a[i] == '\0' || b[j] == '\0')
    return 0;
  else if (a[i] == b[j])
    return 1 + lcs(a, b, i + 1, j + 1);
  else
    return std::max(lcs(a, b, i + 1, j), lcs(a, b, i, j + 1));
}

int main() {
  std::string a = "bd";
  std::string b = "abcd";
  int res = lcs(a, b, 0, 0);

  std::cout << "Longest subsequence length: " << res << std::endl;
  return 0;
}
