import java.util.*;
class Spy_Number
{
    Scanner sc = new Scanner(System.in);
    int n,rem,sum,prod = 1;
    void main()
    {
        System.out.print("Enter A Number : ");
        n = sc.nextInt();
        while(n > 0)
        {
            rem = n % 10;
            sum += rem;
            prod *= rem;
            n /= 10;
        }
        if(sum == prod)
        System.out.println("Spy Number !");
        else
        if(sum == prod)
        System.out.println("Not a Spy Number !");
    }
}