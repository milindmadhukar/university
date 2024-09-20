#include <stdio.h>

#define MAX_PROCESSES 100

struct Process {
  int pid;
  int arrival;
  int burst;
  int start;
  int completion;
  int turnaround;
  int waiting;
};

struct Process processes[MAX_PROCESSES];
int n;

void firstComeFirstServe() {
  int current_time = 0;
  float total_turnaround_time = 0, total_waiting_time = 0;

  for (int i = 0; i < n - 1; i++) {
    for (int j = 0; j < n - i - 1; j++) {
      if (processes[j].arrival > processes[j + 1].arrival) {
        struct Process temp = processes[j];
        processes[j] = processes[j + 1];
        processes[j + 1] = temp;
      }
    }
  }

  for (int i = 0; i < n; i++) {
    if (current_time < processes[i].arrival) {
      current_time = processes[i].arrival;
    }

    processes[i].start = current_time;
    processes[i].completion = current_time + processes[i].burst;
    processes[i].turnaround = processes[i].completion - processes[i].arrival;
    processes[i].waiting = processes[i].turnaround - processes[i].burst;

    current_time = processes[i].completion;

    total_turnaround_time += processes[i].turnaround;
    total_waiting_time += processes[i].waiting;
  }

  printf("\nProcess\t\tArrival Time\tBurst Time\tStart Time\tCompletion "
         "Time\tTurnaround Time\tWaiting Time\n");

  for (int i = 0; i < n; i++) {
    printf("P%d\t\t%d\t\t%d\t\t%d\t\t%d\t\t%d\t\t%d\n", processes[i].pid,
           processes[i].arrival, processes[i].burst, processes[i].start,
           processes[i].completion, processes[i].turnaround,
           processes[i].waiting);
  }

  printf("\nAverage Turnaround Time: %.2f", total_turnaround_time / n);
  printf("\nAverage Waiting Time: %.2f\n", total_waiting_time / n);
}

void printGanttChart() {
  printf("\nGantt Chart:\n");
  printf("0");
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < processes[i].burst; j++) {
      printf("-");
    }
    printf("%d", processes[i].completion);
  }
  printf("\n");

  for (int i = 0; i < n; i++) {
    printf("|");
    for (int j = 0; j < processes[i].burst - 1; j++) {
      printf(" ");
    }
    printf("P%d", processes[i].pid);
    for (int j = 0; j < processes[i].burst - 1; j++) {
      printf(" ");
    }
  }
  printf("|\n");
}

int main() {
  printf("Enter the number of processes: ");
  scanf("%d", &n);

  for (int i = 0; i < n; i++) {
    processes[i].pid = i + 1;
    printf("Enter arrival time for Process %d: ", i + 1);
    scanf("%d", &processes[i].arrival);
    printf("Enter burst time for Process %d: ", i + 1);
    scanf("%d", &processes[i].burst);
  }

  firstComeFirstServe();
  printGanttChart();

  return 0;
}
