/* Write a program in which : Accept Employee Name and basic amount , Calculate :
 * DA = 15 % of Basic
 * HRA = 20 % of Basic
 * Income = Basic + DA + HRA
 * PF = 10 % of Basic
 * IT = 13 % of Basic
 * Deduction = IT + PF
 * Net Salary = Income - Deduction
 * Print Net Salary
 */
import java.util.* ;
class Net_Salary
{
    void main()
    {
        String name ;
        double basic, DA,HRA,Income,PF,IT,deduction,net ;
        Scanner sc = new Scanner (System.in) ;
        System.out.println("Enter your name " );
        name = sc.nextLine() ;
        System.out.println("Enter Basic Amount ");
        basic = sc.nextDouble() ;
        DA = 15/100.0 * basic;
        HRA = 20/100.0 * basic ;
        Income = basic + DA + HRA ;
        PF = 10/100.0 * basic ; 
        IT = 13/100.0 * basic ;
        deduction = IT + PF ;
        net = Income - deduction ;
        System.out.println("Hello " + name);
        System.out.println("Your Basic Income is :  = " + basic);
        System.out.println("Your Dearness Allowance =  " + DA);
        System.out.println("Your House Rent Allowance = " + HRA);
        System.out.println("Your Income = " + Income);
        System.out.println("Your Provident Funds = " + PF);
        System.out.println("Your Income Tax = " + IT);
        System.out.println("Your Deduction = " + deduction);
        System.out.println("Your Net Salary = " + net);
    }
}
        