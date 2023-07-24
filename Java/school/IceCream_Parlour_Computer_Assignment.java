import java.util.* ;
class IceCream_Parlour_Computer_Assignment
{
    Scanner sc = new Scanner(System.in);
    int choice = 0,scoops = 0,total = 0;
    double GST_Total = 0 ;
    void main()
    {
        System.out.println("Welcome to Golwala Ice Cream Parlour\n");
        System.out.println("The Menu is : ");
        System.out.println("1. Vanilla           - 40Rs  per Scoop"); 
        System.out.println("2. Choclate          - 50Rs  per Scoop"); 
        System.out.println("3. Strawberry        - 60Rs  per Scoop"); 
        System.out.println("4. Golwala's Special - 100Rs per Scoop\n"); 
        System.out.print("Enter your Choice : ");
        choice = sc.nextInt();
        if(choice<5 && choice>0)
        {
            System.out.print("Enter the Number of Scoops : ");
            scoops = sc.nextInt();
            switch (choice)
            {
              case 1 :
              total = 40 * scoops;
              break ;
              case 2 :
              total = 50 * scoops;
              break ;
              case 3 :
              total = 60 * scoops;
              break ;
              case 4 :
              total = 100 * scoops;
              break ;
            }
            System.out.println("Your total is : "+total+" Rs");
            GST_Total =1.18 * total ;
            System.out.println("Amount Payable (Inclusive of Taxes): " +Math.round(GST_Total)+" Rs");
        }
        else
        {
            System.out.println("Wrong Choice\nDon't Try to fool my Program : D \n ( ͡° ͜ʖ ͡°)");
        }
    }
}