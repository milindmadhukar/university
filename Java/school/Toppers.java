import java.util.*;
class Toppers
{
    Scanner sc = new Scanner(System.in);
    String student[][] = new String[5][2];
    int i=0,j=0,tmp1 = 0;
    String tmp = "",temp;
    void main()
    {
        Toppers obj = new Toppers();
        obj.accept();
        obj.Bubble_Sort();
        obj.display();
    }
    void accept()
    {
        for(i = 0 ; i < 5 ; i++)
        {
            System.out.println("Enter Name And Percentage of Student "+(i+1));
            student[i][0] = sc.next();
            student[i][1] = sc.next();
        }
    }
    void Bubble_Sort()
    {
        for(i = 0 ; i < 5 ; i++)
        {
            for(j = 0 ; j < 5 - i - 1 ; j++)
            {
                if(Double.parseDouble(student[j][1]) < (Double.parseDouble(student[j+1][1])))
                {
                    temp = student[j][0];
                    student[j][0] = student[j+1][0];
                    student[j+1][0] = temp;
                    tmp = student[j][1];
                    student[j][1] = student[j+1][1];
                    student[j+1][1] = tmp;
                }
            }
        }
    }
    void display()
    {
        System.out.println("Toppers are : \nName\tRoll");
        for(i = 0 ; i < 2; i++)
        {
            System.out.println(student[i][0] +"\t"+ student[i][0]+"%");
        }
    }
}