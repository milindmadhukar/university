import java.util.*;
class Pronic_Number
{
    Scanner sc = new Scanner(System.in);
    boolean protic = false;
    void main()
    {
        System.out.print("Enter a Number to Check Whether it is Pronic or not : ");
        int num = sc.nextInt();
        for(int i = 0 ; i <= num ; i++)
        {
            if(i*(i+1) == num)
            {
               protic = true;
               break;
            }
            else
            protic = false ;
        }
        if(protic == true)
        System.out.println("This is a Protic Number ");
        else
        System.out.println("This is not a Protic Number ");
    }
}