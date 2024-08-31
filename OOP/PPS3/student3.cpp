// 9. Write a Program to perform the following scenario. Define a class student
// with rollno as member and getdata() and putdata() as member functions.
// .Define another class test that inherit the class student, this class test
// has data members as marks in the subject 1 and subject 2 with member
// functions getmark() and putmark(). Define a class Grade with data member
// grade and a member function to display the grade. Define another class result
// that inherit the classes test and Grade with data member total and member
// function to compute the total marks along with the grade. Note make use of
// the access specifier Private for Grade class

#include <iostream>

class Student {
protected:
  int rollno;

public:
  void getData() {
    std::cout << "Enter rollno: ";
    std::cin >> rollno;
  }
  void putData() { std::cout << "RollNO: " << rollno << std::endl; }
};

class Test : public Student {
protected:
  int marks1, marks2;

public:
  void getMarks() {
    std::cout << "Enter marks1 and marks2: " << std::endl;
    std::cin >> marks1;
    std::cin >> marks2;
  }
  void putMarks() {
    std::cout << "Marks1: " << marks1 << std::endl;
    std::cout << "Marks2: " << marks2 << std::endl;
  }
};

class Grade : public Test {
private:
  char grade;

public:
  void setGrade() {
    std::cout << "Enter Grade ";
    std::cin >> grade;
  }
  void displayGrade() { std::cout << "Grade" << grade << std::endl; }
};

class Result : public Grade {
private:
  int total;

public:
  void computeTotal() { total = marks1 + marks2; }
  void displayResult() {
    putData();
    putMarks();
    displayGrade();
    std::cout << "Total: " << total << std::endl;
  }
};

int main() {
  Result r;
  r.getData();
  r.getMarks();
  r.setGrade();
  r.computeTotal();
  r.displayResult();
  return 0;
}
