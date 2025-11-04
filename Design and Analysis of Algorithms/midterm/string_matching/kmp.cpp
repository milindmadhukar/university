#include <iostream>
#include <string>

using namespace std;

bool check = true;

void computePrefixSuffix(const string &pattern, int prefixSuffix[]) {
  int M = pattern.length();
  int i = 0;
  prefixSuffix[0] = 0;

  for (int j = 1; j < M; j++) {
    while (i > 0 && pattern[j] != pattern[i]) {
      i = prefixSuffix[i - 1];
    }
    if (pattern[j] == pattern[i]) {
      i++;
    }
    prefixSuffix[j] = i;
  }
}

void kmp(const string &pattern, const string &text) {
  int M = pattern.length();
  int N = text.length();
  int prefixSuffix[M];

  computePrefixSuffix(pattern, prefixSuffix);

  int j = 0;
  int k = 0;

  while (j < N) {
    if (pattern[k] == text[j]) {
      j++;
      k++;
    }

    if (k == M) {
      check = false;
      cout << "Pattern found at index " << j - k << endl;
      k = prefixSuffix[k - 1];
    } else if (pattern[k] != text[j]) {
      if (k != 0)
        k = prefixSuffix[k - 1];
      else
        j++;
    }
  }
}

int main() {
  string text = "SAQSPAPGPGGAS";
  string pattern = "PCGA";

  kmp(pattern, text);

  if (check) {
    cout << "Pattern not found" << endl;
  }
  return 0;
}
