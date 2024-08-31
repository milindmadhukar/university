// Create a banking system to manage different types of bank accounts and perform transactions. Implement a solution using Java classes that demonstrates multiple inheritance using one base class as a normal class (BankAccount) and another as an interface (Transaction). Both the base and derived classes should override common methods.
//
// 1. Transaction (Interface):
//
// Create an interface Transaction with the following declarations:
//
// void deposit(double amount);
//
// void withdraw(double amount);
//
// 2. BankAccount (Base Class):
//
// BankAccount should be a normal class representing basic account information. It should have properties like accountNumber, accountHolder, balance, and accountType in private . 
//
// Implement the deposit() and withdraw() methods to perform basic banking transactions.
//
// Implement a method displayAccountInfo() to display account information.
//
// 3. SavingsAccount (Derived Class):
//
// SavingsAccount should extend the BankAccount class.
//
// Implement the deposit() and withdraw() methods specifically for savings accounts, considering withdrawal limits.
//
// Override the displayAccountInfo() method to display savings account-specific information.
//
// 4. CheckingAccount (Derived Class):
//
// CheckingAccount should also extend the BankAccount class.
//
// Implement the deposit() and withdraw() methods specifically for checking accounts, considering overdraft limits.
//
// Override the displayAccountInfo() method to display checking account-specific information.
//
// Now, create instances of both SavingsAccount and CheckingAccount and demonstrate dynamic method dispatch by invoking the deposit(), withdraw(), and displayAccountInfo() methods for each type of account.

interface Transaction {
  void deposit(double amount);

  void withdraw(double amount);
}

class BankAccount implements Transaction {
  private int accountNumber;
  private String accountHolder;
  private double balance;
  private String accountType;

  public BankAccount(int accountNumber, String accountHolder, double balance, String accountType) {
    this.accountNumber = accountNumber;
    this.accountHolder = accountHolder;
    this.balance = balance;
    this.accountType = accountType;
  }

  public void deposit(double amount) {
    this.balance += amount;
    System.out.println("Deposited " + amount + " to " + this.accountType + " account.");
  }

  public void withdraw(double amount) {
    this.balance -= amount;
    System.out.println("Withdrew " + amount + " from " + this.accountType + " account.");
  }

  public void displayAccountInfo() {
    System.out.println("Account Number: " + this.accountNumber);
    System.out.println("Account Holder: " + this.accountHolder);
    System.out.println("Account Balance: " + this.balance);
    System.out.println("Account Type: " + this.accountType);
  }
}

class SavingsAccount extends BankAccount implements Transaction {
  public SavingsAccount(int accountNumber, String accountHolder, double balance, String accountType) {
    super(accountNumber, accountHolder, balance, accountType);
  }

  public void deposit(double amount) {
    super.deposit(amount);
  }

  public void withdraw(double amount) {
    if (amount > 1000) {
      System.out.println("Withdrawal limit exceeded.");
    } else {
      super.withdraw(amount);
    }
  }

  public void displayAccountInfo() {
    System.out.println("Your savings account information:");
    super.displayAccountInfo();
  }
}

class CheckingAccount extends BankAccount implements Transaction {
  public CheckingAccount(int accountNumber, String accountHolder, double balance, String accountType) {
    super(accountNumber, accountHolder, balance, accountType);
  }

  public void deposit(double amount) {
    super.deposit(amount);
  }

  public void withdraw(double amount) {
    super.withdraw(amount);
  }

  public void displayAccountInfo() {
    System.out.println("Your checking account information:");
    super.displayAccountInfo();
  }
}

public class Excercise45 {
  public static void main(String[] args) {
    BankAccount savingsAccount = new SavingsAccount(123456, "Milind", 10000, "Savings");
    BankAccount checkingAccount = new CheckingAccount(654321, "Martin Garrix", 20000000L, "Checking");

    savingsAccount.deposit(1000);
    savingsAccount.withdraw(500);
    savingsAccount.displayAccountInfo();

    System.out.println();

    checkingAccount.deposit(100000);
    checkingAccount.withdraw(30000);
    checkingAccount.displayAccountInfo();
  }
}
