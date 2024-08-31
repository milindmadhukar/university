import java.util.*;
class Fibbonachi
{
    Scanner sc = new Scanner(System.in);
    void main()
    {
        int a = 0,b = 1 ;
        System.out.print("Enter Number of Terms : ");
        int n = sc.nextInt();
        System.out.print(a+" "+b+" ");
        for (int i = 1 ; i <= n - 2; i++)
        {
            int s = a + b;
            System.out.print(s + " ");
            a = b ;
            b = s ;
        }
    }
}