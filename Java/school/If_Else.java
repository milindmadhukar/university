import java.util.* ;
class If_Else
{
    Scanner sc = new Scanner (System.in);
    void main()
    {
        System.out.println("Enter A");
        int a = sc.nextInt();
        System.out.println("Enter B");
        int b = sc.nextInt();
        Ifelse(a,b);
    }
    void Ifelse(int a , int b)
    {
        if(a>b)
        {
            System.out.println("A is greater than B");
        }
        else if(b>a)
            {
               System.out.println("B is greater than A"); 
            }
        else if(a==b) 
            {
                System.out.println("A is equal to B");
            }
        }
    }
