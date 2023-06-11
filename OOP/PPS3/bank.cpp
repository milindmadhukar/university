// 4. Write a C++ program to read and print employee salary details using
// multilevel inheritance. a. Create a class named employee to get and print the
// employee details like employee number, name and designation. b. Create a
// derived class named salary which derives the class employee in private mode,
// to get the employee complete information including employee number, name,
// designation, basic pay, hra, da, pf and to display the complete employee
// information including the net pay. c. Create a derived class bank_details
// which derives the class salary in private mode to get the complete employee
// details including his bank name, account number and to display the complete
// employee details like empno, name, designation, bp, hra, da, pf, net pay,
// account number. d. Create appropriate main method for the same.

#include <iostream>
#include <string>
using namespace std;

class Employee {
protected:
  int empNo;
  string empName;
  string empDesig;

public:
  void getEmployeeDetails() {
    cout << "enter employee no ";
    cin >> empNo;
    cout << "enter employee name ";
    cin >> empName;
    cout << "enter designation ";
    cin >> empDesig;
  }
  void displayEmployeeDetails() {
    cout << "Emp number:" << empNo << endl;
    cout << "Emp Name:" << empName << endl;
    cout << "Designation:" << empDesig << endl;
  }
};

class Salary : private Employee {
protected:
  double basicPay;
  double hra;
  double da;
  double pf;
  double netPay;

public:
  void getSalaryDetails() {
    getEmployeeDetails();
    cout << "enter hra, da, pf" << endl;
    cin >> hra;
    cin >> da;
    cin >> pf;
    cout << "enter basic pay" << endl;
    cin >> basicPay;
    netPay = basicPay + hra + da - pf;
  }
  void displaySalaryDetails() {
    displayEmployeeDetails();
    cout << "hra" << hra << endl;
    cout << "da" << da << endl;
    cout << "pf" << pf << endl;
    cout << "Net Pay" << netPay << endl;
  }
};

class BankDetails : private Salary {
private:
  string bankName;
  int accountNo;

public:
  void getBankDetails() {
    getSalaryDetails();
    cout << "Enter bank name ";
    cin >> bankName;
    cout << "Enter account number ";
    cin >> accountNo;
  }
  void displayBankDetails() {
    displaySalaryDetails();
    cout << "Bank Name: " << bankName << endl;
    cout << "Account Number: " << accountNo << endl;
  }
};

int main() {
  BankDetails bd;
  bd.getBankDetails();
  bd.displayBankDetails();
  return 0;
}
