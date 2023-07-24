import java.util.*;
class Supermarket
{
    //Data Members

    int ch,i,j,PayDetL,x=0,li,lr,ltp,lq,lt;
    double Quantity[]=new double[30],Rate[]=new double[30],
    TotalPrice[]=new double[30],Total=0,Discount,DiscountAmount,
    GSTAmount,NetTotal=0;
    final double GST=18;
    String Nm,Email,ItemName[]=new String[30],
    Unit[]=new String[30],PaymentDetails[]=new String[7],
    item,r,tp,q;
    long Pn;//phone number
    boolean chk;//Flag variable which becomes false when the 
    //user enters an incorrect choice to let the 
    //user re-enter his choice

    //Arrays are declared to store details of each item for bill printing
    Scanner ob = new Scanner(System.in);

    //Member Methods
    public static void main()
    {
        System.out.println("\f");
        Supermarket S = new Supermarket();
    }

    /*Supermarket() //constructor to begin program 
    //directly on object creation
    {
        welcome();
    }*/

    public void welcome() //printing a star-shaped pattern 
    //using arrays and the welcome message
    {
        int a[]={1,6,5,4,5,6,1},s[]={15,10,11,12,11,10,15};
        //a[] stores the number of asterisks and 
        //s[] stores the number of spaces per row
        String Ss="",Sa="";
        for(i=0;i<7;i++)
        {
            for(j=0;j<a[i];j++)
            {
                Sa=Sa +"*"+"";
            }
            for(j=0;j<s[i];j++)//space loop
            {
                Ss=Ss+" ";
            }
            System.out.println("          "+Ss+Sa);
            Ss=""; //resetting the variable
            Sa=""; //resettind the variable
        }
        System.out.println("\t\tWELCOME TO STARMART!");

        details();
    }

    public void details()
    {
        System.out.println("\n\nENTER NAME");
        Nm=ob.nextLine();
        System.out.println("ENTER PHONE NUMBER");
        Pn=ob.nextLong();
        System.out.println("ENTER EMAIL (FOR SENDING A COPY OF THE BILL)");
        Email = ob.nextLine();
        while(true) //validating e-mail address
        {
            Email=ob.next();
            int At=Email.indexOf('@'),Dot = Email.lastIndexOf('.');
            if(At<3||At>Dot||At==-1||Dot<-1)
            {
                System.out.println("YOUR E-MAIL ADDRESS IS INVALID;PLEASE TRY AGAIN:");
                continue;
            }
            break;
        }
        mainmenu();
    }

    public void mainmenu()
    {
        System.out.println("\n\n\n__________MAIN MENU__________");
        System.out.println("WHICH DEPARTMENT WOULD YOU LIKE TO GO TO?");
        System.out.println("1.FOOD");
        System.out.println("2.PHARMACY");
        System.out.println("3.SANITARY PRODUCTS");
        System.out.println("4.SPORTS");
        System.out.println("ANY OTHER NUMBER TO EXIT");
        System.out.println("ENTER YOUR CHOICE \n");
        ch=ob.nextInt();
        switch(ch)
        {
            case 1:
            food();
            break;

            case 2:
            pharmacy();
            break;

            case 3:
            sanitary();
            break;

            case 4:
            sports();
            break;

            default:
            exit();
        }
    }

    public void food()
    {
        System.out.println("\n\n\n__________MAIN MENU => FOOD__________");
        System.out.println("WHICH SUB-DEPARTMENT WOULD YOU LIKE TO GO TO?");
        System.out.println("1.GROCERY");
        System.out.println("2.DAIRY");
        System.out.println("3.BAKERY");
        System.out.println("4.RETURN TO THE PREVIOUS MENU ");
        System.out.println("ANY OTHER NUMBER TO EXIT");
        System.out.println("ENTER YOUR CHOICE \n");
        ch=ob.nextInt();
        switch (ch)
        {
            case 1:
            grocery();
            break;

            case 2:
            dairy();
            break;

            case 3:
            bakery();
            break;

            case 4:
            mainmenu();
            break;

            default:
            exit();
        }
    }

