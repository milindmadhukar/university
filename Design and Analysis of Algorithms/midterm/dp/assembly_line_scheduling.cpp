#include <algorithm>
#include <iostream>
using namespace std;

void printPath(int **transfers, int idx, int currentLine, int N) {
  if (idx == 0) {
    cout << "Station " << idx << " Line " << currentLine + 1 << endl;
    return;
  }
  printPath(transfers, idx - 1, transfers[currentLine][idx - 1], N);
  cout << "Station " << idx << " Line " << currentLine + 1 << endl;
}

void assembly_line_cost(int *station1, int *station2, int *transfer1,
                        int *transfer2, int entry1, int entry2, int exit1,
                        int exit2, int N) {
  // Dynamically allocate arrays
  int **costs = new int *[2];
  costs[0] = new int[N];
  costs[1] = new int[N];

  int **transfers = new int *[2];
  transfers[0] = new int[N - 1];
  transfers[1] = new int[N - 1];

  // costs[line][stage]

  costs[0][0] = entry1 + station1[0];
  costs[1][0] = entry2 + station2[0];

  for (int stage = 1; stage < N; stage++) {
    int station1Direct = costs[0][stage - 1] + station1[stage];

    int station1Transfer =
        costs[1][stage - 1] + transfer2[stage - 1] + station1[stage];
    costs[0][stage] = min(station1Direct, station1Transfer);

    transfers[0][stage - 1] = (station1Direct <= station1Transfer) ? 0 : 1;

    int station2Direct = costs[1][stage - 1] + station2[stage];

    int station2Transfer =
        costs[0][stage - 1] + transfer1[stage - 1] + station2[stage];

    costs[1][stage] = min(station2Direct, station2Transfer);

    transfers[1][stage - 1] = (station2Direct <= station2Transfer) ? 1 : 0;
  }

  int station1Total = costs[0][N - 1] + exit1;
  int station2Total = costs[1][N - 1] + exit2;
  int minCost = min(station1Total, station2Total);
  int cheaperLine = station1Total <= station2Total ? 0 : 1;

  cout << "\nTotal cost: " << minCost << endl;
  cout << "Optimal path:" << endl;
  printPath(transfers, N - 1, cheaperLine, N);

  // Clean up
  delete[] costs[0];
  delete[] costs[1];
  delete[] costs;
  delete[] transfers[0];
  delete[] transfers[1];
  delete[] transfers;
}

int main() {
  int N;
  cout << "Enter the number of stations: ";
  cin >> N;

  int *station1 = new int[N];
  int *station2 = new int[N];
  int *transfer1 = new int[N - 1];
  int *transfer2 = new int[N - 1];

  cout << "\nEnter costs for " << N << " stations on Line 1: ";
  for (int i = 0; i < N; i++) {
    cin >> station1[i];
  }

  cout << "Enter costs for " << N << " stations on Line 2: ";
  for (int i = 0; i < N; i++) {
    cin >> station2[i];
  }

  cout << "\nEnter " << (N - 1) << " transfer costs from Line 1 to Line 2: ";
  for (int i = 0; i < N - 1; i++) {
    cin >> transfer1[i];
  }

  cout << "Enter " << (N - 1) << " transfer costs from Line 2 to Line 1: ";
  for (int i = 0; i < N - 1; i++) {
    cin >> transfer2[i];
  }

  int entry1, entry2, exit1, exit2;
  cout << "\nEnter entry cost for Line 1: ";
  cin >> entry1;
  cout << "Enter entry cost for Line 2: ";
  cin >> entry2;
  cout << "Enter exit cost for Line 1: ";
  cin >> exit1;
  cout << "Enter exit cost for Line 2: ";
  cin >> exit2;

  assembly_line_cost(station1, station2, transfer1, transfer2, entry1, entry2,
                     exit1, exit2, N);

  // Clean up
  delete[] station1;
  delete[] station2;
  delete[] transfer1;
  delete[] transfer2;

  return 0;
}
