#include <stdio.h>

int main() {
  int arrival_times[] = {0, 1, 2};
  int burst_times[] = {8, 4, 9};

  int n = sizeof(arrival_times) / sizeof(arrival_times[0]);

  int completion_time[n];
  int turnaround_times[n];
  int waiting_times[n];

  int total_turnaround_time = 0;
  int total_waiting_time = 0;

  int current_time = 0;
  for (int i = 0; i < n; i++) {
    if (current_time < arrival_times[i]) {
      current_time = arrival_times[i];
    }
    completion_time[i] = current_time + burst_times[i];
    current_time = completion_time[i];
  }

  for (int i = 0; i < n; i++) {
    turnaround_times[i] = completion_time[i] - arrival_times[i];
    waiting_times[i] = turnaround_times[i] - burst_times[i];
    total_turnaround_time += turnaround_times[i];
    total_waiting_time += waiting_times[i];
  }

  float avg_turnaround_time = (float)total_turnaround_time / n;
  float avg_waiting_time = (float)total_waiting_time / n;

  printf("Average Turnaround Time: %f\nAverage Waiting Time: %f\n",
         avg_turnaround_time, avg_waiting_time);

  return 0;
}
