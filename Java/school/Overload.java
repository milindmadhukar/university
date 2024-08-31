import java.util.*;
class Overload
{
    void print(char ch)
    {
        if(Character.isUpperCase(ch))
        ch = Character.toLowerCase(ch);
        else if(Character.isLowerCase(ch))
        ch = Character.toUpperCase(ch);
        System.out.println(ch+" - "+(int)ch);
    }
    void print(int x , int y)
    {
        int greater = Math.max(x,y);
        int smaller = Math.min(x,y);
        System.out.println(greater/smaller);
    }
    void print(char ch , String s)
    {
        int ctr = 0;
        for(int i = 0 ; i < s.length() ; i++)
        {
            if(s.charAt(i) == ch)
            ctr++;
        }
        System.out.println(ctr);
    }
}