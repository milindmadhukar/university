#include <limits.h>
#include <stdio.h>

#define MAX_PROCESSES 100
int gantt_chart[MAX_PROCESSES * 2][2];
int gantt_size = 0;
struct Process {
  int id;
  int arrival_time;
  int burst_time;
  int completion_time;
  int turnaround_time;
  int waiting_time;
};


void swap(struct Process *a, struct Process *b) {
  struct Process temp = *a;
  *a = *b;
  *b = temp;
}

void sortByArrivalTime(struct Process processes[], int n) {
  for (int i = 0; i < n - 1; i++) {
    for (int j = i + 1; j < n; j++) {
      if (processes[i].arrival_time > processes[j].arrival_time) {
        swap(&processes[i], &processes[j]);
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
      gantt_chart[gantt_size][0] = proc[shortest_job].id;
      gantt_chart[gantt_size][1] = current_time;
      gantt_size++;

      proc[shortest_job].completion_time =
          current_time + proc[shortest_job].burst_time;

      proc[shortest_job].turnaround_time =
          proc[shortest_job].completion_time - proc[shortest_job].arrival_time;

      proc[shortest_job].waiting_time =
          proc[shortest_job].turnaround_time - proc[shortest_job].burst_time;

      current_time = proc[shortest_job].completion_time;

      proc[shortest_job].burst_time = 0;
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

void printGanttChart(struct Process proc[]) {
  printf("\nGantt Chart:\n");
  for (int i = 0; i < gantt_size; i++) {
    printf("| P%d ", gantt_chart[i][0]);
  }
  printf("|\n");
  for (int i = 0; i < gantt_size; i++) {
    printf("%d    ", gantt_chart[i][1]);
  }
  printf("%d\n", gantt_chart[gantt_size - 1][1] +
                     proc[gantt_chart[gantt_size - 1][0] - 1].burst_time);
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

  sortByArrivalTime(proc, n);
  calculateTimes(proc, n);

  printf("\nShortest Job First (SJF) Scheduling:\n");
  printProcesses(proc, n);

  float avg_waiting_time = calculateAverageWaitingTime(proc, n);
  float avg_turnaround_time = calculateAverageTurnaroundTime(proc, n);

  printf("\nAverage Waiting Time: %.2f", avg_waiting_time);
  printf("\nAverage Turnaround Time: %.2f\n", avg_turnaround_time);

  printGanttChart(proc);

  return 0;
}
