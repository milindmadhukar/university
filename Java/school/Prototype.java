import java.util.*;
class Prototype
{
    Scanner sc = new Scanner(System.in);
    int a = 3 ; boolean c = false;int k;
    void main()
    {
        do
        { 
            c = ++a <= 5;
            k = c?1:0;
            System.out.println(a*k);
        }
        while(c);
    }
}