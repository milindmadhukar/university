// 5. Use hierarchical inheritance to implement a student database that will be
// composed of classes Student, UnderGraduate, and PostGraduate. • The base
// class ‘Student’ will have a data member Name, Id and Age. Getstu() and
// Putstu() methods will ask the user to enter the details of the student and
// display the same. • In derived class, UnderGraduate will have the data member
// UGCourses to specify the number of courses offered. GetUGCourses() and
// PetUGCourses() methods will ask the user to enter the number of courses and
// display the same. • In derived class, PostGraduate will have the data member
// PGCourses to specify the number of courses offered. GetPGCourses() and
// display the same.
// PetPGCourses() methods will ask the user to enter the number of courses and

#include <iostream>

class Student {
protected:
  std::string Name;
  int Id;
  int Age;

public:
  void Getstu() {
    std::cout << "Enter the Name:";
    std::cin >> Name;
    std::cout << "Enter the ID:";
    std::cin >> Id;
    std::cout << "Enter the Age:";
    std::cin >> Age;
  }
  void Putstu() {
    std::cout << "Name: " << Name << std::endl;
    std::cout << "ID: " << Id << std::endl;
    std::cout << "Age: " << Age << std::endl;
  }
};

class UnderGraduate : public Student {
protected:
  int UGCourses;

public:
  void GetUGCourses() {
    std::cout << "Enter the Number of UG courses offered: ";
    std::cin >> UGCourses;
  }
  void PutUGCourses() {
    std::cout << "Number of UG courses offered: " << UGCourses << std::endl;
  }
};

class PostGraduate : public Student {
protected:
  int PGCourses;

public:
  void GetPGCourses() {
    std::cout << "Enter the Number of PG courses offered: ";
    std::cin >> PGCourses;
  }
  void PutPGCourses() {
    std::cout << "Number of PG courses offered: " << PGCourses << std::endl;
  }
};

int main() {
  UnderGraduate u;
  PostGraduate p;

  u.Getstu();
  u.GetUGCourses();
  p.GetPGCourses();

  std::cout << std::endl << "Details of the Student:" << std::endl;
  u.Putstu();
  u.PutUGCourses();
  p.PutPGCourses();

  return 0;
}
