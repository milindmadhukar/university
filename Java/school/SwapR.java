import java.util.* ;
class SwapR
{
    int x,y;
    Scanner sc = new Scanner(System.in);
    void main()
    {
        SwapR obj = new SwapR();
        System.out.println("Enter The Value of X : ");
        obj.x = sc.nextInt();
        System.out.println("Enter The Value of X : ");
        obj.y = sc.nextInt();
        System.out.println("The Values of X and Y are : " +obj.x+ " and " +obj.y);
        Swapper(obj);
        System.out.println("The Values of X and Y are : " +obj.x+ " and " +obj.y);
    }
    void Swapper(SwapR aa)
    {
        System.out.println("The Values of X and Y are : " +aa.x+ " and " +aa.y);
        int temp ;
        temp = aa.x ;
        aa.x = aa.y;
        aa.y = temp ;
        System.out.println("The Values of X and Y are : " +aa.x+ " and " +aa.y);
        return ;
    }
}