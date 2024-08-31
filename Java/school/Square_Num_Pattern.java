import java.util.*;
class Square_Num_Pattern
{
    Scanner sc = new Scanner(System.in);
    void main()
    {
        System.out.print("Enter a number : ");
        int n = sc.nextInt();
        
        
        for(int r = 1 ; r <= n ; r++)
        {
            int sq = r*r ;
            System.out.print(sq+" ");
        }
    }
}