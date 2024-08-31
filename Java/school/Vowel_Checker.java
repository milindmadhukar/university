import java.util.*;
class Vowel_Checker
{
    Scanner sc = new Scanner(System.in);
    void main()
    {
        System.out.print("Enter a Word : ");
        String s = sc.next();
        s = s.toLowerCase();
        System.out.print("Vowels Found are : ");
        for(int i = 0; i< s.length() ; i++)
        {
            char ch = s.charAt(i);
            if(ch == 'a'||ch =='e'||ch == 'i'||ch == 'o'||ch == 'u')
            {
                System.out.print(ch+" ");
            }
        }
    }
}