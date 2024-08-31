#include <stdio.h>
#include <stdlib.h>

struct QNode {
  int data;
  struct QNode *next;
};

struct Queue {
  struct QNode *front, *rear;
};

void enqueue(struct Queue *q, int element) {
  struct QNode *node = (struct QNode *)malloc(sizeof(struct QNode));
  node->data = element;
  node->next = NULL;

  if (q->rear == NULL) {
    q->front = q->rear = node;
    return;
  }

  q->rear->next = node;
  q->rear = node;
}

int dequeue(struct Queue *q) {
  if (q->front == NULL) {
    printf("Queue underflow");
    return -1;
  }

  struct QNode *node_to_remove = q->front;
  q->front = q->front->next;

  if (q->front == NULL)
    q->rear = NULL;

  int e = node_to_remove->data;

  free(node_to_remove);

  return e;
}

void display(struct Queue *queue) {
  struct QNode *current = queue -> front;
  while (current != NULL) {
    printf("%d ", current -> data);
    current = current -> next;
  }
  printf("\n");
}

int main() {

  struct Queue *queue = (struct Queue *)malloc(sizeof(struct Queue));

  enqueue(queue, 10);
  enqueue(queue, 20);
  enqueue(queue, 30);
  int e =dequeue(queue);
  printf("Element removed is: %d\n", e);
  enqueue(queue, 40);
  display(queue);
  dequeue(queue);
  dequeue(queue);
  dequeue(queue);
  dequeue(queue);

  return 0;
}
