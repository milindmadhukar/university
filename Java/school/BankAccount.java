import java.util.*;

class BankAccount {
  Scanner sc = new Scanner(System.in);
  String DepositorName;
  long AccountNumber;
  String AccountType;
  double BalanceAmount;
  int amt;

  BankAccount(String dname, long accno, String accType, double balAmount) {
    DepositorName = dname;
    AccountNumber = accno;
    AccountType = accType;
    BalanceAmount = balAmount;
  }

  public static void main(String[] args) {
    System.out.println("USER 1 :");
    BankAccount acc1 = new BankAccount("Milind", 12324, "Savings", 10000);
    acc1.deposit();
    acc1.display();
    System.out.println("\nUSER 2 :");
    BankAccount acc2 = new BankAccount("Ash", 42314, "Current", 2000);
    acc2.withdraw();
    acc2.display();
  }

  void display() {
    System.out.println("\nDepositor Name : " + DepositorName);
    System.out.println("Account Number : " + AccountNumber);
    System.out.println("Account Type : " + AccountType);
    System.out.println("Balance : " + BalanceAmount);
  }

  void deposit() {
    System.out.print("Enter Amount To Deposit : ");
    amt = sc.nextInt();
    this.BalanceAmount += amt;
  }

  void withdraw() {
    System.out.print("Enter Amount To Withdraw : ");
    amt = sc.nextInt();
    if (BalanceAmount >= amt)
      this.BalanceAmount -= amt;
    else
      System.out.print("Insufficient Funds ! ");
  }
}
