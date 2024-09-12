#include <limits.h>
#include <stdio.h>

struct Process {
  int id;
  int arrival_time;
  int burst_time;
  int completion_time;
  int turnaround_time;
  int waiting_time;
};

void sortProcesses(struct Process proc[], int n) {
  int i, j;
  for (i = 0; i < n - 1; i++) {
    for (j = 0; j < n - i - 1; j++) {
      if (proc[j].arrival_time > proc[j + 1].arrival_time) {
        struct Process temp = proc[j];
        proc[j] = proc[j + 1];
        proc[j + 1] = temp;
      }
    }
  }
}

void calculateTimes(struct Process proc[], int n) {
  int current_time = 0;
  int completed = 0;
  int shortest_job;
  int min_burst_time;

  while (completed != n) {
    shortest_job = -1;
    min_burst_time = INT_MAX;

    for (int i = 0; i < n; i++) {
      if (proc[i].arrival_time <= current_time &&
          proc[i].burst_time < min_burst_time && proc[i].burst_time > 0) {
        shortest_job = i;
        min_burst_time = proc[i].burst_time;
      }
    }

    if (shortest_job == -1) {
      current_time++;
    } else {
      proc[shortest_job].completion_time =
          current_time + proc[shortest_job].burst_time;

      proc[shortest_job].turnaround_time =
          proc[shortest_job].completion_time - proc[shortest_job].arrival_time;

      proc[shortest_job].waiting_time =
          proc[shortest_job].turnaround_time - proc[shortest_job].burst_time;

      proc[shortest_job].burst_time = 0;

      current_time = proc[shortest_job].completion_time;
      completed++;
    }
  }
}

void printProcesses(struct Process proc[], int n) {
  printf("\nProcess\tArrival Time\tBurst Time\tCompletion Time\tTurnaround "
         "Time\tWaiting Time\n");
  for (int i = 0; i < n; i++) {
    printf("%d\t%d\t\t%d\t\t%d\t\t%d\t\t%d\n", proc[i].id, proc[i].arrival_time,
           proc[i].burst_time, proc[i].completion_time, proc[i].turnaround_time,
           proc[i].waiting_time);
  }
}

float calculateAverageWaitingTime(struct Process proc[], int n) {
  float total_waiting_time = 0;
  for (int i = 0; i < n; i++) {
    total_waiting_time += proc[i].waiting_time;
  }
  return total_waiting_time / n;
}

float calculateAverageTurnaroundTime(struct Process proc[], int n) {
  float total_turnaround_time = 0;
  for (int i = 0; i < n; i++) {
    total_turnaround_time += proc[i].turnaround_time;
  }
  return total_turnaround_time / n;
}

int main() {
  int n;

  printf("Enter the number of processes: ");
  scanf("%d", &n);

  struct Process proc[n];

  for (int i = 0; i < n; i++) {
    proc[i].id = i + 1;
    printf("Enter arrival time for process %d: ", i + 1);
    scanf("%d", &proc[i].arrival_time);
    printf("Enter burst time for process %d: ", i + 1);
    scanf("%d", &proc[i].burst_time);
  }

  sortProcesses(proc, n);
  calculateTimes(proc, n);

  printf("\nShortest Job First (SJF) Scheduling:\n");
  printProcesses(proc, n);

  float avg_waiting_time = calculateAverageWaitingTime(proc, n);
  float avg_turnaround_time = calculateAverageTurnaroundTime(proc, n);

  printf("\nAverage Waiting Time: %.2f", avg_waiting_time);
  printf("\nAverage Turnaround Time: %.2f\n", avg_turnaround_time);

  return 0;
}
