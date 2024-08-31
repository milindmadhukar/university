import java.util.*;
class ReverseCharacters
{
    Scanner sc=new Scanner(System.in);
    void main()
    {
        String a[]=new String[100],s,tmp="";
        char ch;int i,j;
        System.out.print("Enter the sentence whose words are to be reversed: ");
        s=sc.nextLine();
        s=s.concat(" ");
        for(i = 0 ;i < a.length ; i++)
        a[i] = "";
        for(i=0,j=0;i<s.length();i++)
        {
            ch=s.charAt(i);
            if(ch==' ')
            {
                a[j]=tmp;
                j++;
                tmp="";
            }
            else
            {
                tmp=ch+tmp;
            }
        }
        for(i=0;i<s.length();i++)
        {
            System.out.print(a[i]+" ");
        }
   }
}