    public void grocery()
    {
        System.out.println("\n\n\n__________MAIN MENU => FOOD => GROCERY__________");
        System.out.println("WHAT WOULD YOU LIKE TO PURCHASE?");
        do //To let the user re-enter his choice in case of 
        //selection of an incorrect option
        {
            chk=true;
            System.out.println("1.WHEAT");
            System.out.println("2.RICE");
            System.out.println("3.JOWAR");
            System.out.println("4.BAJRA");
            System.out.println("5.RETURN TO PREVIOUS MENU");
            System.out.println("ENTER YOUR CHOICE \n");
            ch=ob.nextInt();
            switch(ch)
            {
                case 1:
                ItemName[x]="WHEAT";
                Rate[x]= 42;
                break;

                case 2:
                ItemName[x]="RICE";
                Rate[x]= 50;
                break;

                case 3:
                ItemName[x]="JOWAR";
                Rate[x]= 20;
                break;

                case 4:
                ItemName[x]="BAJRA";
                Rate[x]= 25;
                break;

                case 5:
                food();
                return;

                default:
                System.out.println("YOU HAVE ENTERED AN INCORRECT OPTION; PLEASE TRY AGAIN.");
                chk = false;
            }
        }while(!(chk));

        System.out.println("\nENTER QUANTITY(IN kg)");
        Quantity[x]=ob.nextDouble();
        Unit[x] = "kg";
        x++;

        buyMore();
    }

    public void dairy()
    {
        System.out.println("\n\n\n__________MAIN MENU => FOOD => DAIRY__________");
        System.out.println("WHAT WOULD YOU LIKE TO PURCHASE?(ONLY AMUL AVAILABLE)");
        do //To let the user re-enter his choice in case of selection of an incorrect option
        {
            chk=true;
            System.out.println("1.MILK");
            System.out.println("2.CHEESE");
            System.out.println("3.BUTTER");
            System.out.println("4.PANEER");
            System.out.println("5.RETURN TO PREVIOUS MENU");
            System.out.println("ENTER YOUR CHOICE \n");
            ch=ob.nextInt();
            switch(ch)
            {
                case 1:
                ItemName[x]="MILK";
                Rate[x]= 52;
                Unit[x]="LITRE(S)";
                break;

                case 2:
                ItemName[x]="CHEESE";
                Rate[x]= 80;
                Unit[x]="PACKET(S)";
                break;

                case 3:
                ItemName[x]="BUTTER";
                Rate[x]= 76;
                Unit[x]="PACKET(S)";
                break;

                case 4:
                ItemName[x]="PANEER";
                Rate[x]= 100;
                Unit[x]="PACKET(S)";
                break;

                case 5:
                food();
                return;

                default:
                System.out.println("YOU HAVE ENTERED AN INCORRECT OPTION; PLEASE TRY AGAIN.");
                chk = false;
            }
        }while(!(chk));

        System.out.println("\nENTER QUANTITY(IN LITRES FOR MILK AND NO.OF 200 GRAM PACKETS FOR THE REST)");
        Quantity[x]=ob.nextDouble();
        x++;

        buyMore();
    }

    public void bakery()
    {
        System.out.println("\n\n\n__________MAIN MENU => FOOD => BAKERY__________");
        System.out.println("WHAT WOULD YOU LIKE TO PURCHASE?");
        do //To let the user re-enter his choice in case of selection of an incorrect option
        {
            chk=true;
            System.out.println("1.BREAD SMALL PACKET");
            System.out.println("2.BREAD LARGE PACKET");
            System.out.println("3.FRUIT CAKE");
            System.out.println("4.RETURN TO PREVIOUS MENU");
            System.out.println("ENTER YOUR CHOICE \n");
            ch=ob.nextInt();
            switch(ch)
            {
                case 1:
                ItemName[x]="BREAD SMALL PACKET";
                Rate[x]= 40;
                break;

                case 2:
                ItemName[x]="BREAD LARGE PACKET";
                Rate[x]= 25;
                break;

                case 3:
                ItemName[x]="FRUIT CAKE";
                Rate[x]= 30;
                break;

                case 4:
                food();
                return;

                default:
                System.out.println("YOU HAVE ENTERED AN INCORRECT OPTION; PLEASE TRY AGAIN.");
                chk = false;

            }
        }while(!(chk));

        System.out.println("\nENTER QUANTITY");
        Quantity[x]=ob.nextDouble();
        Unit[x] = "PACKET(S)";
        x++;

        buyMore();
    }

