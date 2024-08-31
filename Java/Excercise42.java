// 1.  A bank has three types of customers: savings account customers, checking account customers, and loan account customers.
//
// Create a base class called Customer and store all the basic details of the customer, such as name, address, and mobile number. In the base class, create a display() method to display the details of the customer. Then, create three derived classes for the three types of customers: SavingsAccount, CheckingAccount, and LoanAccount.
// In the SavingsAccount class, create a method to check the account balance and calculate the interest rate. The interest rate should be fixed with a withdrawal limit. Create two functions: one to check the balance and give a warning message if the balance is less than 5000, and the other to override the display() method from the base class to display the details of the account.
// In the CheckingAccount class, create a monthfeecal() method to calculate the monthly fee from the customer. This fee can be reduced from the account balance at the end of every month. The monthfeecal() method should override the display() method from the base class to display the details of the account.
// In the LoanAccount class, every month, the loan amount will be recovered from the savings account of the customer. The display() method should override the display() method from the base class to display the details of the account.
// In the main method, the details of the customer should be accessed based on the account number if the account start with SV121212 then it be saving account similar the account number can be classified . The appropriate class object should then be invoked.
 
import java.util.Scanner;

class Customer {
  public String name, address, mobile_no;

  public Customer(String name, String address, String mobile_no) {
    this.name = name;
    this.address = address;
    this.mobile_no = mobile_no;
  }

  public void display() {
    System.out.println("Name: " + name);
    System.out.println("Address: " + address);
    System.out.println("Mobile No: " + mobile_no);
  }
}

class SavingsAccount extends Customer {

  public double balance;
  public double interest_rate;
  public double withdrawal_limit;

  public SavingsAccount(String name, String address, String mobile_no, double balance, double interest_rate,
      double withdrawal_limit) {
    super(name, address, mobile_no);
    this.balance = balance;
    this.interest_rate = interest_rate;
    this.withdrawal_limit = withdrawal_limit;
  }

  @Override
  public void display() {
    System.out.println("Name: " + name);
    System.out.println("Address: " + address);
    System.out.println("Mobile No: " + mobile_no);
    System.out.println("Balance: " + balance);
    System.out.println("Interest Rate: " + interest_rate);
    System.out.println("Withdrawal Limit: " + withdrawal_limit);
  }

  public void checkBalance() {
    if (balance < 5000) {
      System.out.println("Balance is less than 5000");
    }
  }

  public void calculateInterest() {
    double interest = balance * interest_rate;
    System.out.println("Interest: " + interest);
  }
}

class CheckingAccount extends Customer {

  public double balance;
  public double monthly_fee;

  public CheckingAccount(String name, String address, String mobile_no, double balance, double monthly_fee) {
    super(name, address, mobile_no);
    this.balance = balance;
    this.monthly_fee = monthly_fee;
  }

  @Override
  public void display() {
    System.out.println("Name: " + name);
    System.out.println("Address: " + address);
    System.out.println("Mobile No: " + mobile_no);
    System.out.println("Balance: " + balance);
    System.out.println("Monthly Fee: " + monthly_fee);
  }

  public void monthfeecal() {
    double fee = monthly_fee;
    System.out.println("Monthly Fee: " + fee);
  }
}

class LoanAccount extends SavingsAccount {

  double deduction;

  public LoanAccount(String name, String address, String mobile_no, double balance, double interest_rate,
      double withdrawal_limit, double deduction) {
    super(name, address, mobile_no, balance, interest_rate, withdrawal_limit);
    this.deduction = deduction;
  }

  void deduct_balance() {
    balance -= deduction;
    System.out.println("Balance: " + balance);
  }

  @Override
  public void display() {
    System.out.println("Name: " + name);
    System.out.println("Address: " + address);
    System.out.println("Mobile No: " + mobile_no);
    System.out.println("Balance: " + balance);
    System.out.println("Interest Rate: " + interest_rate);
    System.out.println("Withdrawal Limit: " + withdrawal_limit);
    System.out.println("Deduction: " + deduction);
  }
}

class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter name: ");
    String name = sc.next();
    System.out.print("Enter address: ");
    String address = sc.next();
    System.out.print("Enter mobile: ");
    String mobile_no = sc.next();

    System.out.print("Enter Account Number: ");
    String acc_no = sc.next();

    if (acc_no.startsWith("SV")) {

      System.out.print("Enter balance: ");
      double balance = sc.nextDouble();
      System.out.print("Enter interest rate: ");
      double interest_rate = sc.nextDouble();
      System.out.print("Enter withdrawal limit: ");
      double withdrawal_limit = sc.nextDouble();

      SavingsAccount sa = new SavingsAccount(name, address, mobile_no, balance, interest_rate, withdrawal_limit);
      sa.checkBalance();
      sa.calculateInterest();
      sa.display();

    } else if (acc_no.startsWith("CH")) {
      System.out.print("Enter balance: ");
      double balance = sc.nextDouble();
      System.out.print("Enter monthly fee: ");
      double monthly_fee = sc.nextDouble();

      CheckingAccount ca = new CheckingAccount(name, address, mobile_no, balance, monthly_fee);
      ca.monthfeecal();
      ca.display();

    } else if (acc_no.startsWith("LO")) {
      System.out.print("Enter balance: ");
      double balance = sc.nextDouble();
      System.out.print("Enter interest rate: ");
      double interest_rate = sc.nextDouble();
      System.out.print("Enter withdrawal limit: ");
      double withdrawal_limit = sc.nextDouble();
      System.out.print("Enter deduction: ");
      double deduction = sc.nextDouble();

      LoanAccount la = new LoanAccount(name, address, mobile_no, balance, interest_rate, withdrawal_limit, deduction);
      la.deduct_balance();
      la.display();

    } else {
      System.out.println("Invalid Account Number");
    }

    sc.close();
  }
}
