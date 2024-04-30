#include <algorithm>
#include <iostream>
#define N 5

int costs[2][N];
int transfers[2][N - 1];

// FIX: This is broken
void printPath(int idx, int currentLine) {
  if (idx == 0) {
    return;
  }

  printPath(idx - 1, transfers[currentLine][idx-1]);
  std::cout << "Station " << idx << " Line " << currentLine + 1 << std::endl;
}

void assembly_line_cost(int station1[N], int station2[N], int transfer1[N],
                        int transfer2[N], int entry1, int entry2, int exit1,
                        int exit2) {

  costs[0][0] = entry1 + station1[0];
  costs[1][0] = entry2 + station2[0];

  for (int stage = 1; stage < N; stage++) {
    int station1Direct = costs[0][stage - 1] + station1[stage];
    int station1Transfer =
        costs[0][stage - 1] + transfer1[stage - 1] + station2[stage];
    costs[0][stage] = std::min(station1Direct, station1Transfer);

    if (station1Direct < station1Transfer) {
      transfers[0][stage - 1] = 0;
    } else {
      transfers[0][stage - 1] = 1;
    }

    int station2Direct = costs[1][stage - 1] + station2[stage];
    int station2Transfer =
        costs[1][stage - 1] + transfer2[stage - 1] + station1[stage];
    costs[1][stage] = std::min(station1Direct, station1Transfer);

    if (station2Direct < station2Transfer) {
      transfers[1][stage - 1] = 1;
    } else {
      transfers[1][stage - 1] = 0;
    }
  }

  int station1Total = costs[0][N - 1] + exit1;
  int station2Total = costs[1][N - 1] + exit2;
  int minCost = std::min(station1Total, station2Total);

  int cheaperLine = station1Total <= station2Total ? 0 : 1;

  std::cout << "Total cost: " << minCost << std::endl;

  printPath(N, cheaperLine);
}

int main() {
  int station1[] = {8, 10, 4, 5, 9};
  int station2[] = {9, 6, 7, 6, 5};
  int transfer1[] = {2, 3, 1, 3};
  int transfer2[] = {2, 1, 2, 2};
  int entry1 = 3;
  int entry2 = 5;
  int exit1 = 2;
  int exit2 = 1;

  assembly_line_cost(station1, station2, transfer1, transfer2, entry1, entry2,
                     exit1, exit2);
}
