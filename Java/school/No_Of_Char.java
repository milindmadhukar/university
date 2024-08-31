import java.util.*;
class No_Of_Char
{
    Scanner sc = new Scanner(System.in);
    int counter = 0;
    void check()
    {
        System.out.println("Input: ");
        String str = sc.next();
        String chara = sc.next();
        char ch = chara.charAt(0);
        for(int i = 0 ; i < str.length() ; i++)
        {
            char cha = str.charAt(i);
            if(cha==ch)
            {
               counter++;
            }
        }
        System.out.println("No. of "+ch+" present are : "+counter);
    }

}