import java.util.*;
class Trigo
{
    Scanner sc = new Scanner (System.in);
    void main()
    {
        System.out.print("Enter Theta In Degrees : ");
        int deg = sc.nextInt();
        double rad = deg/Math.PI;
        
        System.out.println(Math.cos(rad));
    }
}