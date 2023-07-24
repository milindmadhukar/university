import java.util.*;
class SwapV_R
{
    int x = 0 , y = 0;
    Scanner sc= new Scanner(System.in);
    void main()
    {
        SwapV_R obj = new SwapV_R();
        System.out.print("Enter X,Y: ");
        x = sc.nextInt();
        y = sc.nextInt();
        System.out.println("Swapping Value :");
        System.out.println("X = "+x+" , Y = "+y);
        SwapV(x,y);
        System.out.println("X = "+x+" , Y = "+y);
        System.out.println("Swapping Reference :");
        obj.x = x;
        obj.y = y;
        System.out.println("X = "+x+" , Y = "+y);
        SwapR(obj);
        System.out.println("X = "+x+" , Y = "+y);
    }
    void SwapV(int x,int y)
    {
        System.out.println("X = "+x+" , Y = "+y);
        int temp;
        temp = x ;
        x = y;
        y = temp;
        System.out.println("X = "+x+" , Y = "+y);
    }
    void SwapR(SwapV_R obj1)
    {
        System.out.println("X = "+obj1.x+" , Y = "+obj1.y);
        int temp;
        temp = obj1.x;
        obj1.x = obj1.y;
        obj1.y = temp;
        System.out.println("X = "+obj1.x+" , Y = "+obj1.y);
    }
}
