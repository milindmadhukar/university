import java.util.*;
class Charges
{
    int charge;
    Scanner sc=new Scanner(System.in); 
    void main()
    {
        System.out.print("Enter name: ");
        String name=sc.next();
        System.out.print("Enter weight in kg: ");
        int w=sc.nextInt();
        if(w<=10)
        charge=w*30;
        else 
        if(w<=30)
        charge=300+(w-10)*20;
        else
        if(w<=50)
        charge=300+400+(w-30)*10;
        else
        if(w<=100)
        charge=300+400+200+(w-50)*5;
        System.out.println("Sr.no.\tName\t\tWeight\tNetAmount\n1\t"+name+"\t\t"+w+"\t"+charge);
    }
}