    public void pharmacy()
    {
        System.out.println("\n\n\n__________MAIN MENU => PHARMACY__________");
        System.out.println("WHAT WOULD YOU LIKE TO PURCHASE?");
        System.out.println("1.CROCIN ADVANCED");
        System.out.println("2.BAND-AID");
        System.out.println("3.SOFRAMYCIM");
        System.out.println("4.BENADRYL COUGH SYRUP");
        System.out.println("5.RETURN TO PREVIOUS MENU");
        System.out.println("ANY OTHER NUMBER TO EXIT");
        System.out.println("OTHER MEDICINES CAN NOT BE PURCHASED ONLINE DUE TO REQUIREMENT \nOF A PRESCRIPTION.WE REGRET THE INCONVENIENCE CAUSED");
        System.out.println("ENTER YOUR CHOICE \n");
        ch=ob.nextInt();
        switch(ch)
        {
            case 1:
            ItemName[x]="CROCIN ADVANCED";
            Rate[x]= 15;
            Unit[x]="STRIP(S)";
            break;

            case 2:
            ItemName[x]="BAND-AID";
            Rate[x]= 2;
            Unit[x]="";
            break;

            case 3:
            ItemName[x]="SOFRAMYCIN";
            Rate[x]= 35;
            Unit[x]="TUBE(S)";
            break;

            case 4:
            ItemName[x]="BENADRYL COUGH SYRUP";
            Rate[x]= 40;
            Unit[x]="BOTTLE(S)";
            break;

            case 5:
            mainmenu();
            return;

            default:
            exit();
            return;
        }

        System.out.println("\nENTER QUANTITY");
        Quantity[x]=ob.nextDouble();
        x++;

        buyMore();
    }

    public void sanitary()
    {
        System.out.println("\n\n\n__________MAIN MENU => SANITARY PRODUCTS__________");
        System.out.println("WHICH SUB-DEPARTMENT WOULD YOU LIKE TO GO TO?");
        System.out.println("1.TOILETRY");
        System.out.println("2.CLEANERS");
        System.out.println("3.RETURN TO THE PREVIOUS MENU ");
        System.out.println("ANY OTHER NUMBER TO EXIT");
        System.out.println("ENTER YOUR CHOICE \n");
        ch=ob.nextInt();
        switch (ch)
        {
            case 1:
            toiletry();
            break;

            case 2:
            cleaners();
            break;

            case 3:
            mainmenu();
            break;

            default:
            exit();

        }
    }

    public void toiletry()
    {
        System.out.println("\n\n\n__________MAIN MENU => SANITARY PRODUCTS => TOILETRY__________");        
        System.out.println("WHAT WOULD YOU LIKE TO PURCHASE?");
        do //To let the user re-enter his choice in case of selection of an incorrect option
        {
            chk=true;
            System.out.println("1.TOOTHPASTE(COLGATE)");
            System.out.println("2.TOOTHBRUSH(COLGATE)");
            System.out.println("3.SOAP(LIFEBUOY)");
            System.out.println("4.FACE WASH");
            System.out.println("5.RETURN TO PREVIOUS MENU");
            System.out.println("ENTER YOUR CHOICE \n");
            ch=ob.nextInt();
            switch(ch)
            {
                case 1:
                ItemName[x]="TOOTHPASTE(COLGATE)";
                Rate[x]= 60;
                Unit[x]="TUBE(S)";
                break;

                case 2:
                ItemName[x]="TOOTHBRUSH(COLGATE)";
                Rate[x]= 20;
                Unit[x]="";
                break;

                case 3:
                ItemName[x]="SOAP(LIFEBUOY)";
                Rate[x]= 15;
                Unit[x]="";
                break;

                case 4:
                ItemName[x]="FACE WASH";
                Rate[x]= 30;
                Unit[x]="";
                break;

                case 5:
                sanitary();
                return;

                default:
                System.out.println("YOU HAVE ENTERED AN INCORRECT OPTION; PLEASE TRY AGAIN.");
                chk = false;

            }
        }while(!(chk));

        System.out.println("\nENTER QUANTITY");
        Quantity[x]=ob.nextDouble();
        x++;

        buyMore();
    }

