/* Write a program in which : Accept Employee Name and basic amount,
 * Calculate :
 * DA = 15 % of Basic
 * HRA = 12 % of Basic
 * income = basic + DA + HRA
 * PF = 13 % of Basic
 * IT = 8 % of Basic
 * Deduction = IT + PF
 * Net Salary = income - Deduction
 * Net Salary
 * Print All Calculated Values
 */
import java.util.*;
class Salary_Array
{
    String name[] = new String [1];
    int basic[] = new int [1];
    double DA[] = new double [1]; //Dearness Allowance
    double HRA[] = new double [1]; //House Rent Allowance
    double income[] = new double [1];
    double PF[] = new double [1]; // Provident Funds
    double IT[] = new double [1]; //income Tax
    double deduction[] = new double [1];
    double net[] = new double [1];
    int i = 0;
    Scanner sc = new Scanner(System.in);
    void input()
    {
        for(;i < 1 ; i++)
        {
            System.out.print("Enter Name : ");
            name[i] = sc.next();
            System.out.print("Enter Basic Salary : ");
            basic[i] = sc.nextInt();
            calc();
        }
    }
    void calc()
    {
        DA[i] = 15/100.0 * basic[i];
        HRA[i] = 12/100.0 * basic[i] ;
        income[i] = basic[i] + DA[i] + HRA[i] ;
        PF[i] = 13/100.0 * basic[i] ; 
        IT[i] = 8/100.0 * basic[i] ;
        deduction[i] = IT[i] + PF[i] ;
        net[i] = income[i] - deduction[i] ;
        display();
    }
    void display()
    {
        System.out.println("Hello "+name[i]);
        System.out.println("Basic Salary : "+basic[i]);
        System.out.println("Dearness Allowance : "+DA[i]);
        System.out.println("House Rent Allowance : "+HRA[i]);
        System.out.println("income : "+income[i]);
        System.out.println("Provident Funds : "+PF[i]);
        System.out.println("income Tax : "+IT[i]);
        System.out.println("Deduction :  "+deduction[i]);
        System.out.println("Net Salary "+net[i]);
    }
}
      