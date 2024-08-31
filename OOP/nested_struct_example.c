// C program to implement
// the above approach
#include <stdio.h>
#include <string.h>

// Declaration of the
// dependent structure
struct Employee {
  int employee_id;
  char name[20];
  int salary;
};

// Declaration of the
// Outer structure
struct Organisation {
  char organisation_name[20];
  char org_number[20];

  // Dependent structure is used
  // as a member inside the main
  // structure for implementing
  // nested structure
  struct Employee emp;
};

// Driver code
int main() {
  // Structure variable
  struct Organisation org;

  // Print the size of organisation
  // structure
  printf("The size of structure organisation : %ld\n", sizeof(org));

  org.emp.employee_id = 101;
  strcpy(org.emp.name, "Robert");
  org.emp.salary = 400000;
  strcpy(org.organisation_name, "GeeksforGeeks");
  strcpy(org.org_number, "GFG123768");

  // Printing the details
  printf("Organisation Name : %s\n", org.organisation_name);
  printf("Organisation Number : %s\n", org.org_number);
  printf("Employee id : %d\n", org.emp.employee_id);
  printf("Employee name : %s\n", org.emp.name);
  printf("Employee Salary : %d\n", org.emp.salary);
}
