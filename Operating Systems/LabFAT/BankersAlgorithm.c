#include <stdbool.h>
#include <stdio.h>

int main() {

  int num_processes;
  printf("Enter the number of processes: ");
  scanf("%d", &num_processes);

  int num_resources;
  printf("Enter the number of resources: ");
  scanf("%d", &num_resources);

  int total_resources[num_resources];
  int available[num_resources];

  printf("Enter the total resources for %d resources: ", num_resources);

  for (int i = 0; i < num_resources; i++) {
    scanf("%d", &total_resources[i]);
    available[i] = total_resources[i];
  }

  int allocation[num_processes][num_resources];
  int max_need[num_processes][num_resources];

  for (int i = 0; i < num_processes; i++) {
    printf("Enter allocation resource values for Process %d: ", i + 1);
    for (int j = 0; j < num_resources; j++) {
      scanf("%d", &allocation[i][j]);
      available[j] -= allocation[i][j];
    }
  }

  printf("Available resources after allocation:\n");
  for (int i = 0; i < num_resources; i++) {
    printf("%d ", available[i]);
  }

  printf("\n");

  for (int i = 0; i < num_processes; i++) {
    printf("Enter maximum needed resource values for Process %d: ", i + 1);
    for (int j = 0; j < num_resources; j++) {
      scanf("%d", &max_need[i][j]);
    }
  }

  int remaining_needed[num_processes][num_resources];

  for (int i = 0; i < num_processes; i++) {
    for (int j = 0; j < num_resources; j++) {
      remaining_needed[i][j] = max_need[i][j] - allocation[i][j];
    }
  }

  int allocatedProcessCount = 0;
  bool isAllocated[num_processes];

  for (int i = 0; i < num_processes; i++) {
    isAllocated[i] = false;
  }

  int safeSequence[num_processes];

  while (allocatedProcessCount != num_processes) {
    bool foundAllocation = false;

    for (int i = 0; i < num_processes; i++) {
      if (isAllocated[i]) {
        printf("P%d is already allocated, skipping\n", i);
        continue;
      }

      printf("Checking for Process P%d\n", i);
      bool canAllocate = true;
      for (int j = 0; j < num_resources; j++) {
        if (available[j] < remaining_needed[i][j]) {
          canAllocate = false;
          break;
        }
      }

      if (canAllocate) {
        printf("Process %d can be allocated\n", i);
        foundAllocation = true;
        isAllocated[i] = true;
        safeSequence[allocatedProcessCount] = i;
        allocatedProcessCount += 1;

        for (int k = 0; k < num_resources; k++) {
          available[k] += allocation[i][k];
        }
      }
    }

    printf("Found alloc %d\n", foundAllocation);

    if (!foundAllocation) {
      printf("Cannot find a process to allocate.\n");
      break;
    }
  }

  if (allocatedProcessCount == num_processes) {
    printf("System is in a safe state.\nThe safe sequence is: \n");
    for (int i = 0; i < num_processes; i++) {
      printf("P%d -> ", safeSequence[i]);
    }
  } else {
    printf("System is in an unsafe state.\n");
  }

  return 0;
}
