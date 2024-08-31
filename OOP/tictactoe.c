#include <stdio.h>

char board[3][3];
int playing = 1;

void getinput(char player) {
  int inputRecieved = 0;
  while (!inputRecieved) {
    printf("It is %c's turn\n", player);
    int row, col;
    printf("Enter row and col to place X: (row col)");
    scanf("%d %d", &row, &col);
    if (board[row][col] == 'X' || board[row][col] == 'O') {
      printf("You cannot place there.\n");
    } else {
      board[row][col] = player;
      inputRecieved = 1;
    }
  }
}

void display() {
  printf("\n-------------\n");
  for (int r = 0; r < 3; r++) {
    printf("|");
    for (int c = 0; c < 3; c++) {
      printf(" %c |", board[r][c]);
    }
    printf("\n-------------\n");
  }
}

void check_winner() {

  for (int i = 0; i < 3; i++) {
    // Checking rows
    if ((board[i][0] == board[i][1] && board[i][1] == board[i][2] &&
         board[i][0] != '_') ||
        (board[0][i] == board[1][i] && board[1][i] == board[2][i] &&
         board[0][i] != '_')) {
      printf("%c won the game!", board[i][0]);
      playing = 0;
    }
  }

  if ((board[0][0] == board[1][1] && board[1][1] == board[2][2] &&
       board[0][0] != '-') ||
      (board[0][2] == board[1][1] && board[1][1] == board[2][0] &&
       board[0][2] != '_')) {
    printf("%c won the game!", board[0][0]);
    playing = 0;
  }

  int count = 0;
  for (int r = 0; r < 3; r++) {
    for (int c = 0; c < 3; c++) {
      if (board[r][c] == 'X' || board[r][c] == 'O')
        count++;
    }
  }

  if (count == 9) {
    printf("its a draw!");
    playing = 0;
  }
}

int main() {
  for (int r = 0; r < 3; r++) {
    for (int c = 0; c < 3; c++)
      board[r][c] = '_';
  }
  display();
  while (1) {
    getinput('X');
    display();
    check_winner();
    if (!playing)
      break;
    getinput('O');
    display();
    if (!playing)
      break;
    check_winner();
  }
}
