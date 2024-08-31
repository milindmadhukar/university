import java.util.* ;
class Tables
{
    Scanner sc = new Scanner(System.in);
    void main()
    {
        System.out.println("Enter the Number of the Table which you want : ");
        int multiple = sc.nextInt();
        System.out.println("Table of "+multiple+" is as follows : ");
        for(int i = 1 ; i <= 10 ; i++)
        {
           System.out.println(i + " x "+ multiple + " = " + i*multiple);
        }
    }
}