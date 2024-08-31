import java.util.*;
class Marksheet_2D_Array
{
    Scanner sc = new Scanner(System.in);
    String Student[][] = new String[5][7];
    int i ,j,count = 1;
    double tot,avg;
    void input()
    {
        for(i = 0; i < 5 ; i++)
        {
            for(j = 0 ; j < 7 ; j++)
            {
                System.out.println("STUDENT "+count);
                System.out.print("Enter Roll No. for Student "+count+" : ");
                int roll = sc.nextInt();
                sc.nextLine();//skips the line
                Student[i][j] = Integer.toString(roll);
                j++;
                System.out.print("Enter Name for Student "+count+ " : ");
                String name = sc.nextLine();
                Student[i][j] = name;
                j++;
                System.out.print("Enter English Marks for Student "+count+" : ");
                double eng = sc.nextInt();
                tot += eng;
                Student[i][j] = Double.toString(eng);
                j++;
                System.out.print("Enter Maths Marks for Student "+count+" : ");
                double math = sc.nextInt();
                tot += math;
                Student[i][j] = Double.toString(math);
                j++;
                System.out.print("Enter Hindi Marks for Student "+count+" : ");
                double hin = sc.nextInt();
                tot += hin;
                Student[i][j] = Double.toString(hin);
                j++;
                Student[i][j] = Double.toString(tot);
                j++;
                avg = tot/3;
                Student[i][j] = Double.toString(avg);          
                count++;
                System.out.print("\n");
           }
           j=0;
           tot = 0;
        }
       Display();
    }
    void Display()
    {
        System.out.println("Report Cards are as follows :");
        System.out.println("Sr.No\tRoll No\tName\tEnglish\tMaths\tHindi\tTotal\tPercentage");
        for(i = 0; i < 5 ; i++)
        {
            System.out.print(i+1+"\t");
            for(j = 0 ; j < 7 ; j++)
            {
                System.out.print(Student[i][j]+"\t");
            }
            System.out.println("\n");
        }
    }
}