    public void cleaners()
    {
        System.out.println("\n\n\n__________MAIN MENU => SANITARY PRODUCTS => CLEANERS__________");        
        System.out.println("WHAT WOULD YOU LIKE TO PURCHASE?");
        do //To let the user re-enter his choice in case of 
        //selection of an incorrect option
        {
            chk = true; //resetting variable
            System.out.println("1.DETERGENT");
            System.out.println("2.FLOOR CLEANER");
            System.out.println("3.DETTOL");
            System.out.println("4.BLEACH");
            System.out.println("5.RETURN TO PREVIOUS MENU");
            System.out.println("ENTER YOUR CHOICE \n");
            ch=ob.nextInt();
            switch(ch)
            {
                case 1:
                ItemName[x]="DETERGENT";
                Rate[x]= 45;
                Unit[x]="PACKET(S)";
                break;

                case 2:
                ItemName[x]="FLOOR CLEANER";
                Rate[x]= 50;
                Unit[x]="BOTTLE(S)";
                break;

                case 3:
                ItemName[x]="DETTOL";
                Rate[x]= 20;
                Unit[x]="BOTTLE(S)";
                break;

                case 4:
                ItemName[x]="BLEACH";
                Rate[x]= 30;
                Unit[x]="BOTTLE(S)";
                break;

                case 5:
                sanitary();
                return;

                default:
                System.out.println("YOU HAVE ENTERED AN INCORRECT OPTION; PLEASE TRY AGAIN.");
                chk = false;

            }
        }while(!(chk));

        System.out.println("\nENTER QUANTITY");
        Quantity[x]=ob.nextDouble();
        x++;

        buyMore();
    }

    public void sports()
    {
        int Size_int;
        char Size_char;
        System.out.println("\n\n\n__________MAIN MENU => SPORTS__________");
        System.out.println("WHAT WOULD YOU LIKE TO PURCHASE?");
        System.out.println("1.CRICKET(BAT + 5 BALLS)");
        System.out.println("2.FOOTBALL");
        System.out.println("3.BASKETBALL");
        System.out.println("4.SPIKES");
        System.out.println("5.JERSEY");
        System.out.println("6.RETURN TO PREVIOUS MENU");
        System.out.println("ANY OTHER NUMBER TO EXIT");
        System.out.println("ENTER YOUR CHOICE \n");
        ch=ob.nextInt();
        switch(ch)
        {
            case 1:
            ItemName[x]="CRICKET(BAT + 5 BALLS)";
            Rate[x]= 600;
            break;

            case 2:
            ItemName[x]="FOOTBALL";
            Rate[x]= 400;
            break;

            case 3:
            ItemName[x]="BASKETBALL";
            Rate[x]= 300;

            break;

            case 4:
            System.out.println("ENTER SIZE(NUMBER)");
            Size_int=ob.nextInt();
            ItemName[x]="SPIKES SIZE"+ Size_int;
            Rate[x]= 5000 * (Size_int*0.15);
            break;

            case 5:
            ItemName[x]="JERSEY ";
            Rate[x]= 700;
            break;

            case 6:
            mainmenu();
            return;

            default:
            exit();
            return;
        }

        System.out.println("\nENTER QUANTITY");
        Quantity[x]=ob.nextDouble();
        Unit[x]="";
        x++;

        buyMore();
    }

    public void buyMore() //If the user wishes to buy more
    {
        System.out.println("\n\n\nDO YOU WANT TO BUY MORE???");
        System.out.println("1.YES");
        System.out.println("ANY OTHER NUMBER FOR NO");
        System.out.println("ENTER YOUR CHOICE \n");
        ch=ob.nextInt();

        switch(ch)
        {
            case 1:
            mainmenu();
            return;

            default :
            calculate();
        }
    }

    public void exit()
    {
        System.out.println("\n\n\nDO YOU REALLY WANT TO EXIT???");
        System.out.println("1.NO, I WANT TO SHOP MORE!!!");
        System.out.println("ANY OTHER NUMBER FOR YES");
        System.out.println("ENTER YOUR CHOICE \n");
        ch=ob.nextInt();

        switch(ch)
        {
            case 1:
            mainmenu();
            return;

            default :
            // x = x-1;
            calculate();

        }
    }

    public void calculate() //Calculating total Rate for each item and the total(sum of all Rates)
    {
        for(i=0;i<=x;i++)
        {
            TotalPrice[i]=Quantity[i]*Rate[i];
            Total = Total + TotalPrice[i];
        }

        if(Total<=75)
            Discount = 0;

        else if(Total<=300)
            Discount = 5;

        else if(x<=1000)
            Discount = 10;

        else if(x<= 5000)
            Discount = 12;

        else 
            Discount = 15;

        DiscountAmount=Total*Discount/100.0;
        GSTAmount=(Total - DiscountAmount)*GST/100.0;
        NetTotal=Total-DiscountAmount+GSTAmount;
        NetTotal = Math.rint(NetTotal);  
        bubbleSort();
        largestLength();
        payment();
    }

