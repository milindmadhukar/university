import java.util.*;
class PigLatin_Converter
{
    Scanner sc = new Scanner(System.in);
    String Aft_Vowel , Bef_Vowel , Final = "";
    void main()
    {
        System.out.print("Enter a Word : " );
        String word = sc.next();
        word = word.toUpperCase();
        int len = word.length();
        for(int i = 0 ; i < len ; i++)
        {
            char ch = word.charAt(i);
            if(ch == 'A'|| ch == 'E'||ch == 'I'||ch == 'O'||ch == 'U')
            {
                Aft_Vowel = word.substring(i+1);
                Bef_Vowel = word.substring(0,i);
                Final = ch + Aft_Vowel + Bef_Vowel + "AY";
                System.out.println("Pig Latin Form is : "+Final);
                break;
            }
        }
    }
}