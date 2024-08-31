import java .util.*;
class Cafe_Bhaijaan
{
    Scanner sc =new Scanner (System .in);
    String s;
    int qty,cost,tot;
    void main()
    {
        int ch;
        Outer:
       while(true)
       
       {
        System.out.println("WELCOME TO BHAI-JAAN CAFE!!!!");
        System.out.println("Today's Menu (:\n1.Tea\n2.Coffee\n3.Eatables\n4.Exit  :- ");
        System.out.println("Select the  option number to carry the operation   :-");
        ch=sc.nextInt();
        switch(ch)
        {
            case 1:
            tea();
            break;
            case 2:
            coffee();
            break;
            case 3:
            eatables();
            break;
            case 4:
            System.out.println("Thank You :Please do come again");
           
            break Outer;
        }
      }
    }
   void tea()
    {
        int ch;
        System.out.println("The options in coffee are (:\n1.Desi\n2.Videshi ");
        System.out.print("Select the  option number to have the tea:-   ");
        ch=sc.nextInt();
        
        switch(ch)
        {
            case 1:
            desi() ;
            break;
            case 2:
            videshi() ;
            break;
            
            
        }
    }
       void desi()
       {
           int ch;
        System.out.println("The options in desi tea are (:\n1.Eliachi Chai              Rs 10\n2.Mazedaar Chai               Rs 50        \n3.Special Exotic Bhaijaan Chai     Rs 100 ");
        System.out.print("Select the  option number to have the beverage:-   ");
        ch=sc.nextInt();
        System.out.print("Select the  quantity of the beverage :-   ");
        qty=sc.nextInt(); 
        switch(ch)
        {
            case 1:s="Eliachi Chai";
            cost=10 ;
            break;
            case 2:s="Mazedaar Chai   ";
            cost=50;
            break;
            case 3:s="Special Exotic Bhaijaan Chai";
            cost=100;
            break;
        }
        tot=cost*qty;
        bill();
        }
       void videshi()
       {
        int ch;
        System.out.println("The options in videshi tea are (:\n1.Green Tea    Rs 50\n2.Black Tea     Rs 100\n3. Chai Latte    Rs 160");
        System.out.print("Select the  option number to have the beverage:-   ");
        ch=sc.nextInt();
        System.out.print("Select the  quantity of the beverage :-   ");
        qty=sc.nextInt(); 
        switch(ch)
        {
            case 1:s="Green Tea";
            cost=50 ;
            break;
            case 2:s="Black Tea ";
            cost=100;
            break;
            case 3:s="Chai Latte";
            cost=160 ;
            break;
            
        }
        tot=cost*qty;
        bill();
        
        }
        
   
   void coffee()
    {
        int ch;
        System.out.println("The options in coffee are (:\n1.Cold\n2.Hot ");
        System.out.print("Select the  option number to have the tea:-   ");
        ch=sc.nextInt();
        
        switch(ch)
        {
            case 1:
            hot() ;
            break;
            case 2:
            cold() ;
            break;
            
            
        }
    }
    void hot()
       {
           int ch;
        System.out.println("The options in hot coffee are (:\n1. Hot Mocha    Rs 150\n2.Cafe Latte     Rs 200\n3. Cappuccino   Rs 600 ");
        System.out.print("Select the  option number to have the beverage :-   ");
        ch=sc.nextInt();
        System.out.print("Select the  quantity of the beverage :-   ");
        qty=sc.nextInt(); 
        switch(ch)
        {
            case 1:s="Hot Mocha ";
            cost=150 ;
            break;
            case 2:s="Cafe Latte " ;
            cost=200;
            break;
            case 3:s="Cappuccino ";
            cost=600 ;
            break;
           
        }
        tot=cost*qty;
        bill();
        }
        void cold()
       {
           int ch;
        System.out.println("The options in cold coffee are (:\n1. Iced Coffee   Rs 250\n2.Nitro Cold Brew     Rs 300\n3.Midnight Mocha   Rs 600\n4.Apple Pie Frappuccino   Rs 1000 ");
        System.out.print("Select the  option number to have the beverage :-   ");
        ch=sc.nextInt();
        System.out.print("Select the  quantity of the beverage :-   ");
        qty=sc.nextInt(); 
        switch(ch)
        {
            case 1:s=" Iced Coffee ";
            cost=50 ;
            break;
            case 2:s="Nitro Cold Brew" ;
            cost=100;
            break;
            case 3:s="Midnight Mocha  ";
            cost=600 ;
            break;
            case 4:s="Apple Pie Frappuccino ";
            cost=1000;
            break;
        }
        tot=cost*qty;
        bill();
        }
        
     void eatables()
    {
        int ch;
        System.out.println("The options in eatables are (:\n1. French Fries   Rs 250\n2.Special Double layered Sandwich     Rs 200\n3.Normal Sandwich   Rs 150\n4.Ice Cream(Any Flavour)   Rs 100 ");
        System.out.print("Select the  option number to have the eatable :-   ");
        ch=sc.nextInt();
        System.out.print("Select the  quantity of the eatable :-   ");
        qty=sc.nextInt(); 
        switch(ch)
        {
            case 1:s=" French Fries ";
            cost=250 ;
            break;
            case 2:s="Special Double layered Sandwich" ;
            cost=200;
            break;
            case 3:s="Normal Sandwich  ";
            cost=150 ;
            break;
            case 4:s="Ice Cream(Any Flavour) ";
            cost=100;
            break;
        }
        tot=cost*qty;
        bill();
    }
       
    
    void bill()
    {
        System.out.println("          BILL");
        System.out.println("========================= \n      BHAI-JAAN CAFE ltd");
        System.out.println("=============================================");
        System.out.println("Product Name\tQuantity\tPrice\tCost");
        System.out.println(     s +"\t"+qty+"       \t"+cost+"\t"+tot);
        System.out.println("GST apillied=18% ");
        System.out.println("=================================================");
        System.out.println("Total Bill=    "+((tot*0.18)+tot));
        
    }
}
