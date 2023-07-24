import java.util.*;
class SumOfDigiysPrac
{
    Scanner sc = new Scanner(System.in);
    void main()
    {
        System.out.print("Enetr a number : ");
        int num =sc.nextInt();
        int rev = 0;
        while(num != 0 )
        {
            int r = num % 10; 
            rev = rev * 10 + r;
            num = num / 10 ;            
        }
        System.out.println(rev);
    }
}