#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <unistd.h>

int main() {
  pid_t pid;
  int status;

  pid = fork();

  if (pid < 0) {
    printf("Fork failed\n");
    return 1;
  } else if (pid == 0) {
    printf("Child process: PID = %d\n", getpid());
    sleep(2);
    printf("Child process exiting with status 42\n");
    exit(42);
  } else {
    // Parent process
    printf("Parent process: PID = %d\n", getpid());

    pid_t child_pid = wait(&status);

    if (child_pid == -1) {
      perror("wait failed");
      return 1;
    }

    if (WIFEXITED(status)) {
      printf("Child process with PID %d exited with status %d\n", child_pid,
             WEXITSTATUS(status));
    } else {
      printf("Child process with PID %d did not exit normally\n", child_pid);
    }
  }

  return 0;
}
