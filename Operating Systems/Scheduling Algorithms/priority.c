#include <limits.h>
#include <stdio.h>

struct Process {
  int pid;
  int arrival;
  int burst;
  int priority;
  int remaining;
  int completion;
  int turnaround;
  int waiting;
  int start_time;  // New field to track when the process starts execution
};

// Global array to store the Gantt chart
struct GanttEntry {
  int pid;
  int start_time;
  int end_time;
};

#define MAX_GANTT_ENTRIES 1000
struct GanttEntry gantt_chart[MAX_GANTT_ENTRIES];
int gantt_entries = 0;

void sortByArrivalTime(struct Process proc[], int n) {
  for (int i = 0; i < n - 1; i++) {
    for (int j = 0; j < n - i - 1; j++) {
      if (proc[j].arrival > proc[j + 1].arrival) {
        struct Process temp = proc[j];
        proc[j] = proc[j + 1];
        proc[j + 1] = temp;
      }
    }
  }
}

void priorityScheduling(struct Process proc[], int n) {
  int current_time = 0;
  int completed = 0;
  int prev = 0;

  while (completed != n) {
    int idx = -1;
    int highest_priority = INT_MAX;

    for (int i = 0; i < n; i++) {
      if (proc[i].arrival <= current_time && proc[i].remaining > 0) {
        if (proc[i].priority < highest_priority) {
          highest_priority = proc[i].priority;
          idx = i;
        }
        if (proc[i].priority == highest_priority) {
          if (proc[i].arrival < proc[idx].arrival) {
            highest_priority = proc[i].priority;
            idx = i;
          }
        }
      }
    }

    if (idx != -1) {
      if (proc[idx].remaining == proc[idx].burst) {
        proc[idx].start_time = current_time;
        proc[idx].waiting = current_time - proc[idx].arrival;
      }
      
      int execution_time = (proc[idx].remaining < 1) ? proc[idx].remaining : 1;
      
      // Add Gantt chart entry
      gantt_chart[gantt_entries].pid = proc[idx].pid;
      gantt_chart[gantt_entries].start_time = current_time;
      gantt_chart[gantt_entries].end_time = current_time + execution_time;
      gantt_entries++;

      proc[idx].remaining -= execution_time;
      current_time += execution_time;
      prev = current_time;

      if (proc[idx].remaining == 0) {
        completed++;
        proc[idx].completion = current_time;
        proc[idx].turnaround = proc[idx].completion - proc[idx].arrival;
      }
    } else {
      current_time++;
      
      // Add idle time to Gantt chart
      if (gantt_entries == 0 || gantt_chart[gantt_entries-1].pid != 0) {
        gantt_chart[gantt_entries].pid = 0;  // 0 represents idle time
        gantt_chart[gantt_entries].start_time = current_time - 1;
        gantt_chart[gantt_entries].end_time = current_time;
        gantt_entries++;
      } else {
        gantt_chart[gantt_entries-1].end_time = current_time;
      }
    }
  }
}

void print_table(struct Process processes[], int n) {
  printf("\nProcess\tArrival Time\tBurst Time\tPriority\tCompletion "
         "Time\tTurnaround Time\tWaiting Time\n");
  for (int i = 0; i < n; i++) {
    printf("%d\t%d\t\t%d\t\t%d\t\t%d\t\t%d\t\t%d\n", processes[i].pid,
           processes[i].arrival, processes[i].burst, processes[i].priority,
           processes[i].completion, processes[i].turnaround,
           processes[i].waiting);
  }
}

void print_gantt_chart() {
  printf("\nGantt Chart:\n");
  printf("0");
  for (int i = 0; i < gantt_entries; i++) {
    for (int j = 0; j < (gantt_chart[i].end_time - gantt_chart[i].start_time) * 3; j++) {
      printf("-");
    }
    printf(" ");
  }
  printf("\n|");
  for (int i = 0; i < gantt_entries; i++) {
    for (int j = 0; j < (gantt_chart[i].end_time - gantt_chart[i].start_time) * 3 - 1; j++) {
      if (j == (gantt_chart[i].end_time - gantt_chart[i].start_time) * 3 / 2 - 1) {
        printf("%d", gantt_chart[i].pid);
      } else {
        printf(" ");
      }
    }
    printf("|");
  }
  printf("\n");
  for (int i = 0; i < gantt_entries; i++) {
    for (int j = 0; j < (gantt_chart[i].end_time - gantt_chart[i].start_time) * 3; j++) {
      printf("-");
    }
    printf(" ");
  }
  printf("\n");
  for (int i = 0; i < gantt_entries; i++) {
    printf("%-3d", gantt_chart[i].end_time);
    for (int j = 1; j < (gantt_chart[i].end_time - gantt_chart[i].start_time) * 3; j++) {
      printf(" ");
    }
  }
  printf("\n");
}


int main() {
  int n;

  printf("Enter the number of processes: ");
  scanf("%d", &n);

  struct Process proc[n];

  for (int i = 0; i < n; i++) {
    proc[i].pid = i + 1;
    printf("Enter arrival time for process %d: ", i + 1);
    scanf("%d", &proc[i].arrival);

    printf("Enter burst time for process %d: ", i + 1);
    scanf("%d", &proc[i].burst);

    printf("Enter priority for process %d: ", i + 1);
    scanf("%d", &proc[i].priority);

    proc[i].remaining= proc[i].burst;
  }

  sortByArrivalTime(proc, n);
  priorityScheduling(proc, n);

  print_table(proc, n);

  float avg_turnaround_time = 0, avg_waiting_time = 0;
  for (int i = 0; i < n; i++) {
    avg_turnaround_time += proc[i].turnaround;
    avg_waiting_time += proc[i].waiting;
  }
  avg_turnaround_time /= n;
  avg_waiting_time /= n;

  printf("\nAverage Turnaround Time: %.2f", avg_turnaround_time);
  printf("\nAverage Waiting Time: %.2f\n", avg_waiting_time);

  print_gantt_chart();
  return 0;
}
