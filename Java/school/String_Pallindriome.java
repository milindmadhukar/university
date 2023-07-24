import java.util.*;
class String_Pallindriome
{
    Scanner sc = new Scanner(System.in);
    String F = "";
    void main()
    {
        System.out.print("Enter Word : ");
        String s = sc.next();
        int len = s.length();
        for(int i = len-1; i >= 0 ; i--)
        {
            char c = s.charAt(i);
            F += c ;
        }
        if(s.equalsIgnoreCase(F)== true)
            System.out.print("Pallindrome");
        else
        System.out.print("Not Pallindrome");
            
    }
}