#include <stdio.h>
#include <stdbool.h>

#define MAX_PAGES 100

bool page_exists(int* memory, int page_size, int page) {
    for (int i = 0; i < page_size; i++) {
        if (memory[i] == page) {
            return true;
        }
    }
    return false;
}

void display_memory(int* memory, int page_size) {
    printf("Memory: ");
    for (int i = 0; i < page_size; i++) {
        if (memory[i] == -1) {
            printf("[ ] ");
        } else {
            printf("[%d] ", memory[i]);
        }
    }
    printf("\n");
}

int main() {
    int page_size, num_items;
    int memory[MAX_PAGES];
    int items[MAX_PAGES];
    int hits = 0, misses = 0;
    int insert_index = 0;

    printf("Enter page size: ");
    scanf("%d", &page_size);

    printf("Enter number of items to be inserted: ");
    scanf("%d", &num_items);

    printf("Enter the items to be inserted:\n");
    for (int i = 0; i < num_items; i++) {
        scanf("%d", &items[i]);
    }

    for (int i = 0; i < page_size; i++) {
        memory[i] = -1;
    }

    for (int i = 0; i < num_items; i++) {
        printf("\nInserting %d:\n", items[i]);

        if (page_exists(memory, page_size, items[i])) {
            printf("Hit!\n");
            hits++;
        } else {
            printf("Miss!\n");
            misses++;
            memory[insert_index] = items[i];
            insert_index = (insert_index + 1) % page_size;
        }

        display_memory(memory, page_size);
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
