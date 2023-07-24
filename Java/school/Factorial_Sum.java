import java.util.*;
class Factorial_Sum
{
    Scanner sc = new Scanner(System.in);
    void main()
    {
        int fact = 1,sum = 0;
        System.out.print("Enter the number whose sum of Factorial has to be found : ");
        int num = sc.nextInt();
        for(int i = 1 ; i <= num ; i++)
        {
            fact *= i;
            sum += fact;
        }
        System.out.println("Sum is : "+sum);
    }
}