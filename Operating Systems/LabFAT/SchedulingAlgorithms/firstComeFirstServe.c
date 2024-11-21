#include <stdio.h>

typedef struct {
  int processID;
  int arrivalTime;
  int burstTime;
  int completionTime;
  int turnAroundTime;
  int waitingTime;
} Process;

void swap(Process *a, Process *b) {
  Process temp = *a;
  *a = *b;
  *b = temp;
}

// Selection sort
void sortByArrivalTime(Process processes[], int n) {
  for (int i = 0; i < n - 1; i++) {
    for (int j = i + 1; j < n; j++) {
      if (processes[i].arrivalTime > processes[j].arrivalTime) {
        swap(&processes[i], &processes[j]);
      }
    }
  }
}

void findCompletionTime(Process processes[], int n) {
  int currentTime = 0;
  for (int i = 0; i < n; i++) {
    if (currentTime < processes[i].arrivalTime) {
      currentTime = processes[i].arrivalTime;
    }
    processes[i].completionTime = currentTime + processes[i].burstTime;
    currentTime = processes[i].completionTime;
  }
}

void findTurnAroundTime(Process processes[], int n) {
  for (int i = 0; i < n; i++) {
    processes[i].turnAroundTime =
        processes[i].completionTime - processes[i].arrivalTime;
  }
}

void findWaitingTime(Process processes[], int n) {
  for (int i = 0; i < n; i++) {
    processes[i].waitingTime =
        processes[i].turnAroundTime - processes[i].burstTime;
  }
}

void calculateTimes(Process processes[], int n) {
  sortByArrivalTime(processes, n);
  findCompletionTime(processes, n);
  findTurnAroundTime(processes, n);
  findWaitingTime(processes, n);
}

void printProcesses(Process processes[], int n) {
  printf("ProcessID\t\t\tArrival\t\t\tBurst\t\t\tCompletion\t\t\tTurnaround\t\t"
         "\tWaiting\n");
  for (int i = 0; i < n; i++) {
    printf("%d\t\t\t\t%d\t\t\t\t\t%d\t\t\t\t%d\t\t\t\t%d\t\t\t\t%d\n",
           processes[i].processID, processes[i].arrivalTime,
           processes[i].burstTime, processes[i].completionTime,
           processes[i].turnAroundTime, processes[i].waitingTime);
  }
}

void printGanttChart(Process processes[], int n) {
  printf("\nGantt Chart:\n");
  printf("0");
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < processes[i].burstTime; j++) {
      printf("-");
    }
    printf("%d", processes[i].completionTime);
  }
  printf("\n");

  for (int i = 0; i < n; i++) {
    printf("|");
    for (int j = 0; j < processes[i].burstTime - 1; j++) {
      printf(" ");
    }
    printf("P%d", processes[i].processID);
    for (int j = 0; j < processes[i].burstTime - 1; j++) {
      printf(" ");
    }
  }
  printf("|\n");
}

int main() {
  int n;
  printf("Enter the number of processes: ");
  scanf("%d", &n);
  Process processes[n];
  for (int i = 0; i < n; i++) {
    processes[i].processID = i + 1;
    printf("Enter the arrival time of process %d: ", i + 1);
    scanf("%d", &processes[i].arrivalTime);
    printf("Enter the burst time of process %d: ", i + 1);
    scanf("%d", &processes[i].burstTime);
  }
  calculateTimes(processes, n);
  printProcesses(processes, n);
  printGanttChart(processes, n);
  return 0;
}
