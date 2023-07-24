import java.util.*;
class String_Functions
{
    Scanner sc = new Scanner(System.in);
    int i,vowel_count = 0;
    String s,s1;
    char ch;
    void main()
    {
        System.out.print("Enter a Word : ");
        s = sc.next();
        s1 = s.toLowerCase();
        for(i = 0 ; i < s1.length();i++)
        {
            ch = s1.charAt(i);
            if(ch == 'a'||ch == 'e'||ch == 'i'||ch == 'o'||ch == 'u')
            vowel_count++;
        }
        System.out.println("No. of vowels are : "+vowel_count);
        s1 = "";
        for(i = 0 ; i < s.length();i++)
        {
            ch = s.charAt(i);
            s1 = ch + s1;
        }
        System.out.println("Reversed Word is : "+s1);
    }
}