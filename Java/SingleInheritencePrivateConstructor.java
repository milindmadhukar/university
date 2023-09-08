import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

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
