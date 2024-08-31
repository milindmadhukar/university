#include <bits/stdc++.h>
using namespace std;

int assembly(
    int a[][4], int t[][4], int *e,
    int *x) // references to entry and exit taken because array size not defined
{
  int line_one, line_two, i;

  // calculates cost of first station in line 1
  // stores the minimum cost of line 1 traversal
  line_one = e[0] + a[0][0];

  // calculates cost of second station in line 2
  // stores the minimum cost of line 2 traversal
  line_two = e[1] + a[1][0];

  // Fill tables T1[] and T2[] using the
  // above given recursive relations
  for (i = 1; i < 4; ++i) {
    int moveup =
        min(line_one + a[0][i],
            line_two + t[1][i] +
                a[0][i]); // calculates minimum cost for moving up the line 1
    int movedown =
        min(line_two + a[1][i],
            line_one + t[0][i] +
                a[1][i]); // calculates minimum cost for moving up the line 2
    line_one = moveup;
    line_two = movedown;
  }

  return min(line_one + x[0], line_two + x[1]);
}

int main() {
  int entrycost[] = {10, 12}; // cost of entry
  int stationcost[][4] = {{4, 5, 3, 2},
                          {2, 10, 1, 4}}; // cost of indivisual stations
  int transitioncost[][4] = {
      {0, 7, 4, 5}, {0, 9, 2, 8}}; // transition cost between stations of lines
  int exitcost[] = {18, 7};        // exit cost

  cout << assembly(stationcost, transitioncost, entrycost, exitcost);

  return 0;
}
