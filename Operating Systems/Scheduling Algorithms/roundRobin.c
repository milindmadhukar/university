#include <stdbool.h>
#include <stdio.h>

#define MAX_PROCESSES 100
#define MAX_TIMELINE 1000

struct GanttEntry {
    int pid;
    int start_time;
    int end_time;
};

struct GanttChart {
    struct GanttEntry entries[MAX_TIMELINE];
    int count;
};

struct GanttChart gantt_chart;

struct Process {
  int pid;
  int burst;
  int remaining;
  int arrival;
  int completion;
  int turnaround;
  int waiting;
};

void sortByArrival(struct Process proc[], int n) {
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

void roundRobinScheduling(struct Process proc[], int n, int quantum) {
    int currentTime = 0;
    int completed = 0;
    gantt_chart.count = 0;

    while (completed != n) {
        bool flag = false;

        for (int i = 0; i < n; i++) {
            if (proc[i].remaining > 0 && proc[i].arrival <= currentTime) {
                flag = true;

                int execution_time = (proc[i].remaining > quantum) ? quantum : proc[i].remaining;
                
                gantt_chart.entries[gantt_chart.count].pid = proc[i].pid;
                gantt_chart.entries[gantt_chart.count].start_time = currentTime;
                gantt_chart.entries[gantt_chart.count].end_time = currentTime + execution_time;
                gantt_chart.count++;

                currentTime += execution_time;
                proc[i].remaining -= execution_time;

                if (proc[i].remaining == 0) {
                    completed++;
                    proc[i].completion = currentTime;
                    proc[i].turnaround = proc[i].completion - proc[i].arrival;
                    proc[i].waiting = proc[i].turnaround - proc[i].burst;
                }
            }
        }

        if (!flag) {
            currentTime++;
        }
    }
}

void printProcessDetails(struct Process proc[], int n) {
  printf("Process\tBurst Time\tArrival Time\tCompletion Time\tTurnaround "
         "Time\tWaiting Time\n");
  for (int i = 0; i < n; i++) {
    printf("%d\t%d\t\t%d\t\t%d\t\t%d\t\t%d\n", proc[i].pid,
           proc[i].burst, proc[i].arrival, proc[i].completion,
           proc[i].turnaround, proc[i].waiting);
  }
}

void printAverages(struct Process proc[], int n) {
  float avg_turnaround_time = 0, avg_waiting_time = 0;

  for (int i = 0; i < n; i++) {
    avg_turnaround_time += proc[i].turnaround;
    avg_waiting_time += proc[i].waiting;
  }

  avg_turnaround_time /= n;
  avg_waiting_time /= n;

  printf("\nAverage Turnaround Time: %.2f\n", avg_turnaround_time);
  printf("Average Waiting Time: %.2f\n", avg_waiting_time);
}


void drawGanttChart() {
    printf("\nGantt Chart:\n");
    
    // Print the timeline
    printf("  ");
    for (int i = 0; i < gantt_chart.entries[gantt_chart.count - 1].end_time; i++) {
        printf("--");
    }
    printf("\n");

    // Print the process IDs
    printf(" |");
    for (int i = 0; i < gantt_chart.count; i++) {
        int duration = gantt_chart.entries[i].end_time - gantt_chart.entries[i].start_time;
        for (int j = 0; j < duration; j++) {
            printf("P%d", gantt_chart.entries[i].pid);
        }
        printf("|");
    }
    printf("\n");

    // Print the timeline
    printf("  ");
    for (int i = 0; i < gantt_chart.entries[gantt_chart.count - 1].end_time; i++) {
        printf("--");
    }
    printf("\n");

    // Print the time markers
    printf("0");
    for (int i = 0; i < gantt_chart.count; i++) {
        int duration = gantt_chart.entries[i].end_time - gantt_chart.entries[i].start_time;
        for (int j = 0; j < duration; j++) {
            printf("  ");
        }
        printf("%d", gantt_chart.entries[i].end_time);
    }
    printf("\n");
}

int main() {
  int n, quantum;

  printf("Enter the number of processes: ");
  scanf("%d", &n);

  printf("Enter the time quantum: ");
  scanf("%d", &quantum);

  struct Process proc[n];

  for (int i = 0; i < n; i++) {
    proc[i].pid = i + 1;
    printf("Enter arrival time for process %d: ", i + 1);
    scanf("%d", &proc[i].arrival);
    printf("Enter burst time for process %d: ", i + 1);
    scanf("%d", &proc[i].burst);
    proc[i].remaining = proc[i].burst;
  }

  sortByArrival(proc, n);

  roundRobinScheduling(proc, n, quantum);

  printf("\nRound Robin Scheduling Results:\n");
  printProcessDetails(proc, n);

  printAverages(proc, n);
    drawGanttChart();

    return 0;
}