    public void payment()
    {
        System.out.println("HOW WOULD YOU LIKE TO PAY?");
        do //To let the user re-enter his choice in case of selection of an incorrect option
        {
            chk = true; //resetting variable
            System.out.println("1.MOBILE WALLET");
            System.out.println("2.CREDIT CARD/DEBIT CARD");
            System.out.println("3.CASH ON DELIVERY");
            System.out.println("ENTER YOUR CHOICE \n");
            ch=ob.nextInt();

            switch(ch)
            {
                //asterisks added for security
                case 1:
                PaymentDetails[0]="PAYMENT METHOD          : MOBILE WALLET";
                System.out.println("ENTER PHONE NUMBER");
                PaymentDetails[1]=ob.next();
                PaymentDetails[1]="PHONE NUMBER            : "+PaymentDetails[1].substring(0,PaymentDetails[1].length()-4)+"****";
                System.out.println("ENTER PASSWORD");
                PaymentDetails[2]=ob.next();
                PaymentDetails[2]="PASSWORD                : "+PaymentDetails[2].substring(0,1)+"******************************************************************".substring(0,PaymentDetails[2].length());
                System.out.println("ENTER VERIFICATION CODE");  
                PaymentDetails[3]="VERIFICATION CODE       : "+ob.next() ;
                System.out.println("\nRs. "+ NetTotal + " HAS BEEN SUCCESSFULLY DEDUCTED\n\n");  
                PayDetL=3;
                break;

                case 2:
                PaymentDetails[0]="PAYMENT METHOD          : CREDIT CARD/DEBIT CARD";
                System.out.println("ENTER CARD NUMBER");
                PaymentDetails[1]=ob.next();
                PaymentDetails[1]="CARD NUMBER             : "+PaymentDetails[1].substring(0,PaymentDetails[1].length()-4)+" ****";
                System.out.println("ENTER CARDHOLDER'S NAME");
                PaymentDetails[2]="CARDHOLDER'S NAME       : "+ob.next();
                System.out.println("ENTER CVV");  
                PaymentDetails[3]="CVV                     : "+ob.next().substring(0,1)+"**";
                System.out.println("ENTER VERIFICATION CODE");
                PaymentDetails[4]="VERIFICATION CODE       : "+ob.next();
                System.out.println("\nRs.  "+ NetTotal + " HAS BEEN SUCCESSFULLY DEDUCTED\n\n");  
                PayDetL=4;
                break;

                case 3:
                PaymentDetails[0]="PAYMENT METHOD          : CASH ON DELIVERY";
                PayDetL = 0;
                System.out.println("\n\n");
                break;

                default :
                System.out.println("YOU HAVE ENTERED AN INCORRECT OPTION; PLEASE TRY AGAIN.");
                chk = false;
            }
        }while(!(chk));

        timeLoop();
    }

    public void bubbleSort()  //STORING ITEM NAMES, Rate AND ARRANGING IN INCREASING Rate ORDER
    {
        double a;
        String A;
        for(i=0;i<=x;i++)
        {
            for(j=0;j<x-i-1;j++)
            {
                if(TotalPrice[j]>TotalPrice[j+1])
                {
                    A=ItemName[j];
                    ItemName[j]=ItemName[j+1];
                    ItemName[j+1]=A;

                    a=Rate[j];
                    Rate[j]=Rate[j+1];
                    Rate[j+1]=a;

                    A=Unit[j];
                    Unit[j]=Unit[j+1];
                    Unit[j+1]=A;

                    a=Quantity[j];
                    Quantity[j]=Quantity[j+1];
                    Quantity[j+1]=a;

                    a=TotalPrice[j];
                    TotalPrice[j]=TotalPrice[j+1];
                    TotalPrice[j+1]=a;
                }
            }
        }
    }

    public void timeLoop() //to print a downward arrow pattern using a time loop to print one row at a time(like a basic animation))
    {
        String s="";
        long i1,j1;
        for(i1=0;i1<=90000000l;i1++)//takes longer time 
        {

            if(i1%18000000==0 )
            {
                System.out.println("\t\t\t\t            *   *   *   *   *");
            }
        }

        for(i1=0;i1<=180000000l;i1++)
        {
            if(i1%18000000==0)
            {
                System.out.print("\t\t\t\t"+s);
                for(j1=i1/18000000;j1<=10;j1++)
                {
                    System.out.print("*   ");
                }// inner for loop ends

                System.out.println();//new line
                s=s+"  ";
            }
        }// outer for loop ends
        bill();
    }

