#include <iostream>
using namespace std;

int main() {
  int n;

  cin >> n;
  int *startTimes = new int[n];
  int *finishTimes = new int[n];

  for (int i = 0; i < n; i++) {
    cin >> startTimes[i];
  }

  for (int i = 0; i < n; i++) {
    cin >> finishTimes[i];
  }

  // Sort jobs by finish times in ascending order
  for (int i = 0; i < n - 1; i++) {
    for (int j = 0; j < n - i - 1; j++) {
      if (finishTimes[j] > finishTimes[j + 1]) {
        int temp = finishTimes[j];
        finishTimes[j] = finishTimes[j + 1];
        finishTimes[j + 1] = temp;

        temp = startTimes[j];
        startTimes[j] = startTimes[j + 1];
        startTimes[j + 1] = temp;
      }
    }
  }

  int currentTime = finishTimes[0];
  int count = 0;
  int *selected_jobs = new int[n];
  selected_jobs[count++] = 1;

  for (int i = 1; i < n; i++) {
    if (startTimes[i] >= currentTime) {
      selected_jobs[count++] = i + 1;
      currentTime = finishTimes[i];
    }
  }

  cout << count << endl;

  for (int i = 0; i < count; i++) {
    cout << selected_jobs[i] << " ";
  }

  delete[] startTimes;
  delete[] finishTimes;
  delete[] selected_jobs;

  return 0;
}
