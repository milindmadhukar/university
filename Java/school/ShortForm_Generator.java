import java.util.*;
class ShortForm_Generator
{
    Scanner sc = new Scanner(System.in);
    void main()
    {
        System.out.print("Enter a Sentence : ");
        String str = sc.nextLine();
        str = str.trim();
        str = str.toUpperCase();
        System.out.println(str);
        str = " " + str ;
        int len_of_str = str.length();
        for(int i = 0 ; i < len_of_str ; i++)
        {
            char ch = str.charAt(i);
            if(ch == ' ')
            System.out.print(str.charAt(i + 1)+".");
        }
    }
}