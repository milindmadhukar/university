#include <stdio.h>

int main() {
  int arrival_times[] = {0, 0, 0};
  int burst_times[] = {6, 3, 8};

  int n = sizeof(arrival_times) / sizeof(arrival_times[0]);

  int completion_time[n];
  int turnaround_times[n];
  int waiting_times[n];

  int total_turnaround_time = 0;
  int total_waiting_time = 0;

  for (int i = 0; i < n; i++) {
    if (i == 0) {
      completion_time[i] = arrival_times[i] + burst_times[i];
    } else {
      if (arrival_times[i] > completion_time[i - 1]) {
        completion_time[i] = arrival_times[i] + burst_times[i];
      } else {
        completion_time[i] = completion_time[i - 1] + burst_times[i];
      }
    }

    int current_turnaround_time = completion_time[i] - arrival_times[i];
    turnaround_times[i] = current_turnaround_time;
    total_turnaround_time += current_turnaround_time;

    int current_waiting_time = turnaround_times[i] - burst_times[i];
    waiting_times[i] = current_waiting_time;
    total_waiting_time += current_waiting_time;
  }

  float avg_turnaround_time = (float)total_turnaround_time / n;
  float avg_waiting_time = (float)total_waiting_time / n;

  printf("Average Turnaround Time: %f\nAverage Waiting Time: %f\n",
         avg_turnaround_time, avg_waiting_time);

  return 0;
}
