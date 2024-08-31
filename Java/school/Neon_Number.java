import java.util.*;
class Neon_Number
{
    Scanner sc = new Scanner(System.in);
    void main()
    {
        System.out.println("Neon Numbers Between 0 and 1000 are :"); 
        for(int i = 0 ; i <= 1000 ; i++)
        {
            boolean a = Neon(i);
            if(Neon(i))
            System.out.print(i + " ");
        }
    }
    boolean Neon(int i )
    {
        int sum = 0;
        int num = (int)Math.pow(i ,2);
        while(num != 0 )
       {
         int rem =  num % 10 ;
         num = num / 10 ;
         sum += rem;
       }
       if(i == sum)
       return true;
       else
       return false;
    }
}