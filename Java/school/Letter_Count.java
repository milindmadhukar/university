import java.util.*;
class Letter_Count
{
    char cha[] = new char[26];
    int ctr[] = new int[26];
    boolean flag[] = new boolean[26];
    String s = "";
    Scanner sc = new Scanner(System.in);
    char ch = ' ';
    int tmp = 0;
    void main()
    {
        accept();
        count();
        printer();
    }
    void accept()
    {
        System.out.print("Enter A Sentence : ");
        s = sc.nextLine();
        s = s.toUpperCase();
    }
    void count()
    {
        for(int i = 0 ; i < 26 ; i++)
        {
            cha[i] = (char)(65+i);
            ctr[i] = 0;
            flag[i] = false;
        }
        for(int i = 0 ; i < s.length(); i++)
        {
            ch = s.charAt(i);
            Inner:
            for(int j = 0 ; j < 26 ; j++)
            {
                if(ch == cha[j])
                {
                    ctr[j]++;
                    flag[j] = true;
                    break Inner;
                }
            }
        }
    }
    void printer()
    {
        System.out.println("CHARACTER\tFREQUENCY");
        for(int i = 0 ; i < 26 ; i ++)
        {
            if(flag[i])
            {
                System.out.println(cha[i] +"\t\t"+ ctr[i]);
            }
        }
    }
}