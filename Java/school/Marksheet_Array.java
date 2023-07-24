import java.util.*;
class Marksheet_Array
{
    Scanner sc = new Scanner(System.in);
    int roll[] = new int [3];
    String name[] = new String [3];
    int english[] = new int [3];
    int maths[] = new int [3];
    int hindi[] = new int [3];
    int total[] = new int [3];
    double percent[] = new double [3];
    int i = 0;
    void input()
    {
        for(; i < 3 ; i++)
        {
            System.out.print("Enter Roll No. : ");
            roll[i] = sc.nextInt();
            System.out.print("Enter Name : ");
            name[i] = sc.next();
            System.out.print("Enter English Marks : ");
            english[i] = sc.nextInt();
            System.out.print("Enter Maths Marks : ");
            maths[i] = sc.nextInt();
            System.out.print("Enter Hindi Marks : ");
            hindi[i] = sc.nextInt();
            calc();
        }
    }
    void calc()
    {
        total[i] = english[i] + maths[i] + hindi[i];
        percent[i] = (double)total[i]/3.0;
        display();
    }
    void display()
    {
        System.out.println("P.G Garodia School");
        System.out.println("Report Card");
        System.out.println("======================");
        System.out.println("Name : "+name[i]);
        System.out.println("Roll No : "+roll[i]);
        System.out.println("======================");
        System.out.println("English\tMaths\tHindi");
        System.out.println(english[i]+"\t"+maths[i]+"\t"+hindi[i]);
        System.out.println("======================");
        System.out.println("Total is : "+total[i]);
        System.out.println("Percentage is : "+percent[i]+"\n\n\n");
    }
}