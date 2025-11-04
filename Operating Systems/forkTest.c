#include <stdio.h>
#include <unistd.h>
#include <sys/types.h>

int main() {
    pid_t pid;

    pid = fork();

    if (pid < 0) {
        fprintf(stderr, "Fork failed\n");
        return 1;
    } else if (pid == 0) {
        printf("I am the child process. PID: %d\n", getpid());
        printf("Child's parent PID: %d\n", getppid());
    } else {
        printf("I am the parent process. PID: %d\n", getpid());
        printf("Parent created a child process with PID: %d\n", pid);
    }

    return 0;
}

