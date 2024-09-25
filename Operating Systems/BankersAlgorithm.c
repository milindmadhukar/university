#include <stdbool.h>
#include <stdio.h>

bool all_finished(bool is_allocated[], int num_processes) {
  for (int i = 0; i < num_processes; i++) {
    if (!is_allocated[i]) {
      return false;
    }
  }
  return true;
}

int main() {
  int num_processes, num_resources;
  printf("Enter the number of processes: ");
  scanf("%d", &num_processes);
  printf("Enter the number of resources: ");
  scanf("%d", &num_resources);

  int allocation[num_processes][num_resources];
  int max[num_processes][num_resources];

  for (int i = 0; i < num_processes; i++) {
    for (int j = 0; j < num_resources; j++) {
      printf("Enter the allocation for process P%d and resource R%d: ", i,
             j + 1);
      scanf("%d", &allocation[i][j]);
    }

    for (int j = 0; j < num_resources; j++) {
      printf("Enter the maximum for process P%d and resource R%d: ", i, j + 1);
      scanf("%d", &max[i][j]);
    }
  }

  int available[num_resources];

  for (int i = 0; i < num_resources; i++) {
    printf("Enter the available instances for resource R%d: ", i);
    scanf("%d", &available[i]);

    for (int j = 0; j < num_processes; j++) {
      available[i] -= allocation[j][i];
    }
  }

  int resource_available_status[num_resources];

  for (int i = 0; i < num_resources; i++) {
    resource_available_status[i] = available[i];
  }

  int need[num_processes][num_resources];

  printf("Resources Needed.\n");
  for (int i = 0; i < num_resources; i++) {
    printf("R%d\t", i+1);
  }
  printf("\n");

  for (int i = 0; i < num_processes; i++) {
    for (int j = 0; j < num_resources; j++) {
      need[i][j] = max[i][j] - allocation[i][j];
      printf("%d\t", need[i][j]);
    }
    printf("\n");
  }

  bool is_allocated[num_processes];
  for (int i = 0; i < num_processes; i++) {
    is_allocated[i] = false;
  }

  int sequence[num_processes];
  int sequence_idx = 0;

  while (!all_finished(is_allocated, num_processes)) {
    bool found = false;
    for (int i = 0; i < num_processes; i++) {
      if (!is_allocated[i]) {
        bool can_finish = true;
        for (int j = 0; j < num_resources; j++) {
          if (need[i][j] > resource_available_status[j]) {
            can_finish = false;
            break;
          }
        }

        if (can_finish) {
          for (int j = 0; j < num_resources; j++) {
            resource_available_status[j] += allocation[i][j];
          }
          is_allocated[i] = true;
          sequence[sequence_idx++] = i;
          found = true;
        }
      }
    }

    if (!found) {
      printf("The system is in an unsafe state\n");
      return 0;
    }
  }

  printf("The system is in a safe state\n");
  printf("The safe sequence is: ");
  for (int i = 0; i < num_processes; i++) {
    printf("P%d ", sequence[i]);
  }
  printf("\n");
}
