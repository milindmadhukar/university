import java.util.* ;
class Swap_Combined
{
    int x,y;
    Scanner sc = new Scanner(System.in);
    void main()
    {
        System.out.print("Enter X : ");
        x = sc.nextInt();
        System.out.print("Enter Y : ");
        y = sc.nextInt();
        SwapV(x,y);
        System.out.println("x = "+x+", y = "+y);
        Swap_Combined obj = new Swap_Combined();
        obj.x = x ;
        obj.y = y ;
        SwapR(obj);
        System.out.println("x = "+obj.x+", y = "+obj.y);
    }
    void SwapV(int x ,int y)
    {
        int temp = 0;
        temp = x ;
        x = y ;
        y = temp ;
        System.out.println("x = "+x+", y = "+y);
    }
    void SwapR(Swap_Combined aa)
    {
        int temp = 0 ;
        temp = aa.x ;
        aa.x = aa.y ;
        aa.y = temp;
        System.out.println("x = "+aa.x+", y = "+aa.y);
    }
    /////s///s/c///c/c;;;;;;;;sskkkkkkcc,,,;,,coo,k;;;oolomkhjjcj
}