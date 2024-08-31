#include <bits/stdc++.h>
#include <iostream>

void computeLPSArray(std::string pat, int M, int *lps);

void KMPSearch(const std::string P, const std::string T) {
  int m = P.length();
  int n = T.length();

  int lps[m];

  computeLPSArray(P, m, lps);

  int q = 0;

  for (int i = 1; i <= n; i++) {
    while (q > 0 && P[q + 1] != T[i]) {
      q = lps[q];
    }
    if (P[q + 1] == T[i])
      q = q + 1;
    if (q == m) {
      std::cout << "Pattern occuers at index " << i - m << std::endl;
      q = lps[q];
    }
  }
}

// Fills lps[] for given pattern pat[0..M-1]
void computeLPSArray(std::string P, int m, int *lps) {
  lps[0] = 0;

  int i = 1;
  while (i < m) {
    if (P[i] == P[len]) {
      len++;
      lps[i] = len;
      i++;
    } else {
      if (len != 0) {
        len = lps[len - 1];
      } else // if (len == 0)
      {
        lps[i] = 0;
        i++;
      }
    }
  }
}

// Driver code
int main() {
  std::string txt = "ABABDABACDABABCABAB";
  std::string pat = "ABABCABAB";
  KMPSearch(pat, txt);
  return 0;
}
