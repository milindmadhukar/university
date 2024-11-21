#include <stdbool.h>
#include <stdio.h>

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

  int insertIdx = 0;

  for (int i = 0; i < no_of_items; i++) {
    if (isHit(frame_size, frames, items[i])) {
      printf("Hit!\n");
      hits++;
    } else {
      printf("Miss!\n");
      misses++;
      frames[insertIdx] = items[i];
      insertIdx = (insertIdx + 1) % frame_size;
    }

    display(frame_size, frames);
  }

  float hitRatio = (hits * 1.0f) / no_of_items;
  float missRatio = (misses * 1.0f) / no_of_items;

  printf("Hit Ratio: %.2f\n", hitRatio);
  printf("Miss Ratio: %.2f\n", missRatio);

  return 0;
}
