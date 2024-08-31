// 1. Scenario: Online Shopping System
//
// You are designing a simplified online shopping system. You have a base class Product representing items for sale, with attributes productName, price, and category. You also have a derived class ElectronicProduct that represents electronic items, inheriting from Product. For electronic products, you want to ensure that the productName and price cannot be modified once the object is created. Additionally, you want to provide a method to display information about the electronic product, including its features. You also need to override the toString() method in the Product class to provide a custom output format.
//
// Question: Define the Product class with a constructor that initializes the attributes. Also, override the toString() method to return the attributes 
//
// Define the ElectronicProduct class as a subclass of Product. This class should have an additional attribute feature, which will be an array of strings representing the features of the electronic product. Ensure that once an ElectronicProduct object is created, the productName and price cannot be modified. Implement a method to display the features of the electronic product. Provide an example of creating an ElectronicProduct object and demonstrate its usage.
//
// 2. Write a Java program that demonstrates the concept of single inheritance with a private constructor in the derived class using reflection API. The program should have two classes: Person and Student. The Person class should have a public constructor that takes a name and an age as parameters and assigns them to the final field name and age. The Person class should also have a public method called display() that prints the name and age of the person. The Student class should inherit from the Person class and have a private constructor that takes a name, age, and a grade as parameters and passes the name and age to the super constructor of the Person class using reflection API. The Student class should also override the display() method to print the name, age, and grade of the student. In the main method, create an object of the Student class using the reflection API and pass the object of the student class as an argument. Finally, override the display() method on both objects and observe the output.

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

class Product {
    private final String productName, category;
    private final double price;

    public Product(String productName, double price, String category) {
        this.productName = productName;
        this.price = price;
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product Name: " + productName + "\nPrice: " + price + "\nCategory: " + category;
    }
}

class ElectronicProduct extends Product {
    String[] features;

    public ElectronicProduct(String productName, double price, String category, String[] features) {
        super(productName, price, category);
        this.features = features;
    }

    public void displayFeatures() {
        System.out.println("Features:");
        for (String feature : features) {
            System.out.println(feature);
        }
    }
}

class Program1 {
  public static void main(String[] args) {
    String[] features = {"Battery", "Screen", "Camera"};
    ElectronicProduct product = new ElectronicProduct("iPhone", 100000.0, "Phones", features);
    System.out.println(product);
    product.displayFeatures();
    
  }	 	  	 	 	      	     	  		   	        	 	
}

class Person {
  private final String name;
  private final int age;

  public Person(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public void display() {
    System.out.println("Name: " + name + "\nAge: " + age);
  }
}

class Student extends Person {
  private final char grade;

  private Student(String name, int age, char grade) {
    super(name, age);
    this.grade = grade;
  }

  @Override
  public void display() {
    String name;
    int age;
    try {
      Field nameField = Person.class.getDeclaredField("name");
      Field ageField = Person.class.getDeclaredField("age");

      nameField.setAccessible(true);
      ageField.setAccessible(true);

      name = (String) nameField.get(this);
      age = (int) ageField.get(this);
    } catch (Exception e) {	 	  	 	 	      	     	  		   	        	 	
      System.out.println("We errored bru" + e);
      return;
    }

    System.out.println("Name: " + name + "\nAge: " + age + "\nGrade: " + grade);
  }
}

class Program2 {
  public static void main(String[] args) throws Exception {
    Constructor<Student> studentConstructor = Student.class.getDeclaredConstructor(String.class, int.class, char.class);
    studentConstructor.setAccessible(true);

    Student student = studentConstructor.newInstance("Milind", 19, 'A');
    student.display();
  }
}
