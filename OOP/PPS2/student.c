#include <stdio.h>

struct Student {
  int roll_no;
  char stud_name[100];
  char course[100];
};

void display_student(struct Student student) {
  printf("%d\n%s\n%s", student.roll_no, student.stud_name, student.course);
  return;
}

int main() {
  struct Student student;

  printf("Roll no: ");
  scanf("%d", &student.roll_no);
  printf("Name: ");
  scanf("%s", student.stud_name);
  printf("Course: ");
  scanf("%s", student.course);

  display_student(student);

  return 0;
}
