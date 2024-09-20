#include <limits.h>
#include <stdio.h>

#define MAX_PROCESSES 100

struct Process {
  int id;
  int arrival_time;
  int burst_time;
  int remaining_time;
  int completion_time;
  int turnaround_time;
  int waiting_time;
};

void swap(struct Process *a, struct Process *b) {
  struct Process temp = *a;
  *a = *b;
  *b = temp;
}

void sort_by_arrival_time(struct Process processes[], int n) {
  for (int i = 0; i < n - 1; i++) {
    for (int j = 0; j < n - i - 1; j++) {
      if (processes[j].arrival_time > processes[j + 1].arrival_time) {
        swap(&processes[j], &processes[j + 1]);
      }
    }
  }
}

void psjf(struct Process processes[], int n) {
  int current_time = 0;
  int completed = 0;
  int gantt_chart[MAX_PROCESSES * 2][2];
  int gantt_size = 0;

  while (completed < n) {
    int shortest_job = -1;
    int shortest_time = INT_MAX;

    for (int i = 0; i < n; i++) {
      if (processes[i].arrival_time <= current_time &&
          processes[i].remaining_time > 0) {
        if (processes[i].remaining_time < shortest_time) {
          shortest_job = i;
          shortest_time = processes[i].remaining_time;
        }
      }
    }

    if (shortest_job == -1) {
      current_time++;
    } else {
      if (gantt_size == 0 ||
          gantt_chart[gantt_size - 1][0] != processes[shortest_job].id) {
        gantt_chart[gantt_size][0] = processes[shortest_job].id;
        gantt_chart[gantt_size][1] = current_time;
        gantt_size++;
      }

      processes[shortest_job].remaining_time--;
      current_time++;

      if (processes[shortest_job].remaining_time == 0) {
        completed++;
        processes[shortest_job].completion_time = current_time;
        processes[shortest_job].turnaround_time =
            processes[shortest_job].completion_time -
            processes[shortest_job].arrival_time;
        processes[shortest_job].waiting_time =
            processes[shortest_job].turnaround_time -
            processes[shortest_job].burst_time;
      }
    }
  }

  // Add final time to Gantt chart
  gantt_chart[gantt_size][0] = -1;
  gantt_chart[gantt_size][1] = current_time;
  gantt_size++;

  // Print Gantt chart
  printf("Gantt Chart:\n");
  for (int i = 0; i < gantt_size - 1; i++) {
    printf("| P%d ", gantt_chart[i][0]);
  }
  printf("|\n");
  for (int i = 0; i < gantt_size; i++) {
    printf("%d    ", gantt_chart[i][1]);
  }
  printf("\n\n");
}

int main() {
  int n;
  struct Process processes[MAX_PROCESSES];
  float avg_turnaround_time = 0, avg_waiting_time = 0;

  printf("Enter the number of processes: ");
  scanf("%d", &n);

  for (int i = 0; i < n; i++) {
    printf("Enter arrival time for process %d: ", i + 1);
    scanf("%d", &processes[i].arrival_time);
    printf("Enter burst time for process %d: ", i + 1);
    scanf("%d", &processes[i].burst_time);
    processes[i].id = i + 1;
    processes[i].remaining_time = processes[i].burst_time;
  }

  sort_by_arrival_time(processes, n);
  psjf(processes, n);

  printf("Process\tArrival Time\tBurst Time\tCompletion Time\tTurnaround "
         "Time\tWaiting Time\n");
  for (int i = 0; i < n; i++) {
    printf("P%d\t%d\t\t%d\t\t%d\t\t%d\t\t%d\n", processes[i].id,
           processes[i].arrival_time, processes[i].burst_time,
           processes[i].completion_time, processes[i].turnaround_time,
           processes[i].waiting_time);
    avg_turnaround_time += processes[i].turnaround_time;
    avg_waiting_time += processes[i].waiting_time;
  }

  avg_turnaround_time /= n;
  avg_waiting_time /= n;

  printf("\nAverage Turnaround Time: %.2f\n", avg_turnaround_time);
  printf("Average Waiting Time: %.2f\n", avg_waiting_time);

  return 0;
}
