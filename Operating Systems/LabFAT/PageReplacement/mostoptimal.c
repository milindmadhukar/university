#include <stdbool.h>
#include <stdio.h>
#include <limits.h>

void display(int frame_size, int frames[]) {
  for (int i = 0; i < frame_size; i++) {
    if (frames[i] == -1) {
      printf("[ ] ");
    } else {
      printf("[%d] ", frames[i]);
    }
  }
  printf("\n");
}

bool isHit(int frame_size, int frames[], int page) {
  for (int i = 0; i < frame_size; i++) {
    if (frames[i] == page) {
      return true;
    }
  }
  return false;
}

int findIndex(int start_loc, int no_of_items, int items[], int item) {
  for(int i = start_loc; i < no_of_items; i++) {
    if(item == items[i]) {
      return i;
    }
  }
  return INT_MAX;
}

int main() {

  int frame_size;
  printf("Enter the size of frames: ");
  scanf("%d", &frame_size);

  int frames[frame_size];

  int no_of_items;
  printf("Enter the number of items: ");
  scanf("%d", &no_of_items);

  int items[no_of_items];
  printf("Enter the pages: ");
  for (int i = 0; i < no_of_items; i++) {
    scanf("%d", &items[i]);
  }

  for (int i = 0; i < frame_size; i++) {
    frames[i] = -1;
  }

  int hits = 0;
  int misses = 0;

  for (int i = 0; i < no_of_items; i++) {
    if (isHit(frame_size, frames, items[i])) {
      printf("Hit!\n");
      hits++;
    } else {
      printf("Miss!\n");
      misses++;

      int maxItemIdx = INT_MIN;
      int idxToReplace = 0;
      for(int k = 0; k < frame_size; k++) {
        int nextItemIdx = findIndex(i + 1, no_of_items, items, frames[k]);
        if (nextItemIdx > maxItemIdx) {
          maxItemIdx = nextItemIdx;
          idxToReplace = k;
        }
      }
      frames[idxToReplace] = items[i];
    }

    display(frame_size, frames);
  }

  float hitRatio = (hits * 1.0f) / no_of_items;
  float missRatio = (misses * 1.0f) / no_of_items;

  printf("Hit Ratio: %.2f\n", hitRatio);
  printf("Miss Ratio: %.2f\n", missRatio);

  return 0;
}
