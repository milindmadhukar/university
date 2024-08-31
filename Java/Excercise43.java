// 1. Method Overriding:
//
// Create a Java program to simulate a simple banking system. You have a base class called `BankAccount`, which represents a generic bank account. The `BankAccount` class has the following attributes in private:
//
// - `accountNumber` (int): The account number.
//
// - `accountHolder` (String): The account holder's name.
//
// - `balance` (double): The current account balance.
//
// The class also has the following methods:
//
// - `deposit(double amount)`: A method to deposit money into the account.
//
// - `withdraw(double amount)`: A method to withdraw money from the account.
//
// - `toString()`: A method to display account details.
//
// Now, you need to create two derived classes: `SavingsAccount` and `CheckingAccount`.
//
// For the `SavingsAccount` class:
//
// - It should inherit from `BankAccount`.
//
// - Implement method overriding for `withdraw()`:
//
//   - Ensure that a minimum balance of $1000 is maintained in a savings account. If an attempt is made to withdraw below this balance, display a message indicating insufficient funds.
//
// - Override the `toString()` method to provide a meaningful string representation of the savings account.
//
// For the `CheckingAccount` class:
//
// - It should inherit from `BankAccount`.
//
// - Implement method overriding for `withdraw()`:
//
//   - Checking accounts do not have a minimum balance requirement. Customers can withdraw any amount.
//
// - Override the `toString()` method to provide a meaningful string representation of the checking account.
//
// Your task is to implement these classes, including method overloading, overriding, and the `toString` method, and demonstrate their usage in a simple program to manage bank accounts and showcase polymorphism.
//
// 2. Method Overloading:
//
// Create a Java program for managing a vehicle inventory system. You have a base class called `Vehicle`, which represents generic information about a vehicle:
//
// The `Vehicle` class has the following attributes:
//
// - `make` (String): The make of the vehicle 
//
// - `model` (String): The model of the vehicle 
//
// - `Year` (int): The manufacturing year of the vehicle.
//
// The class also has the following methods:
//
// - `displayInfo()`: Displays basic information about the vehicle.
//
// Now, you need to create three derived classes: `Car`, `Motorcycle`, and `Truck`.
//
// For the `Car` class:
//
// - It should inherit from `Vehicle`.
//
// - Implement method overloading for `displayInfo()`:
//
//   - The `Car` class should have two versions of `displayInfo()` method:
//
//     - One that displays all the vehicle details, including make, model, and year.
//
//     - Another that only displays the make and model.
//
// For the `Motorcycle` class:
//
// - It should inherit from `Vehicle`.
//
// - Implement method overloading for `displayInfo()`:
//
//   - The `Motorcycle` class should have two versions of `displayInfo()` method similar to the `Car` class.
//
// For the `Truck` class:
//
// - It should inherit from `Vehicle`.
//
// - Implement method overloading for `displayInfo()`:
//
//   - The `Truck` class should have two versions of `displayInfo()` method similar to the `Car` class.
//
// Your task is to implement these classes, including method overloading and overriding the `toString()` method in each derived class. Additionally, create a program that allows you to manage and display information about various types of vehicles
//
// Note: Use the Dynamic Method Dispatch concept to create instances of the derived classes

class BankAccount {
  private int accountNumber;
  private String accountHolder;
  private double balance;

  public BankAccount(int accountNumber, String accountHolder, double balance) {
    this.accountNumber = accountNumber;
    this.accountHolder = accountHolder;
    this.balance = balance;
  }

  public double getBalance() {
    return this.balance;
  }

  public void setBalance(double balance) {
    this.balance = balance;
  }

  public void deposit(double amount) {
    this.balance += amount;
    System.out.println("Deposited $" + amount + " into account " + this.accountNumber);
  }

  public void withdraw(double amount) {
    if (this.balance - amount < 0) {
      System.out.println("Insufficient funds to withdraw $" + amount + " from account " + this.accountNumber);
    } else {
      this.balance -= amount;
      System.out.println("Withdrew $" + amount + " from account " + this.accountNumber);
    }
  }

  public String toString() {
    return "Account Number: " + this.accountNumber + "\nAccount Holder: " + this.accountHolder + "\nBalance: $"
        + this.balance;
  }
}

