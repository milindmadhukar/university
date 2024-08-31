import java.util.* ;
class If_Ladder
{
    Scanner sc = new Scanner(System.in);
    void main()
    {
        System.out.println("Enter A");
        long a = sc.nextLong();
        System.out.println("Enter B");
        long b = sc.nextLong();
        System.out.println("Enter C");
        long c = sc.nextLong();
        If_ladder(a,b,c);
    }
    void If_ladder(long a , long b , long c)
    {
        if(a>b)
        {
         if (a>c)
         System.out.println("A is the largest of all 3");
         else
         System.out.println("C is the largest of all 3");
        }
        if(b>c)
        {
            if(b>a)
            System.out.println("B is the largest of all 3");
            else
            System.out.println("C is the largest of all 3");
        }
    }
}