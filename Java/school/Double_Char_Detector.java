import java.util.*;
class Double_Char_Detector
{
    Scanner sc = new Scanner(System.in);
    int no_of_words = 1 ;
    String str;
    int j = 0;
    

    boolean double_char(String str)
    {
        int count = 0;
        boolean flag = false;
        for(int i = 0 ; i < str.length()-1 ; i++)
        {
            if(str.charAt(i) == str.charAt(i+1))
            {
                flag = true;
                break;
            }
        }
        return flag;
    }
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
       for(int i = 0 ; i< no_of_words; i++)
       {
         if(double_char(word[i]) == true)
         System.out.print(word[i]+" ");
       }
    }
}