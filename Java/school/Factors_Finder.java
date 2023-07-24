import java.util.*;
class Factors_Finder
{
    Scanner sc = new Scanner(System.in);
    void main(int  n)
    {
        int i = 0;
        while(i < n )
        {
            i++;
            if(n%i == 0)
            System.out.println(i);
        }
      }   
        
    }