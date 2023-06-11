#include <stdio.h>
#define size 5

int cqueue[size];
int front=-1, rear=-1;

void enqueue(int item){
    if ((rear + 1) % size == front) {
        printf("Cannot enqueue, Queue Overflow.\n");
        return;
    }
    if (rear == -1 && front == -1) {
        rear = 0;
        front = 0;
    }
    else {
        rear =  (rear + 1) % size;
    }
    cqueue[rear] = item;
}

int dequeue() {
    int del = 0;
    if(rear == -1 && front == -1) {
        printf("Cannot dequeue, Queue Underflow.\n");
        return 0;
    }

    if (front == rear) { 
        front = -1;
        rear = -1;
    }
    else {
        del = cqueue[front];
        front = (front + 1) % size;
    }

    
    return del;
}

void display() {
  printf("Front of Queue: %d\nRear of Queue: %d\n", front, rear);
    printf("Elements in the Cqueue are: ");
    for(int i = 0; i < 5; i++) {
        printf("%d, ", cqueue[i]);
    }
    printf("\n");
}

int main(){
    int choice = 0;
    do {
        int element, del;
        printf("0.Exit\n1.Enqueue\n2.Dequeue\n3.Display\nEnter your choice: ");
        scanf("%d", &choice);
        switch(choice) {
            case 1:
                printf("Enter element to enqueue: ");
                scanf("%d", &element);
                enqueue(element);
                break;
            case 2:
                del = dequeue();
                printf("Deleted element is: %d\n", del);
                break;
            case 3:
                display();

        }

    } while (choice != 0);


    return 0;
}

// https://pastecode.io/s/eqata92q
