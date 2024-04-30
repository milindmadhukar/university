#include <bits/stdc++.h>
#include <climits>
#include <cmath>
#include <unordered_map>

std::unordered_map<char, int> codes;

int hash(std::string s, int start, int end) {
  int val = 0;
  int count = 0;
  for (int i = start; i < end; i++) {
    char c = s[i];
    val += codes[c] * int(std::pow(10, count));
    count++;
  }

  return val % INT_MAX;
}

void search(std::string pat, std::string txt) {

  int pattern_hash = hash(pat, 0, pat.length());
  for (int i = 0; i < txt.length() - pat.length(); i++) {
    int current_hash = hash(txt, i, i + pat.length());

    if (pattern_hash == current_hash) {
      std::cout << "Matching hogayi at " << i << std::endl;
    }
  }
}

int main() {
  char txt[] = "GEEKS FOR GEEKS";
  char pat[] = "GEEK";

  int j = 0;
  for (int i = 65; i < 65 + 26; i++) {
    codes[char(i)] = j;
    j++;
  }

  search(pat, txt);
  return 0;
}
