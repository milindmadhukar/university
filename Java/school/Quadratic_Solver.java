import java.util.*;
class Quadratic_Solver
{
    Scanner sc = new Scanner(System.in);
    double r1,r2;
    void main()
    {
        System.out.println("Enter a,b,c in the following Quadratic : \nax^2 + bx + c = 0");
        System.out.print("a = ");
        double a = sc.nextInt();
        System.out.print("b = ");
        double b = sc.nextInt();
        System.out.print("c = ");
        double c = sc.nextInt();
        System.out.println("Your Quadratic Equation is as follows : \n("+a+")x^2 + ("+b+")x + ("+c+" = 0");
        if(((Math.pow(b,2))) - (4*a*c) == 0)
        {
            System.out.println("The Roots of your equation are real and equal ! \nThe Roots are : ");
            r1 =(-1*b)/2*a + (Math.sqrt((Math.pow(b,2)) - (4*a*c)))/2*a;
            r2 =(-1*b)/2*a - (Math.sqrt((Math.pow(b,2)) - (4*a*c)))/2*a;
            System.out.println(r1+"\t"+r2);
        }
        if(((Math.pow(b,2))) - (4*a*c) > 0) 
        {
            if(((Math.pow(b,2))) - (4*a*c) == Math.sqrt(((Math.pow(b,2))) - (4*a*c))*Math.sqrt(((Math.pow(b,2))) - (4*a*c)))
            {
               System.out.println("The Roots of your equation are real and distinct and Rational ! \nThe Roots are : ");
               r1 =(-1*b)/2*a + (Math.sqrt((Math.pow(b,2)) - (4*a*c)))/2*a;
               r2 =(-1*b)/2*a - (Math.sqrt((Math.pow(b,2)) - (4*a*c)))/2*a;
               System.out.println(r1+"\t"+r2);
            }
            else
            {
               System.out.println("The Roots of your equation are real and distinct and Irrational ! \nThe Roots are : ");
               r1 =(-1*b)/2*a + (Math.sqrt((Math.pow(b,2)) - (4*a*c)))/2*a;
               r2 =(-1*b)/2*a - (Math.sqrt((Math.pow(b,2)) - (4*a*c)))/2*a;
               System.out.println(r1+"\t"+r2);
            }
        }
        if(((Math.pow(b,2))) - (4*a*c) < 0)
        {
            System.out.println("The Roots of your equation are Imaginary and Distinct!");
        }
        System.out.println("Sum of Roots : "+-1*b/a);
        System.out.println("Product of Roots : "+c/a);
        System.out.println("Your Quadratic Was :"+ a+"x^2 -"+(r1+r2)+"x +"+r1*r2 );
    }
}