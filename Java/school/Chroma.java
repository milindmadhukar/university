import java.util.*;
class Chroma
{
    Scanner sc = new Scanner(System.in);
    Date currentDate = new Date();
    String name,password,repass;
    int ch;
    String Mobile[] =
    {
        "APPLE : iPhone 8+","APPLE : iPhone X","APPLE : iPhone Xs","APPLE : iPhone Xs Max",
        "OPPO : F9 PRO","VIVO : V11 PRO","ONE PLUS : 6t","SAMSUNG : GALAXY NOTE 9"
    };
    double price[]=
    {
        70000.0,80000.0,90000.0,100000.0,30000.0,20000.0,40000.0,60000.0
    };
    void display()
    {
       boolean flag = false;
        do{
        System.out.println("DATE :- " + currentDate);
        System.out.println("        CHROMA ELECTRONIC STORE");
        System.out.println("===========================================");
        System.out.println("SIGN UP : ");
        System.out.print("USERNAME : ");
        name = sc.next();
        System.out.print("\nPASSWORD(1-8 characters) : ");
        password = sc.next();
        System.out.print("\nRE-ENTER PASSWORD(1-8 characters) : ");
        repass = sc.next();
        if(password.length()>8)
         {
          System.out.println("EXCESS CHARACTERS");
          System.out.println("PRESS ANY KEY TO CONTINUE");
          String q = sc.next();
          System.out.println("\f");
         }
        else
         {
          flag = true;
         }
        if(!(password.equals(repass)))
         {
          System.out.println("BOTH PASSWORDS DONOT MATCH");
          System.out.println("PRESS ANY KEY TO CONTINUE");
          String q = sc.next();
          System.out.println("\f");
         }
         else
         {
             flag = true;
         }
       }while(flag!=true);
        System.out.println("PRESS ANY KEY TO CONTINUE");
        String q = sc.next();
        System.out.println("\f");
    }
    void showMobile()
    {
        int i;
        boolean flag = false;
        do{
         System.out.println("DATE :- " + currentDate);
         System.out.println("           WELCOME TO CHROMA ELECTRONIC STORE");
         System.out.println("YOU WILL GET AN ADDITIONAL 10% DISCOUNT FOR YOUR FIRST PURCHASE");
         System.out.println("=================================================================="); 
         System.out.println("THESE ARE OUR VARIOUS PRODUCTS :-");
         for(i = 0;i<8;i++)
         {
            System.out.println((i+1) + ". " + Mobile[i] + "    :-  " + price[i] );
         }
         System.out.println("ENTER CHOICE : ");
         ch = sc.nextInt();
         if(ch<1 || ch>8)
         {
           System.out.println("INCORRECT CHOICE");
           System.out.println("PRESS ANY KEY TO CONTINUE");
           String q = sc.next();
           System.out.println("\f");
         }
         else
         {
            flag = true;
         }
        }while(flag!=true);
        System.out.println("PRESS ANY KEY TO CONTINUE");
        String q = sc.next();
        System.out.println("\f");
    }
    void main()
    {
        display();
        showMobile();
        double a = price[ch-1];
        double tb = a - (a*0.1);
        System.out.println("DATE :- " + currentDate);
        System.out.println("        CHROMA ELECTRONIC STORE");
        System.out.println("===========================================");
        System.out.println("USERNAME : " + name);
        System.out.println("===========================================");
        System.out.println("Mobile NAME : " + Mobile[ch-1]);
        System.out.println("PRICE  : Rs." + price[ch-1]);
        System.out.println("DISCOUNT : 10%");
        System.out.println("TOTAL BILL : Rs." + tb);
        System.out.println("===========================================");
    }
}