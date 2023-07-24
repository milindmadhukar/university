import java.util.*;
class Grades
{
    Scanner sc = new Scanner(System.in);
    String student[][] = new String[5][4];
    int r , c ;
    double per;
    void main()
    {
        for(r = 0 ; r < 5 ; r++)
        {
                System.out.print("Enter Details for Student "+(r+1)+" : \nEnter Roll No. : ");
                student[r][0] = sc.next();
                System.out.print("Enter Name : ");
                student[r][1] = sc.next();
                System.out.print("Enter English Marks : ");
                int eng = sc.nextInt();
                
        }
        display();
    }
    void display()
    {
        System.out.println("Roll\tName\tPer\tGrade");
        for(int r = 0 ; r < 5 ; r++)       
        {
            for(int c = 0; c < 4 ; c++)
            {
                System.out.print(student[r][c]+"\t");
            }
            System.out.println();
        }
    }
}