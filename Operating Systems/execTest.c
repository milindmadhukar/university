#include <stdio.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>

int main() {
  pid_t pid;
  int status;

  pid = fork();

  if (pid < 0) {
    printf("Fork failed\n");
    return 1;
  } else if (pid == 0) {
    printf("Child process. PID = %d\n", getpid());
    char *args[] = {"ls", "-l", NULL};
    execvp("ls", args);

    perror("execvp failed");
    return 1;
  } else {
    printf("Parent process: PID = %d\n", getpid());

    pid_t child_pid = wait(&status);
    
    if (child_pid == -1) {
      perror("wait failed");
      return 1;
    }

    if (WIFEXITED(status)) {
      printf("Child process with PID %d exited with status %d\n", child_pid, WEXITSTATUS(status));
    } else {
      printf("Child process with PID %d did not exit normally\n", child_pid);
    }
  }

  return 0;
}
