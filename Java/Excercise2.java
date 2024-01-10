import java.util.Scanner;

class Excercise2 {

  Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    Excercise2 obj = new Excercise2();
    obj.program1();
    obj.program2();
    obj.program3();
    obj.program4();
    obj.program5();
  }

  void program1() {
    System.out.print("Enter number of students: ");
    int num_of_students = sc.nextInt();

    int scores[] = new int[num_of_students];
    int best_score = 0;

    for (int i = 0; i < num_of_students; i++) {
      System.out.print("Enter score of student " + (i + 1) + ": ");
      scores[i] = sc.nextInt();
      if (scores[i] > best_score) {
        best_score = scores[i];
      }
    }

    for (int i = 0; i < num_of_students; i++) {
      System.out.print("Student " + i + " score is " + scores[i] + " and grade is ");
      if (scores[i] >= best_score - 10) {
        System.out.println("A");
      } else if (scores[i] >= best_score - 20) {
        System.out.println("B");
      } else if (scores[i] >= best_score - 30) {
        System.out.println("C");
      } else if (scores[i] >= best_score - 40) {
        System.out.println("D");
      } else {
        System.out.println("F");
      }
    }
    System.out.println();
  }

  void program2() {

    // Write a program that reads 10 numbers and displays the number of distinct
    // numbers separated by exactly one space.

    int nums[] = new int[10];
    int count = 0;

    outer: for (int i = 0; i < 10; i++) {
      System.out.print("Enter number " + (i + 1) + ": ");
      int num = sc.nextInt();
      for (int j = 0; j < i; j++) {
        if (nums[j] == num) {
          continue outer;
        }
      }
      nums[count++] = num;
    }

    System.out.print("The number of distinct numbers is " + count + " and they are ");
    for (int i = 0; i < count; i++) {
      System.out.print(nums[i] + " ");
    }

    System.out.println();
  }

  void program3() {
    //
    // 3. Write a Java program to copy from the 3rd element of the char array called
    // "Welcome" and store it in another by the arraycopy() method and clone all the
    // array elements to another by the clone() method of the System class.

    char[] welcome = { 'W', 'e', 'l', 'c', 'o', 'm', 'e' };
    char[] welcome2 = new char[4];
    char[] welcome3 = new char[7];

    System.arraycopy(welcome, 2, welcome2, 0, 1);
    for (int i = 0; i < welcome2.length; i++) {
      if (welcome2[i] != '\u0000') {
        System.out.print(welcome2[i] + ", ");
      }
    }

    System.out.println();

    welcome3 = welcome.clone();
    for (int i = 0; i < welcome3.length; i++) {
      System.out.print(welcome3[i] + ", ");
    }

    System.out.println();
  }

  void program4() {

    int arr[][] = new int[5][];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = new int[arr.length - i];
      for (int j = 0; j < arr[i].length; j++) {
        arr[i][j] = 5 - j - i;
      }
    }

    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        System.out.print(arr[i][j] + " ");
      }
      System.out.println();
    }

    System.out.println();
  }

  void program5() {

    char data[][] = {
        { 'A', 'B', 'A', 'C', 'C', 'D', 'E', 'E', 'A', 'D' },
        { 'D', 'B', 'A', 'B', 'C', 'A', 'E', 'E', 'A', 'D' },
        { 'E', 'D', 'D', 'A', 'C', 'B', 'E', 'E', 'A', 'D' },
        { 'C', 'B', 'A', 'E', 'D', 'C', 'E', 'E', 'A', 'D' },
        { 'A', 'B', 'D', 'C', 'C', 'D', 'E', 'E', 'A', 'D' },
        { 'B', 'B', 'E', 'C', 'C', 'D', 'E', 'E', 'A', 'D' },
        { 'B', 'B', 'A', 'C', 'C', 'D', 'E', 'E', 'A', 'D' },
        { 'E', 'B', 'E', 'C', 'C', 'D', 'E', 'E', 'A', 'D' },
    };

    char key[] = { 'D', 'B', 'D', 'C', 'C', 'D', 'A', 'E', 'A', 'D' };

    int scores[] = new int[data.length];

    for (int student_idx = 0; student_idx < data.length; student_idx++) {
      for (int question_idx = 0; question_idx < data[student_idx].length; question_idx++) {
        if (data[student_idx][question_idx] == key[question_idx]) {
          scores[student_idx]++;
        }
      }
    }

    for (int student_idx = 0; student_idx < data.length; student_idx++) {
      System.out.println("Student " + student_idx + " score is " + scores[student_idx]);
    }
  }
}
