import java.util.*;
class Square_Sqrt
{
    
    void main()
    {
        int a,square,sqrt ;
        Scanner sc = new Scanner (System.in);
        System.out.println("Enter the first number");
        a = sc.nextInt();
        square(a);
        sqrt(a);
    }
    
    int square(int x)
    {
        int square ;
        square = (int)Math.pow(x,2) ; 
     
        return square ;
        
    }
    double sqrt(double square)
    {
        double sqrt ;
        sqrt = Math.sqrt(square) ; 
        System.out.println("The square root of"+ square + " is = " + sqrt);
        return sqrt;

    }
}
    
   
