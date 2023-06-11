// Implement the Enqueue, Dequeue and display operations of queue data structure using arrays

#include <stdio.h>
#define size 5

int queue[size];
int front=-1, rear=-1;

void enqueue(int item){
    if (rear == size - 1){
        printf("Cannot enqueue, Queue Overflow.\n");
        return;
    }
    rear++;
    queue[rear] = item;
}

int dequeue() {
    if(front == rear || front == size-1) {
        printf("Cannot dequeue, Queue Underflow.\n");
        return 0;
    }

    front++;
    int del = queue[front];
    return del;
}

void display() {
    printf("Elements in the queue are: ");
    for(int i = front; i <= rear; i++) {
        printf("%d, ", queue[i]);
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
