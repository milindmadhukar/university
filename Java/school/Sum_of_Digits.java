import java.util.*;
class Sum_of_Digits
{
    Scanner sc = new Scanner(System.in);
    void main()
    {
       System.out.print("Enter a Number whose Sum of Digits is to be found : ");
       int num = sc.nextInt();
       int new_num = num ;
       int rem , sum = 0;
       while(num != 0 )
       {
         rem =  num % 10 ;
         num = num / 10 ;
         sum += rem*rem*rem;
       }
       System.out.println("The sum of the Digits is : "+ sum );
    }
}