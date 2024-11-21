#include <limits.h>
#include <stdbool.h>
#include <stdio.h>

#define MAX_PAGES 100

typedef struct {
  int page_number;
  int last_used;
} Page;

bool page_exists(Page *memory, int page_size, int page, int current_time) {
  for (int i = 0; i < page_size; i++) {
    if (memory[i].page_number == page) {
      memory[i].last_used = current_time;
      return true;
    }
  }
  return false;
}

int find_lru_page(Page *memory, int page_size) {
  int lru_index = 0;
  int min_time = INT_MAX;

  for (int i = 0; i < page_size; i++) {
    if (memory[i].last_used < min_time) {
      min_time = memory[i].last_used;
      lru_index = i;
    }
  }

  return lru_index;
}

void display_memory(Page *memory, int page_size) {
  printf("Memory: ");
  for (int i = 0; i < page_size; i++) {
    if (memory[i].page_number == -1) {
      printf("[ ] ");
    } else {
      printf("[%d] ", memory[i].page_number);
    }
  }
  printf("\n");
}

int main() {
  int page_size, num_items;
  Page memory[MAX_PAGES];
  int items[MAX_PAGES];
  int hits = 0, misses = 0;
  int current_time = 0;

  printf("Enter page size: ");
  scanf("%d", &page_size);

  printf("Enter number of items to be inserted: ");
  scanf("%d", &num_items);

  printf("Enter the items to be inserted:\n");
  for (int i = 0; i < num_items; i++) {
    scanf("%d", &items[i]);
  }

  for (int i = 0; i < page_size; i++) {
    memory[i].page_number = -1;
    memory[i].last_used = -1;
  }

  for (int i = 0; i < num_items; i++) {
    printf("\nInserting %d:\n", items[i]);

    if (page_exists(memory, page_size, items[i], current_time)) {
      printf("Hit!\n");
      hits++;
    } else {
      printf("Miss!\n");
      misses++;

      int replace_index = -1;
      for (int j = 0; j < page_size; j++) {
        if (memory[j].page_number == -1) {
          replace_index = j;
          break;
        }
      }

      if (replace_index == -1) {
        replace_index = find_lru_page(memory, page_size);
      }

      memory[replace_index].page_number = items[i];
      memory[replace_index].last_used = current_time;
    }

    display_memory(memory, page_size);
    current_time++;
  }

  float hit_ratio = (float)hits / num_items;
  float miss_ratio = (float)misses / num_items;

  printf("\nFinal Statistics:\n");
  printf("Hits: %d\n", hits);
  printf("Misses: %d\n", misses);
  printf("Hit Ratio: %.2f\n", hit_ratio);
  printf("Miss Ratio: %.2f\n", miss_ratio);

  return 0;
}
