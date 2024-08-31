import java.util.Scanner;

class Experiment1 {
    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        Experiment1 obj = new Experiment1();
        // obj.program1();
        // obj.program2();
        // obj.program3();
        // obj.program4();
        // obj.program5();
        // obj.program6();
        // obj.program7();
        // obj.program8();
        // obj.program9();
        // obj.program10();

        obj.pattern1();
        obj.pattern2();
        obj.pattern3();
        obj.pattern4();
        obj.pattern5();
        obj.pattern6();

    }

    void program1() {

        System.out.println("Hello");
        System.out.println("Milind Madhukar");

    }

    void program2() {
        System.out.println("Enter 3 numbers");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        float avg = (a + b + c) / 3.0f;

        System.out.println("Average is: " + avg);
    }

    void program3() {
        System.out.println("Output of -5+8*6 is: " + (-5 + 8 * 6));
        System.out.println("Output of (55+9)%9 is: " + ((55 + 9) % 9));
        System.out.println("Output of  20+ -3*5/8 is: " + (20 + -3 * 5 / 8));
        System.out.println("Output of 5+15/3*2-8%3 is: " + (5 + 15 / 3 * 2 - 8 % 3));
    }

    void program4() {
        System.out.println("Enter radius of circle");
        float radius = sc.nextFloat();
        final float pi = 3.1415f;
        float area = pi * radius * radius;
        float perimeter = 2 * pi * radius;

        System.out.println("Area of circle is: " + area);
        System.out.println("Perimeter of circle is: " + perimeter);
    }

    void program5() {

        sc.nextLine();

        System.out.print("Enter your registeration number: ");
        String regNo = sc.nextLine();

        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        System.out.print("Enter your department: ");
        String dept = sc.nextLine();

        System.out.print("Enter your age: ");
        int age = sc.nextInt();

        System.out.print("Enter your mobile number: ");
        long mobileNo = sc.nextLong();

        System.out.print("Enter your GPA: ");
        float gpa = sc.nextFloat();

        System.out.println("Register_No: " + regNo);
        System.out.println("Name: " + name);
        System.out.println("Dept: " + dept);
        System.out.println("Age: " + age);
        System.out.println("Mobile_No: " + mobileNo);
        System.out.println("GPA: " + gpa);
    }

    void program6() {
        System.out.print("Enter time in seconds: ");
        int sec = sc.nextInt();
        int min = sec / 60;
        sec %= 60;

        System.out.println("Time is " + min + " minutes and " + sec + " seconds.");
    }

    void program7() {

        System.out.print("Enter temperature in farenheit: ");
        float far = sc.nextFloat();

        float cel = (5.0f / 9.0f) * (far - 32);

        System.out.println("The temperature in celsius is: " + cel);
    }

    void program8() {

        System.out.print("Enter temperature in celsius: ");
        float cel = sc.nextFloat();

        float far = (cel * 1.8f) + 32;

        System.out.println("The temperature in farenheit is: " + far);

    }

    void program9() {
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        int sum = 0;

        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }

        System.out.println("The sum of digits is: " + sum);
    }

    void program10() {
        System.out.print("Enter principal: ");
        int principal = sc.nextInt();
        System.out.print("Enter interest rate: ");
        int rate = sc.nextInt();
        System.out.print("Enter number of years: ");
        int years = sc.nextInt();

        int n = 1;

        double amount = principal * Math.pow((1 + (rate / 100.0f) * 1.0f / n), n * years);

        System.out.println("The amount is: " + amount);
    }

    void pattern1() {
        for (int r = 1; r <= 6; r++) {
            for (int c = 0; c < r; c++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();
    }

    void pattern2() {
        for (int r = 6; r > 0; r--) {
            for (int c = 0; c < r; c++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();
    }

    void pattern3() {
        for (int r = 6; r > 0; r--) {
            for (int c = 0; c < r; c++) {
                if (c == 0 || c == (r - 1) || r == 6) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }

        System.out.println();
    }

    void pattern4() {
        for (int r = 6; r > 0; r--) {
            for (int c = 0; c < r - 1; c++) {
                System.out.print("  ");
            }
            for (int c = 0; c <= 6 - r; c++) {
                System.out.print("*   ");
            }
            System.out.println();
        }
        System.out.println();
    }

    void pattern5() {
        for (int r = 6; r > 0; r--) {
            for (int c = 0; c < 6 - r; c++) {
                System.out.print("  ");
            }
            for (int c = 0; c < r; c++) {
                System.out.print("*   ");
            }
            System.out.println();
        }
        System.out.println();
    }

    void pattern6() {
        for (int r = 6; r > 0; r--) {
            for (int c = 0; c < r - 1; c++) {
                System.out.print("  ");
            }
            for (int c = 0; c <= 6 - r; c++) {
                if (r == 1 || c == 0 || c == 6 - r) {
                    System.out.print("*   ");
                } else {
                    System.out.print("    ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

}