class InsufficientBalanceException extends Exception {
}

class SavingsAccount extends BankAccount {
  public SavingsAccount(int accountNumber, String accountHolder, double balance) throws InsufficientBalanceException {
    super(accountNumber, accountHolder, balance);
    if (balance < 1000) {
      throw new InsufficientBalanceException();
    }
  }

  @Override
  public void withdraw(double amount) {
    if (this.getBalance() - amount < 1000) {
      System.out.println("Insufficient funds to withdraw $" + amount + " from your savings account");
    } else {
      this.setBalance(this.getBalance() - amount);
      System.out.println("Withdrew $" + amount + " from your savings account");
    }
  }

  @Override
  public String toString() {
    return "Savings Account Details\n" + super.toString();
  }
}

class CheckingAccount extends BankAccount {
  public CheckingAccount(int accountNumber, String accountHolder, double balance) {
    super(accountNumber, accountHolder, balance);
  }

  @Override
  public void withdraw(double amount) {
    if (this.getBalance() - amount < 0) {
      System.out.println("Insufficient funds to withdraw $" + amount + " from your checking account");
    } else {
      this.setBalance(this.getBalance() - amount);
      System.out.println("Withdrew $" + amount + " from your checking account");
    }
  }

  @Override
  public String toString() {
    return "Checking Account Details\n" + super.toString();
  }
}

class Vehicle {
  private String make;
  private String model;
  private int year;

  public Vehicle(String make, String model, int year) {
    this.make = make;
    this.model = model;
    this.year = year;
  }

  public String getMake() {
    return this.make;
  }

  public String getModel() {
    return this.model;
  }

  public int getYear() {
    return this.year;
  }

  public void displayInfo() {
    System.out.println("Make: " + this.make + "\nModel: " + this.model + "\nYear: " + this.year);
  }

  public String toString() {
    return "Make: " + this.make + "\nModel: " + this.model + "\nYear: " + this.year;
  }
}

class Car extends Vehicle {
  public Car(String make, String model, int year) {
    super(make, model, year);
  }

  public void displayInfo(boolean showYear) {
    System.out.println("Make: " + this.getMake() + "\nModel: " + this.getModel());
  }
  
  @Override
  public String toString() {
    return "Car Details\n" + super.toString();
  }
}

class Motorcycle extends Vehicle {
  public Motorcycle(String make, String model, int year) {
    super(make, model, year);
  }

  public void displayInfo(boolean showYear) {
    System.out.println("Make: " + this.getMake() + "\nModel: " + this.getModel());
  }

  @Override
  public String toString() {
    return "Motorcycle Details\n" + super.toString();
  }
}

class Truck extends Vehicle {
  public Truck(String make, String model, int year) {
    super(make, model, year);
  }

  public void displayInfo(boolean showYear) {
    System.out.println("Make: " + this.getMake() + "\nModel: " + this.getModel());
  }

  @Override
  public String toString() {
    return "Truck Details\n" + super.toString();
  }
}

public class Excercise43 {
  public static void main(String[] args) {
    try {
      SavingsAccount savingsAccount = new SavingsAccount(123456, "Milind", 10000);
      savingsAccount.deposit(1000);
      System.out.println(savingsAccount);
    } catch (InsufficientBalanceException e) {
      System.out.println("Insufficient Balance");
    }

    CheckingAccount checkingAccount = new CheckingAccount(654321, "Martin Garrix", 2000000L);
    checkingAccount.withdraw(100000);
    System.out.println(checkingAccount);

    System.out.println();

    Car car = new Car("Tesla", "Model S", 2020);
    System.out.println(car);
    car.displayInfo();
    car.displayInfo(true);

    System.out.println();

    Motorcycle motorcycle = new Motorcycle("Harley Davidson", "Street 750", 2019);
    System.out.println(motorcycle);
    motorcycle.displayInfo();
    motorcycle.displayInfo(true);

    System.out.println();

    Truck truck = new Truck("Ford", "F-150", 2018);
    System.out.println(truck);
    truck.displayInfo();
    truck.displayInfo(true);
  }
}
