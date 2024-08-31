import java.util.*;
class Secret_Language
{
    Scanner sc = new Scanner(System.in);
    String n,s1 = "";
    void main()
    {
        System.out.println("Enter the Sentence to be Converted : ");
        String s = sc.nextLine();
        for(int i = 0 ; i < s.length(); i++)
        {
            char ch = s.charAt(i);
            if(ch == 'a'||ch == 'e'||ch == 'i'||ch == 'o'||ch == 'u'||ch == 'A'||ch == 'E'||ch == 'I'||ch == 'O'||ch == 'U')
            {
                System.out.print(ch+"p"+ch);
            }
            else
            System.out.print(ch);
       }
    }
}