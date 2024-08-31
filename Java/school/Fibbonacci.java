import java.util.*;
class Fibbonacci
{
    void main() 
    {
        int n, a = 0, b = 0, c = 1;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter N : ");
        n = sc.nextInt();
        for(int i = 1; i <= n; i++)
        {
            a = b;
            b = c;
            c = a + b;
            System.out.print(a+" ");
        }
    }
}