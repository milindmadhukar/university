import java.util.*;
class Word_Triangle_Pattern
{
    Scanner sc = new Scanner(System.in);
    void main()
    {
        int r , c ;
        System.out.print("Enter a word: ");
        String s = sc.next();
        int lines = s.length();
        int char_counter = 0 ;
        for(r = 1; r <= lines ; r++)
        {
            for(c = 0,char_counter = 0; c < r ;c++,char_counter++)
            {
                char ch = s.charAt(c);
                System.out.print(ch);
            }
            System.out.println();
        }
    }
}