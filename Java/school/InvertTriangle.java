import java.util.*;
class InvertTriangle
{
    Scanner sc = new Scanner(System.in);
    int r = 0 , c = 0;
    void main()
    {
        System.out.print("Enter Number of lines : ");
        int n = sc.nextInt();
        for(r = n ; r >= 1 ; r--)
        {
            
            for(c = 1 ; c <= r ; c++)
            System.out.print(" " + r);
            for(int i = n-1 ; i<=r ; i++)
            System.out.print(" ");
            System.out.println();
        }
     }
}