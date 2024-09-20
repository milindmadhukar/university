#include <stdio.h>
#include <limits.h>

#define MAX_PROCESSES 100

struct Process {
    int id;
    int arrival_time;
    int burst_time;
    int priority;
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

void non_preemptive_priority(struct Process processes[], int n) {
    int current_time = 0;
    int completed = 0;
    int gantt_chart[MAX_PROCESSES][2];
    int gantt_size = 0;

    while (completed < n) {
        int highest_priority = -1;
        int highest_priority_index = -1;

        for (int i = 0; i < n; i++) {
            if (processes[i].arrival_time <= current_time && processes[i].completion_time == 0) {
                if (highest_priority == -1 || processes[i].priority < highest_priority) {
                    highest_priority = processes[i].priority;
                    highest_priority_index = i;
                }
            }
        }

        if (highest_priority_index == -1) {
            current_time++;
        } else {
            gantt_chart[gantt_size][0] = processes[highest_priority_index].id;
            gantt_chart[gantt_size][1] = current_time;
            gantt_size++;

            current_time += processes[highest_priority_index].burst_time;
            processes[highest_priority_index].completion_time = current_time;
            processes[highest_priority_index].turnaround_time = processes[highest_priority_index].completion_time - processes[highest_priority_index].arrival_time;
            processes[highest_priority_index].waiting_time = processes[highest_priority_index].turnaround_time - processes[highest_priority_index].burst_time;
            completed++;
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

        printf("Enter priority for process %d: ", i + 1);
        scanf("%d", &processes[i].priority);

        processes[i].id = i + 1;
        processes[i].completion_time = 0;
    }

    sort_by_arrival_time(processes, n);
    non_preemptive_priority(processes, n);

    printf("Process\tArrival Time\tBurst Time\tPriority\tCompletion Time\tTurnaround Time\tWaiting Time\n");
    for (int i = 0; i < n; i++) {
        printf("P%d\t%d\t\t%d\t\t%d\t\t%d\t\t%d\t\t%d\n", processes[i].id, processes[i].arrival_time, processes[i].burst_time,
               processes[i].priority, processes[i].completion_time, processes[i].turnaround_time, processes[i].waiting_time);
        avg_turnaround_time += processes[i].turnaround_time;
        avg_waiting_time += processes[i].waiting_time;
    }

    avg_turnaround_time /= n;
    avg_waiting_time /= n;

    printf("\nAverage Turnaround Time: %.2f\n", avg_turnaround_time);
    printf("Average Waiting Time: %.2f\n", avg_waiting_time);

    return 0;
}
