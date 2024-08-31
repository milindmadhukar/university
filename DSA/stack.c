#include <stdio.h>
#define size 5

int stack[size];
int top=-1;

int pop() {
    if (top == -1) {
        printf("Stack Underflow. Cannot pop.\n");
        return 0;
    }
    int del = stack[top];
    top--;
    return del;
}

void push(int element) { 
    if (top == size - 1) {
        printf("Stack Overdlow. Cannot push.\n");
        return;
    }

    top++;
    stack[top] = element;

    return;
}

void display() {
    printf("Elements in the stack are: ");
    for(int i = 0; i <= top; i++) {
        printf("%d, ", stack[i]);
    }
    printf("\n");
}

int main() {
    int choice = 0;
    do {
        int element, del;
        printf("0.Exit\n1.Push\n2.Pop\n3.Display\nEnter your choice: ");
        scanf("%d", &choice);
        switch(choice) {
            case 1:
                printf("Enter element to push: ");
                scanf("%d", &element);
                push(element);
                break;
            case 2:
                del = pop();
                printf("Deleted element is: %d\n", del);
                break;
            case 3:
                display();

        }

    } while (choice != 0);

    return 0;
}

// https://pastecode.io/s/4fvmktjy 