import java.util.* ;
class SwapV
{
    Scanner sc = new Scanner(System.in);
    void main()
    {
        System.out.println("Enter X") ;
        int x = sc.nextInt();
        System.out.println("Enter Y") ;
        int y = sc.nextInt();
        System.out.println("The Values of X and Y are : " +x+ " and " +y);
        swap(x,y);
        System.out.println("The Values of X and Y are : " +x+ " and " +y);
    }
    void swap(int a ,int b)
    {
        System.out.println("The Values of X and Y are : " +a+ " and " +b);
        int temp ;
        temp = a ;
        a = b;
        b = temp ;
        System.out.println("The values of X and Y are : " +a+ " and " +b);
        return ;
    }
}
        
        