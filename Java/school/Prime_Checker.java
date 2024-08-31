import java.util.*;
class Prime_Checker
{
    Scanner sc = new Scanner(System.in);
    void main()
    {
        boolean prime_checker = factor();
        if(prime_checker == true)
        System.out.println("Therefore Prime");
        else
        System.out.println("Therefore Not Prime");
    }
    boolean factor()
    {
        int no_of_factors = 0;
        System.out.print("Enter the Number : ");
        int num = sc.nextInt();
        System.out.println("The Factors are : ");
        for(int i = 1;i <= num ; i++)
        {
            if(num % i == 0)
            {
                System.out.print(i+"\n");
                no_of_factors ++; 
            }
        }
        System.out.println("The number of factors are : "+no_of_factors);
        boolean prime;
        if(no_of_factors > 2 )
        prime = false;
        else
        prime = true;
        return prime;
    }
}