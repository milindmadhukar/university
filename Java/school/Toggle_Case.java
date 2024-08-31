import java.util.*;
class Toggle_Case
{
    Scanner sc = new Scanner(System.in);
    int i ,int_ch;
    char ch;
    void main()
    {
        System.out.print("Enter A Sentence : ");
        String s = sc.nextLine();
        for(i = 0 ; i < s.length();i++)
        {
            ch = s.charAt(i);
            int_ch = (int)ch;
            if(int_ch >= 65 && int_ch < 97)
            {
                int_ch += 32;
                System.out.print((char)int_ch);
            }
            else if(int_ch >= 97)
            {
                int_ch -= 32;
                System.out.print((char)int_ch);
            }
            else
            {
                System.out.print(ch);
            }
        }
    }
}