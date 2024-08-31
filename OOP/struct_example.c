#include <stdio.h>

// Create a structure
struct myStructure {
  int myNum;
  char myLetter;
  char myString[30];
};

int main() {
  // Create a structure variable and assign values to it
  struct myStructure s1 = {13, 'B', "Some text"};
  struct myStructure *ptr = &s1;

  // Print values
  printf("%d %c %s\n", s1.myNum, s1.myLetter, s1.myString);
  printf("%d %c %s\n", ptr->myNum, ptr->myLetter, ptr->myString);

  return 0;
}