    public void largestLength()/* Maintains equal lengths of each row and column of the bill by finding the
     * length of the largest ItemName[x] variable - stored in li
     * length of the largest Rate[x] variable - stored in lr
     * length of the largest quantity[x] variable  - stored in lq
     * length of the largest TotalPrice[x] variable - stored in ltp
     * item stores ItemName[x] to find its length
     * r stores Rate[x] converted to a String to find its length
     * q stores Quantity[x] converted to a String to find its length
     * tp stores TotalPrice[x] converted to a String to find its length
     */ 
    {
        li=1;
        lr=1;
        lq=1;
        ltp=1;
        for(i=0;i<x;i++)
        {
            item = ItemName[i]+"  ";
            r = "Rs. "+Rate[i] ;
            q = Quantity[i]+ Unit[i];
            tp = "Rs. "+TotalPrice[i] ;

            if(lr<r.length())
                lr=r.length();

            if(ltp<tp.length())
                ltp=tp.length();

            if(li<item.length())
                li=item.length();

            if(lq<q.length())
                lq=q.length();

        }
        li=li+5;
        lr=lr+4;
        lq=lq+9;
        ltp=ltp+10;
        lt=li+lr+lq+ltp+17;//total length of all columns added for total bill length
        //these pre-calculated numbers are added so that the length variables are atleast the size of their column headers
    }

    public void bill()
    {
        String a="___________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________";
        String s="                                                                                                                                                                                                                                                                                                                                                                                               ";
        //substrings of the above variables are taken and appended to variables for maintaining column width
        //underscore is used for getting a horizontal line in the bill

        Calendar c = Calendar.getInstance();//for getting the Date
        System.out.println(a.substring(0,lt+1));//horizontal line
        System.out.println("| "+s.substring(0,(lt+1)/2 - 4) + "STARMART" + s.substring(0,(lt+1)/2 - 7)+"  |");//header
        System.out.println(a.substring(0,lt+1));//horizontal line
        System.out.println("| "+s.substring(0,(lt+1)/2 - 2) + "BILL" + s.substring(0,(lt+1)/2 - 5)+"  |");
        System.out.println(a.substring(0,lt+1));//horizontal line
        System.out.println("| "+s.substring(0,lt-19)+"DATE : "+c.get(Calendar.DATE)+ "/"+(c.get(Calendar.MONTH)+1) + "/"+c.get(Calendar.YEAR)+" |");
        System.out.println(a.substring(0,lt+1));//horizontal line

        //printing details
        System.out.println(("| NAME             : " + Nm+s).substring(0,lt)+" |");
        System.out.println(("| PHONE NUMBER     : " + Pn+s).substring(0,lt)+" |");
        System.out.println(("| E-MAIL ADDRESS   : " + Email+s).substring(0,lt)+" |");
        System.out.println(a.substring(0,lt+1));//horizontal line

        for(i=0;i<=PayDetL;i++)//printing payment details
        {
            System.out.println(("| "+PaymentDetails[i]+ s).substring(0,lt)+" |");
        }
        System.out.println(a.substring(0,lt+1));//horizontal line
        System.out.println("| SR. | "+("ITEM NAME"+s).substring(0,li)+" | "+("RATE"+s).substring(0,lr)+ " | "+("QUANTITY"+s).substring(0,lq)+" | " +("TOTAL PRICE"+s).substring(0,ltp)+" |");
        System.out.println(a.substring(0,lt+1));//horizontal line
        for(i=0;i<x;i++)
        {
            item = (ItemName[i] + s).substring(0,li);
            r = ("Rs. " +Rate[i] + s).substring(0,lr);
            q = (Quantity[i] +" " + Unit[i] + s).substring(0,lq);
            tp = ("Rs. " + TotalPrice[i] + s).substring(0,ltp);
            System.out.println("|  "+(i+1)+"  | "+ item+" | " + r+" | "+q+" | "+tp+" | ");

        }

        System.out.println(a.substring(0,lt+1));//horizontal line
        System.out.println(("| TOTAL               = "+Total+s).substring(0,lt)+" |");
        System.out.println(("| DISCOUNT            = "+Discount + "% = " + DiscountAmount+s).substring(0,lt)+" |");
        System.out.println(("| GST                 = "+GST +"% = "+GSTAmount+s).substring(0,lt)+" |");
        System.out.println(("| NET TOTAL           = "+NetTotal+s).substring(0,lt)+" |" );
        System.out.println(("| THANK YOU FOR PURCHASING FROM STARMART!! PLEASE COME AGAIN!!!"+s).substring(0,lt)+" |");
        System.out.println(a.substring(0,lt+1));//horizontal line      
    }
}

