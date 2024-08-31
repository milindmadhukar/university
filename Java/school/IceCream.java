import java.util.* ;
class IceCream
{
   Scanner sc = new Scanner(System.in);
   int choice = 0,scoops = 0,total = 0,new_total = 0,loop_counter = 1;;
   double GST_Total = 0 ;
    void Menu()
    {
        System.out.println("Welcome to Golwala Ice Cream Parlour\n");
        System.out.println("The Menu is : ");
        System.out.println("1. Vanilla           - 40Rs  per Scoop"); 
        System.out.println("2. Choclate          - 50Rs  per Scoop"); 
        System.out.println("3. Strawberry        - 60Rs  per Scoop"); 
        System.out.println("4. Golwala's Special - 100Rs per Scoop\n");
        Selection();
    }
    void Selection()
    {
        while(loop_counter != 0)
        {
           System.out.print("\nEnter your Choice : ");
           choice = sc.nextInt();
           if(choice >= 1 && choice <= 4)
           {
                switch (choice)
               {
                   case 1 :
                   System.out.print("Enter Number Of Scoops: ");
                   scoops = sc.nextInt();
                   total = 40 * scoops;
                   System.out.println("You chose " + scoops + " scoop(s) of Vanilla !");
                   break ;
                   case 2 :
                   System.out.print("Enter Number Of Scoops: ");
                   scoops = sc.nextInt();
                   total = 50 * scoops;
                   System.out.println("You chose " + scoops + " scoop(s) of Choclate !");
                   break ;
                   case 3 :
                   System.out.print("Enter Number Of Scoops: ");
                   scoops = sc.nextInt();
                   total = 60 * scoops;
                   System.out.println("You chose " + scoops + " scoop(s) of Strawberry !");
                   break ;
                   case 4 :
                   System.out.print("Enter Number Of Scoops: ");
                   scoops = sc.nextInt();
                   total = 100 * scoops;
                   System.out.println("You chose " + scoops + " scoop(s) of Golwala's Special !");
                   break ;
               }
            }
            else
            {
              System.out.println("Don't Try to Fool My Program ! :D ");
            }
            new_total = new_total + total;
            System.out.print("\nEnter Any Number If You Want To Buy Again or Enter 0 for Final Bill: ");
            loop_counter = sc.nextInt();
            BillCalculator();
        }
    }
    void BillCalculator()
    {
        if(loop_counter == 0 && new_total != 0)
        { 
            System.out.println("\nYour total is : "+new_total+" Rs");
            GST_Total =1.18 * new_total ;
            System.out.println("Amount Payable (Inclusive of Taxes): " +Math.round(GST_Total)+" Rs");
        }
        if(new_total == 0 )
        {
            System.out.println("Don't Try to Fool My Program ! :D ");
        }
    } 
}
