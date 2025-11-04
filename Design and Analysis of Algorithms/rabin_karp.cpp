#include <bits/stdc++.h>
using namespace std;

#define d 26

bool check = true;

void search(char pat[], char txt[], int q) {
  int M = strlen(pat);
  int N = strlen(txt);
  int i, j;
  int p = 0; // hash value for pattern
  int t = 0; // hash value for current text window
  int h = 1;

  // The value of h is "pow(d, M-1) % q"
  for (i = 0; i < M - 1; i++)
    h = (h * d) % q;

  for (i = 0; i < M; i++) {
    p = (d * p + (pat[i] - 'A')) % q;
    t = (d * t + (txt[i] - 'A')) % q;
  }

  for (i = 0; i <= N - M; i++) {
    if (p == t) {
      for (j = 0; j < M; j++) {
        if (txt[i + j] != pat[j]) {
          break;
        }
      }

      if (j == M) {
        check = false; // Pattern found
        cout << "Pattern found at index " << i << endl;
      }
    }

    if (i < N - M) {
      t = (d * (t - (txt[i] - 'A') * h) + (txt[i + M] - 'A')) % q;

      if (t < 0)
        t = (t + q);
    }
  }
}

int main() {
  char txt[] = "saqspapGPGGAS";
  char pat[] = "pcGa";

  int n = strlen(txt);
  int m = strlen(pat);

  cout << "Original Text: " << txt << endl;
  cout << "Original Pattern: " << pat << endl;

  for (int i = 0; i < n; i++) {
    txt[i] = toupper(txt[i]);
  }
  for (int i = 0; i < m; i++) {
    pat[i] = toupper(pat[i]);
  }

  cout << "Uppercase Text: " << txt << endl;
  cout << "Uppercase Pattern: " << pat << endl;

  int q;
  cout << "Enter a prime number for the modulus (q) (e.g., 101): ";
  cin >> q;

  search(pat, txt, q);

  if (check) {
    std::cout << "Pattern Not found" << std::endl;
  }

  return 0;
}
