import java.util.*;
class Shop
{
    String basket[][] = {{"Toothpaste  ","20","50"},{"Pen         ","50","100"},{"KeyBoard    " ,"1000","5"},{"Bottle      ","100","20"},{"DJ Turntable","60000","2"}};
    Scanner sc = new Scanner(System.in);
    int j = 0,choice = 0 ,qty,price,ch,total,sr = 1;
    String Printer = "",Final_Printer = "";
    double gst,gst_val,gst_amt;
    void main()
    {
        System.out.println("Welcome To Pewds Store:");
        do
        {
            System.out.println("\n1)Choose a product\n2)Stock Check\n3)Print Bill");
            System.out.print("Enter Choice : ");
            ch = sc.nextInt();
            switch(ch)
            {
            case 3:
                display();
                break;
            case 2:
                System.out.println("Sr.No\tName        - Stock Left");
                for(int i = 0 ; i < 5 ; i++)
                    System.out.print((i+1)+"]\t" +  basket[i][j] +" - " + basket[i][j+2]+"\n");
                  break;
            case 1:
            {
                for(int i = 0 ; i < 5 ; i++)
                    System.out.print((i+1)+"] " +  basket[i][j] +" - " + basket[i][j+1]+" Rs.\n");
                System.out.print("Enter Choice : ");
                choice = sc.nextInt();
                System.out.print("Enter Quantity : ");
                qty = sc.nextInt();
                switch(choice)
                {
              case 1:
              case 2:
              case 3:
              case 4:
              case 5:
            if(qty <= Integer.valueOf(basket[choice - 1][2]))
            {
                int a =  Integer.valueOf(basket[choice - 1][2]);
                a -= qty;
                basket[choice - 1][2] = Integer.toString(a);
                price = qty*Integer.valueOf(basket[choice - 1][1]);
                bill();
            }
            else
                System.out.println("That Quantity is out of stock " );
            break;
            default:
            System.out.println("Enter Correct Choice ! " );
        }
        total += price;
        }
        break;
        default:
        System.out.println("Enter Correct Choice ! " );
    }
    }while(ch != 3);
    }
    void bill()
    {
        Printer =sr+"]\t"+ basket[choice - 1][0] + "   " + basket[choice - 1][1] + " Rs\t"+qty+"\t\t"+price+" Rs\n";
        Final_Printer += Printer;
        sr++;
    }
    void display()
    {
        if(Final_Printer.equals(""))
        System.out.println("\nNothing Purchased !!");
        else
        {
        System.out.println("Bill is as Follows: ");
        System.out.println("============================================================");
        System.out.println("                          BILL                              ");
        System.out.println("                       Pewds Store™                         ");
        System.out.println("============================================================");
        System.out.println("Sr.No \tProduct Name   Price  \tQuantity\tFinal Price");
        System.out.print(Final_Printer);
        System.out.println("                                               =============");
        System.out.println("                                                "+total+" Rs");
        System.out.println("============================================================");
        GST();
        }
    }
    void GST()
    {
        gst = 0.18;//18%
        gst_val = total*gst;
        gst_amt = total + gst_val;
        System.out.println("GST Percentage = 18%");
        System.out.println("GST = Rs "+Math.round(gst_val));
        System.out.println("Final Amount to be paid = Rs "+Math.round(gst_amt));
        System.out.println("============================================================");
    }
}