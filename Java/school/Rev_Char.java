import java.util.*;
class Rev_Char
{
    Scanner sc = new Scanner(System.in);
    void main()
    {
        System.out.print("Enter a Character : " );
        String s = sc.next();
        char ch = s.charAt(0);
        for(int r = 1 ; r <= 5;r++)
        {
            for (int c = 5 ; c>= r;c--)
            System.out.print(ch + " ");
            System.out.println();
        }
    }
}