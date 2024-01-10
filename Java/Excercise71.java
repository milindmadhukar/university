// Create an Array list to store the details of employee skill 
//
// Create a stack to store the details of mobile no of an employee.
//
// Create a map to store the details of employees working location pincode as key

import java.util.Map;
import java.util.ArrayList;
import java.util.Stack;
import java.util.HashMap;

class Employee {
  private String name;
  private int age;
  private String skill;
  private long mobile;
  private int pincode;

  public Employee(String name, int age, String skill, long mobile, int pincode) {
    this.name = name;
    this.age = age;
    this.skill = skill;
    this.mobile = mobile;
    this.pincode = pincode;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  public String getSkill() {
    return skill;
  }

  public int getPincode() {
    return pincode;
  }

  public long getMobile() {
    return mobile;
  }

  @Override
  public String toString() {
    return "Name: " + name + " Age: " + age + " Skill: " + skill + " Mobile: " + mobile + " Pincode: " + pincode;
  }
}

public class Excercise71 {
  public static void main(String[] args) {
    ArrayList<Employee> employeeList = new ArrayList<Employee>();
    Stack<Long> mobileList = new Stack<Long>();
    Map<Integer, String> pincodeList = new HashMap<Integer, String>();

    employeeList.add(new Employee("Milind", 19, "Java", 1234567890, 123456));
    employeeList.add(new Employee("Martin Garrix", 27, "DJ", 1234567891, 123457));
    employeeList.add(new Employee("Ishaan", 18, "C++", 1234567892, 123458));
    employeeList.add(new Employee("Kevin", 20, "Python", 1234567893, 123459));
    employeeList.add(new Employee("Om", 21, "C", 1234567894, 123460));

    for (Employee employee : employeeList) {
      mobileList.push(employee.getMobile());
    }

    for (Employee employee : employeeList) {
      pincodeList.put(employee.getPincode(), employee.getName());
    }

    System.out.println("Employee List: ");
    for (Employee employee : employeeList) {
      System.out.println(employee);
    }

    System.out.println("Mobile List: ");
    while (!mobileList.empty()) {
      System.out.println(mobileList.pop());
    }

    System.out.println("Pincode List: ");
    for (Map.Entry<Integer, String> entry : pincodeList.entrySet()) {
      System.out.println("Pincode: " + entry.getKey() + " Location: " + entry.getValue());
    }
  }
}
