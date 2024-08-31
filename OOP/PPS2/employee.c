#include <stdio.h>
#include <string.h>

struct Employee {
  int num;
  char name[100];
  int salary;
};

int main() {
  int count;
  printf("How many employee details entered :");
  scanf("%d", &count);
  struct Employee employees[count];
  struct Employee best;
  best.salary = 0;
  for (int i = 0; i < count; i++) {
    printf("Enter details of Employee%d\n", i + 1);
    printf("Employee No: ");
    scanf("%d", &employees[i].num);
    printf("Employee Name: ");
    scanf("\n");
    fgets(employees[i].name, 100, stdin);
    employees[i].name[strcspn(employees[i].name, "\n")] = '\0';
    printf("Salary: ");
    scanf("%d", &employees[i].salary);

    if (employees[i].salary > best.salary) {
      best.salary = employees[i].salary;
      best.num = employees[i].num;
      strcpy(best.name, employees[i].name);
    }
  }

  printf("Highest salary Employee Details\n");
  printf("Emp no\tName\tSalary\n");
  printf("%d\t%s\t%d", best.num, best.name, best.salary);
  return 0;
}
