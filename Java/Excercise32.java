// 1. BMI Calculator:
//
// The Universe is a well-known gym that is open to both men and women. Before admitting anyone to the gym, they calculate their Body Mass Index (BMI) and assign them a grade according to their BMI score. BMI grades :
//
//
//
// Underweight[U] - when BMI < 18.5
// Normal weight[N] - 18.5 >= BMI < 25.0
// Heavyweight [H] - 25.0 >= BMI < 30.0
// Overweight [O] - above or equal to 30.0
//
// To automate the BMI calculation process, Universe wants to develop a system that only requires the person's weight and height to be inputted. Help to automize this task.
//
// Note: BMI = [weight / height^2] where weight is taken in kilograms and height in meters.
//
// Attributes:
//
// private double weight;
// private double height;
// private double bmi;
// private String grade;
//
// Methods:
//
// public BMIcalculator(double weight, double height)
// private double calculateBMI()
// private String calculateGrade()
// public void displayBMI()
//
// Create a driver class and invoke all the members through the object
//
// Input format: Input to get 2 values denoting weight and height
// Output format: Print the BMI grade as U, H, N, or O.
//
// Note: Use the methods of Class and Method to access the private methods.
//
//
// 2. Stock price calculation
//
// Design a class named Stock that contains:
//
// A string data field named symbol for stock's symbol
//
// A string data field named name for stock's name
//
// A double data field named previousClosingPrice, stores the stock price for the previous day
//
// A double data field named currentPrice, stores the price for the current time
//
// A constructor that creates a stock with the specified symbol and name
//
// A method named getChangePercentage( ), returns the percentage changed from the previous day to the current time
//
// Write a test class that creates a stock object with the stock symbol ORCL, and name Oracle Corporation and the previous closing price of 34.5. Set a new current price to 34.35 and display the price-change percentage.
//
// Note: Use this keyword in the constructor methodimport java.util.Scanner;

class BMIcalculator {

  private double weight;
  private double height;
  private double bmi;
  private String grade;

  public BMIcalculator(double weight, double height) {
    weight = this.weight;
    height = this.height;
  }

  public void displayBMI() {
    grade = calculateGrade();
    System.out.println("BMI grade: " + grade);
  }

  private double calculateBMI() {
    return weight / (height * height);
  }

  private String calculateGrade() {
    bmi = calculateBMI();
    if (bmi < 18.5) {
      return "Underweight[U]";
    } else if (bmi >= 18.5 && bmi < 25.0) {
      return "Normal weight[N]";
    } else if (bmi >= 25.0 && bmi < 30.0) {
      return "Heavyweight [H]";
    } else {
      return "Overweight [O]";
    }
  }
}

class Stock {

  private String symbol;
  private String name;
  private double previousClosingPrice;
  private double currentPrice;

  public Stock(String symbol, String name) {
    this.symbol = symbol;
    this.name = name;
  }

  public void displayStock(double previousClose, double current) {
    previousClosingPrice = previousClose;
    currentPrice = current;
    System.out.println("Stock symbol: " + symbol);
    System.out.println("Stock name: " + name);
    System.out.println("Previous closing price: " + previousClosingPrice);
    System.out.println("Current price: " + currentPrice);
    System.out.println("Percentage Change: " + getChangePercentage());
  }

  private double getChangePercentage() {
    return (currentPrice - previousClosingPrice) / previousClosingPrice;
  }

}

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.println("Enter weight: ");
    double weight = sc.nextDouble();
    System.out.println("Enter height: ");
    double height = sc.nextDouble();
    BMIcalculator bmi = new BMIcalculator(weight, height);
    bmi.displayBMI();

    Stock stock = new Stock("ORCL", "Oracle");
    stock.displayStock(34.5, 34.35);

    sc.close();
  }
}
