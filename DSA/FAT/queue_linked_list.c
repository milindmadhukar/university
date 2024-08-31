// Implement the Enqueue & Dequeue operations of queue data structure using linked list.

#include <stdio.h>
#include <stdlib.h>

struct Node {
  int data;
  struct Node *next;
};

struct Node *create_node(int data) {
  struct Node *node = (struct Node *)malloc(sizeof(struct Node));
  node->data = data;
  node->next = NULL;
  return node;
}

struct Queue {
  struct Node *rear;
  struct Node *front;
};

void enqueue(struct Queue *q, int data) {
  struct Node *node = create_node(data);
  if (node == NULL) {
    printf("No memory left. Queue overflow. Cannot enqueue: %d\n", data);
  }

  if (q->rear == NULL) {
    q->rear = q->front = node;
    return;
  }
  q->rear->next = node;
  q->rear = node;
}

int dequeue(struct Queue *q) {
  if (q->front == NULL && q->rear == NULL) {
    printf("Queue underflow. Queue is empty.\n");
    return -1;
  }

  struct Node *node = q->front;
  int e = node->data;
  q->front = node->next;
  
  if(q->front == NULL) {
    q->rear = NULL;
  }

  free(node);
  return e;
}

void display(struct Queue *q) {
  struct Node *current_node = q->front;
  while (current_node != q->rear) {
    printf("%d ", current_node->data);
    current_node = current_node->next;
  }
  printf("%d", q->rear->data);
  printf("\n");
}

int main() {
  struct Queue *q = (struct Queue *)malloc(sizeof(struct Queue));
  q->rear = NULL;
  q->front = NULL;

  enqueue(q, 10);
  enqueue(q, 20);
  enqueue(q, 30);
  enqueue(q, 40);
  enqueue(q, 50);
  enqueue(q, 69);
  display(q);
  printf("We are dequeuing: %d\n", dequeue(q));
  printf("We are dequeuing: %d\n", dequeue(q));
  printf("We are dequeuing: %d\n", dequeue(q));
  printf("We are dequeuing: %d\n", dequeue(q));
  printf("We are dequeuing: %d\n", dequeue(q));
  printf("We are dequeuing: %d\n", dequeue(q));
}

