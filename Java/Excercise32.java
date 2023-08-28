import java.util.Scanner;

class BMIcalculator {

  private double weight;
  private double height;
  private double bmi;
  private String grade;

  public BMIcalculator(double weight, double height) {
    weight = this.weight;
    height = this.height;
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

  public void displayBMI() {
    grade = calculateGrade();
    System.out.println("BMI grade: " + grade);
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

  private double getChangePercentage() {
    return (currentPrice - previousClosingPrice) / previousClosingPrice;
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
