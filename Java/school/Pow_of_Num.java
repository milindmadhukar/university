import java.util.* ;
class Pow_of_Num
{
    Scanner sc = new Scanner(System.in);
    void main()
    {
        System.out.println("This is a Program to Print First 10 Powers of a Number\nEnter a Number:");
        int num = sc.nextInt();
        for(int i = 1 ; i <= 10 ; i++)
        {
            System.out.println(num+"^"+i+"="+Math.round(Math.pow(num,i)));
        }
    }
}