#include <bits/stdc++.h>
using namespace std;

#define d 26

bool found = false;

void search(const string &pat, const string &txt, int q) {
  int M = pat.length();
  int N = txt.length();
  int p = 0; // hash for pattern
  int t = 0; // hash for current window of text
  int h = 1;

  // The value of h = pow(d, M-1) % q
  for (int i = 0; i < M - 1; i++)
    h = (h * d) % q;

  // Calculate initial hash values
  for (int i = 0; i < M; i++) {
    p = (d * p + (pat[i] - 'A')) % q;
    t = (d * t + (txt[i] - 'A')) % q;
  }

  // Slide the pattern over the text
  for (int i = 0; i <= N - M; i++) {
    // Check hash match
    if (p == t) {
      int j = 0;
      for (; j < M; j++) {
        if (txt[i + j] != pat[j])
          break;
      }
      if (j == M) {
        found = true;
        cout << "Pattern found at index " << i << '\n';
      }
    }

    // Compute hash for next window
    if (i < N - M) {
      t = (d * (t - (txt[i] - 'A') * h) + (txt[i + M] - 'A')) % q;
      if (t < 0)
        t += q;
    }
  }
}

int main() {
  string txt = "saqspapGPGGAS";
  string pat = "pcGa";

  cout << "Original Text: " << txt << endl;
  cout << "Original Pattern: " << pat << endl;

  // Convert both to uppercase
  transform(txt.begin(), txt.end(), txt.begin(), ::toupper);
  transform(pat.begin(), pat.end(), pat.begin(), ::toupper);

  cout << "Uppercase Text: " << txt << endl;
  cout << "Uppercase Pattern: " << pat << endl;

  int q;
  cout << "Enter a prime number for modulus (e.g., 101): ";
  cin >> q;

  search(pat, txt, q);

  if (!found)
    cout << "Pattern Not Found" << endl;

  return 0;
}
