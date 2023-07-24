import java.util.*;
class Calculator
{
    
    void main()
    {
        double a,b,x,ans ;
        Scanner sc = new Scanner (System.in);
        System.out.println("Enter the first number");
        a = sc.nextDouble();
        System.out.println("Enter the second number");
        b = sc.nextDouble();
        System.out.println("Enter 1 for Addition");
        System.out.println("Enter 2 for Subtraction");
        System.out.println("Enter 3 for Multiplication");
        System.out.println("Enter 4 for Division");
        System.out.println("Enter 5 for Modulus");
        System.out.println("No other value will be accepted");
        x = sc.nextDouble();
        if (x == 1){
        add(a,b);}
        if (x == 2){
        sub(a,b);}
        if (x == 3){
        multiply(a,b);}
        if (x == 4){
        divide(a,b);}
        if (x == 5){
        mod(a,b);}
        else{
            System.out.println("Ja be mera program tere faltu tricks se immune hai....");
        }
    }
    
    double add(double x , double y)
    {
        double ans ;
        ans = x + y ; 
        System.out.println(x+" + "+y+ " = " +ans);
        return ans ;
        
    }
    
    double sub(double x , double y)
    {
        double ans ;
        ans = x - y ; 
        System.out.println(x+" - "+y+ " = " +ans);
        return ans ;
        
    }
    
    double multiply(double x , double y)
    {
        double ans ;
        ans = x * y ; 
        System.out.println(x+" * "+y+ " = " +ans);
        return ans ;
        
    }
    
    double divide(double x , double y)
    {
        double ans ;
        ans = x / y ; 
        System.out.println(x+" / "+y+ " = " +ans);
        return ans ;
        
    }
    
    double mod(double x , double y)
    {
        double ans ;
        ans = x % y ; 
        System.out.println(x+" % "+y+ " = " +ans);
        return ans ;
        
    }
}
    
   
