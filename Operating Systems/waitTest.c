#include <stdio.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>

int main() {
  pid_t pid;
  int status;

  // Create a new process.
  pid = fork();

  if(pid < 0) {
    // Fork failed
    fprintf(stderr, "Fork failed\n");
    return 1;
  } else if (pid == 0) {
    // Child process
    printf("Child process: PID = %d\n", getpid());
    sleep(2); //Simulate some work in child process
    printf("Child process exiting\n");
    return 0; // Child process exit status
  } else {
    // Parent process
    printf("Parent process: PID = %d\n", getpid());

    // Wait for the child prcess to terminate
    pid_t child_pid = wait(&status);

    if (child_pid == -1) {
      perror("wait failed");
      return 1;
    }

    if (WIFEXITED(status)) {
      printf("Child process exited with status %d\n", WEXITSTATUS(status));
    } else {
      printf("Child process with PID %d did not exit normally\n", child_pid);
    }
  }

  return 0;
}
