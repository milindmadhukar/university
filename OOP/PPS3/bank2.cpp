// 6. Suppose you are working on a project to create a simple banking system and you need to
// create a class hierarchy for different types of bank accounts. You want to create a base
// class called BankAccount that contains basic account information and methods that are
// common to all types of bank accounts. You also want to create a derived class called
// SavingsAccount that inherits from BankAccount and contains additional methods specific
// to savings accounts. Create a C++ code snippet for the above scenario that demonstrates
// inheritance. 


#include <iostream>
using namespace std;

class BankAccount {
protected:
    int accountNumber;
    string accountHolderName;
    double balance;
    double interestRate;
public:
    BankAccount(int accNum, string accHolderName, double bal, double intRate)
        : accountNumber(accNum), accountHolderName(accHolderName), balance(bal), interestRate(intRate) {}
    
    virtual void display() {
        cout << "Account number: " << accountNumber << endl;
        cout << "Account holder name: " << accountHolderName << endl;
        cout << "Balance: " << balance << endl;
        cout << "Interest rate: " << interestRate << "%" << endl;
    }
};

class SavingsAccount : public BankAccount {
private:
    double minimumBalance;
public:
    SavingsAccount(int accNum, string accHolderName, double bal, double intRate, double minBal)
        : BankAccount(accNum, accHolderName, bal, intRate), minimumBalance(minBal) {}
    
    void deposit(double amount) {
        balance += amount;
    }
    
    void withdraw(double amount) {
        if (balance - amount < minimumBalance) {
            cout << "Withdrawal failed. Minimum balance limit reached." << endl;
        } else {
            balance -= amount;
        }
    }
    
    void display() {
        cout << "Account holder name: " << accountHolderName << endl;
        cout << "Balance: " << balance << endl;
        cout << "Interest rate: " << interestRate << "%" << endl;
        cout << "Minimum balance: " << minimumBalance << endl;
        cout << "Account number: " << accountNumber << endl;
    }
};

int main() {
    SavingsAccount sa(12345, "Priya", 10500, 5, 3000);
    sa.display();
    
    cout << endl;
    
    sa.withdraw(2000);
    sa.display();
    
    cout << endl;
    
    sa.deposit(5000);
    sa.display();
    
    return 0;
}
