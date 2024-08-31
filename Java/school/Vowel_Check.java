import java.util.*;
class Vowel_Check
{
    Scanner sc = new Scanner(System.in);
    void main(String s)
    {
        System.out.println(s);
        int ctr = 0;
        s= s.toLowerCase();
        for(int i = 0 ; i < s.length()-1;i++)
        {
            char ch = s.charAt(i); char ch1 = s.charAt(i+1);
            if((ch == 'a' ||ch == 'e' ||ch == 'i' ||ch == 'o' ||ch == 'u')&&(ch1 == 'a' ||ch1 == 'e' ||ch1 == 'i' ||ch1 == 'o' ||ch1 == 'u'))
            {
               System.out.print(ch+""+ch1+" ");
               ctr++;
            }
        }
        System.out.println("\nNumber : "+ctr);
    }
}