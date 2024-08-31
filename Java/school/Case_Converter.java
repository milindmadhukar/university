import java.util.*;
class Case_Converter
{
    Scanner sc = new Scanner(System.in);
    void main()
    {
        System.out.print("Enter the Line : ");
        String word = sc.nextLine();
        for(int i = 0 ; i < word.length() ; i++)
        {
            char ch = word.charAt(i);
            String ch_r = ""+ch;
            if(ch_r.equals(ch_r.toUpperCase())== true ) 
            {
                 System.out.print(ch_r.toLowerCase());
            }
            if(ch_r.equals(ch_r.toLowerCase())== true)
            {
                System.out.print(ch_r.toUpperCase());
            }
        }
    }
}