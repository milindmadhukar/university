
import java.util.*;
class Dchar_Array
{
    int no_of_words = 1 ;
    String str;
    Scanner sc = new Scanner(System.in);
    int i = 0, j = 0;
    boolean double_char= false;
    void main()
    {
       System.out.print("Enter a Sentence : ");
       str = sc.nextLine();
       str = str.trim();
       for(int i = 0 ;i<str.length() ;i++)
       {
           if(str.charAt(i) == ' ')
               no_of_words++;
        }
       String word[] = new String[no_of_words];
       for(int i = 0 ;i<word.length ;i++)
       {
           word[i] = "";
       }
       for(int i = 0 ; i < str.length() ;i++)
       {
           word[j] += str.charAt(i);
           if(str.charAt(i) == ' ')
               j++;
        }
        if(no_of_words == 1)
        {
             for(int i = 0 ; i < str.length()-1 ; i++)
             {
                 if(str.charAt(i) == str.charAt(i+1))
                 {
                     double_char = true;
                     break;
                 }
             }
             System.out.println(double_char);
        }
        else
        {
            for(i = 0,j = 0; i < word[j].length() ; i++)
             {
                 if(word[j].charAt(i) == word[j].charAt(i+1))
                 {
                     System.out.println(word[j]);
                     j++;
                     i = 0;
                 }
             }
        }
    }
}