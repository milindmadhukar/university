#include <stdio.h>

struct Process {
  int pid;
  int arrival;
  int burst;
  int start;
  int completion;
  int turnaround;
  int waiting;
};

void firstComeFirstServe(struct Process proc[], int n) {
  int current_time = 0;
  float total_turnaround_time = 0, total_waiting_time = 0;

  for (int i = 0; i < n - 1; i++) {
    for (int j = 0; j < n - i - 1; j++) {
      if (proc[j].arrival > proc[j + 1].arrival) {
        struct Process temp = proc[j];
        proc[j] = proc[j + 1];
        proc[j + 1] = temp;
      }
    }
  }

  for (int i = 0; i < n; i++) {
    if (current_time < proc[i].arrival) {
      current_time = proc[i].arrival;
    }

    proc[i].start = current_time;
    proc[i].completion = current_time + proc[i].burst;
    proc[i].turnaround = proc[i].completion - proc[i].arrival;
    proc[i].waiting = proc[i].turnaround - proc[i].burst;

    current_time = proc[i].completion;

    total_turnaround_time += proc[i].turnaround;
    total_waiting_time += proc[i].waiting;
  }

  printf("\nProcess\t\tArrival Time\tBurst Time\tStart Time\tCompletion "
         "Time\tTurnaround Time\tWaiting Time\n");

  for (int i = 0; i < n; i++) {
    printf("P%d\t\t%d\t\t%d\t\t%d\t\t%d\t\t%d\t\t%d\n", proc[i].pid,
           proc[i].arrival, proc[i].burst, proc[i].start, proc[i].completion,
           proc[i].turnaround, proc[i].waiting);
  }

  printf("\nAverage Turnaround Time: %.2f", total_turnaround_time / n);
  printf("\nAverage Waiting Time: %.2f\n", total_waiting_time / n);
}

int main() {
  int n;

  printf("Enter the number of processes: ");
  scanf("%d", &n);

  struct Process processes[n];

  for (int i = 0; i < n; i++) {
    processes[i].pid = i + 1;
    printf("Enter arrival time for Process %d: ", i + 1);
    scanf("%d", &processes[i].arrival);
    printf("Enter burst time for Process %d: ", i + 1);
    scanf("%d", &processes[i].burst);
  }

  firstComeFirstServe(processes, n);

  return 0;
}
