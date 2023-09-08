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
