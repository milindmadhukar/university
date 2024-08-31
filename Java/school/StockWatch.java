import java.util.*;
public class StockWatch
{
    static Scanner sc=new Scanner(System.in);
    static double revenue;
    static String bank_nm;
    static int bank_acc;
    static String comp_nm[]={"TCS","RIL","INFOSYS","D-MART","SUN PHARMA","RELIANCE TELECOM","HDFC BANK Ltd","WIPRO","TREE HOUSE Ltd","JET AIRWAYS","INDIABULLS HOUSING FINANCE","APOLLO HOSPITALS","HCC"};
    static String comp_n1[]=new String[14];
    static double comp_pr[]={1978,1175,1365,1648,586,955,1221,778,880,323,1379,968,1175};
    static double comp_div[]={7,10,8,8,10,6,7,12,9,11,7,6,8};
    static double dividend=0;//For finding the dividend 
    static double comp_p1[]=new double[14];
    static int no_sh[]=new int[14];//An accumulation of the number of stocks which a user will buy
    static int ctr=-1;
    static String main_ch;
    static int ch,x;//Variable used for all random uses
    static double cap;//The total invested money which keeps changing;
    static double cap_copy; //Used to record the initial investment
    static int st_num;
    static int sh_valb;//Number of shares bought
    static int sh_vals;//Number of shares sold
    static double sh_price;//The money for individual shares
    static String name="v",pass,email,city;//Variables for user data
    static Date d1=new Date();
    static String return_to_main;//Sends control to main
    public static void main()
    {
        System.out.println("~S:W~\t\tStockWatch.in(Official)");
        System.out.println("Hello!");
        System.out.println("Welcome to StockWatch.in");
        System.out.println("");
        System.out.println("");
        System.out.println("####################################################");
        int a=2;//checks if the user wants to finally shut down the program or repeat it
        do{
            UserRegisIn();
            MainPage();
        }while(a==2);

    }

    public static void UserRegisIn()
    {
        System.out.println("Enter any key to begin signup process...");
        String ans=sc.next();

        System.out.println("Ok.Let's get you signed up.");
        System.out.println("");
        System.out.println("   Enter the name you wish to keep");                
        name=sc.next();
        System.out.println("   Enter a password(Must be atleast of 6 characters)");
        for(ch=1;ch>0;ch++)
        {
            pass=sc.next();
            if(pass.length()>=6)
                break;
            else 
                System.out.println("6 chararacters minimum.Please try again");
        }
        System.out.println("   Enter your residential city or town's name");
        city=sc.next();
        for(int q=1;q>0;)
        {
            System.out.println("   Enter your email id.");
            email=sc.next();
            int x=0,y=0,flag=0,i;
            for( i=0;i<email.length();i++)
            {
                char c;
                c=email.charAt(i);
                if(c=='@')
                {
                    x=i;
                    flag++;
                    continue;
                }
                else if(c=='.')
                {
                    y=i;
                    flag++;
                    break;
                }
            }

            if (flag==2)
            {
                if(x<y)
                {
                    System.out.println("Verified!A notification will be sent to"+email+" .");
                    break;
                }

            }
            else 

            {
                System.out.println("Sorry!Incorrect format.Redirecting you...");
            }
        }

        System.out.println("Please wait a moment...processing...");
        for(ch=-1000000;ch<=10000000;ch++)
        {}
        for(ch=-1000000;ch<=10000000;ch++)
        {}
        for(ch=-1000000;ch<=10000000;ch++)
        {}
        for(ch=-1000000;ch<=10000000;ch++)
        {}
        for(ch=-1000000;ch<=10000000;ch++)
        {}
        for(ch=-1000000;ch<=10000000;ch++)
        {}
        System.out.println("Press any key to proceed to main page...");
        return_to_main=sc.next();
        System.out.println('\f');
    }

    public static void MainPage()
    {
        do{
            System.out.println("^~SW~^\t\tStockWatch.in(Official)");
            System.out.println("");
            System.out.println("****************************************************************************************************");
            System.out.println("");
            System.out.println("(1)NEW PORTFOLIO  |  (2)YOUR TRADING REPORT  |  (3)BUY/SELL SHARES  |  (4)TODAY'S RATE  |  (5)LOGOUT");
            System.out.println("####################################################################################################");
            main_ch=sc.next();
            if(main_ch.equalsIgnoreCase("1"))
            {
                Portfolio();
            }
            else if(main_ch.equalsIgnoreCase("2"))
            {
                Portfolio();
            }
            else if(main_ch.equalsIgnoreCase("3"))
            {
                b_s_Share();
            }
            else if(main_ch.equalsIgnoreCase("4"))
            {
                System.out.println("One moment please...");
                for(double i=-99999999;i<=999999999L;i=i+0.5)
                {}
                checkMarVal();
            }
            else if(main_ch.equalsIgnoreCase("5"))
            {

                System.out.println("Ok.Logging out....");
                System.out.println("Redirecting you....");
                int a;
                System.out.println("Do you want to 1.Exit\tor 2.Continue your work ?");
                a=sc.nextInt();
                if(a==1)
                {

                    System.out.println("Have a good time.See you!");
                    System.exit(0);
                }
                else
                    System.out.println('\f');
            }
        }while(true);
    }

    public static void Portfolio()//Portfolio is the accumulation of all shares
    {
        int c;
        System.out.println("");
        System.out.println("First, you need to be a member.Are you?");
        String mem_ch=sc.next();
        if(mem_ch.equalsIgnoreCase("Yes"))
        {
            System.out.println("Ok.Enter your username");
            String n=sc.next();
            if(n.equals(name))
            {
                if(main_ch.equalsIgnoreCase("1"))
                {
                    System.out.println("Printing your details...");
                    System.out.println("");
                    System.out.println("*   Username - "+name);
                    System.out.println("*   Email id - "+email);
                    System.out.println("*   City of residence - "+city);
                    System.out.println("");
                    System.out.println("");
                    System.out.println("We need your bank account details...");
                    System.out.println("");
                    System.out.println("Enter the bank name of your account");
                    bank_nm=sc.next();
                    System.out.println("Enter your bank a/c number");
                    bank_acc=sc.nextInt();
                    System.out.println("");
                    for(ch=-1000000;ch<=10000000;ch++)
                    {}
                    System.out.println("This is your portfolio, "+name+" ! Here you can see and track all the stocks ");
                    System.out.println("you have either bought, sold or are in the process of selling.");
                    System.out.println("");
                    System.out.println("");
                    System.out.println("");
                    System.out.println("");
                    System.out.println("");
                    System.out.println("Press any key to return to main page...");
                    return_to_main=sc.next();
                    System.out.println('\f');
                }
                else if(main_ch.equalsIgnoreCase("2"))
                {
                    System.out.println("WELCOME back "+name); 
                    System.out.println("");
                    System.out.println("User Profile");
                    System.out.println("####################################");
                    System.out.println("##  Name- "+name+"               ");             
                    System.out.println("##  Email id- "+email+"        ");
                    System.out.println("##  City- "+city+"             ");                      
                    System.out.println("##  Bank name- "+bank_nm+"     ");
                    System.out.println("##  Bank a/c no.- "+bank_acc+" ");
                    System.out.println("####################################");
                    System.out.println("Original invested total capital - Rs. "+cap_copy+ "/-");
                    System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
                    System.out.println("");
                    System.out.println("=================================================");
                    System.out.println("| Your current balance amount - Rs."+cap+"       |");
                    System.out.println("=================================================");
                    System.out.println("");
                    System.out.println("% Account Analysis %");
                    double bal_amt=0;
                    System.out.println("");
                    System.out.println("Shares  bought");
                    System.out.println("");
                    for(ch=0;ch<comp_n1.length;ch++)
                    {
                        if(comp_n1[ch]!=null  )
                        {
                            System.out.println((ch+1)+") "+comp_n1[ch]+"  "+comp_p1[ch]+"   No of shares - "+no_sh[ch]);           
                        }
                    }
                    System.out.println("");
                    System.out.println("Shares sold");
                    System.out.println("");
                    int c1=0;
                    for(ch=0;ch<comp_n1.length;ch++)
                    {
                        if(comp_n1[ch]!=null && no_sh[ch]==0 )
                        {
                            System.out.println((ch+1)+") "+comp_n1[ch]+"  "+comp_p1[ch]);
                            c1++;
                        }
                    }
                    if(c1==0)
                        System.out.println("No shares sold yet.");
                    System.out.println("");
                    System.out.println("Shares held currently");
                    System.out.println("");
                    double divsh=0;
                    for(ch=0;ch<comp_n1.length;ch++)
                    {
                        if(comp_n1[ch]!=null && no_sh[ch]!=0 )
                        {
                            System.out.println((ch+1)+") "+comp_n1[ch]+"  "+comp_p1[ch]+"   No of shares - "+no_sh[ch]+"  Dividend % "+comp_div[ch]);
                            divsh=no_sh[ch]*comp_p1[ch]*comp_div[ch]/100;//calculating dividend
                        }
                        dividend=dividend+divsh;
                    }
                    System.out.println("The total dividend you reaped- "+dividend);
                    System.out.println("");
                    if(cap>cap_copy)
                    {
                        System.out.println("Good ! You are enjoying a profit of Rs."+(cap-cap_copy));
                        bal_amt=cap-cap_copy;
                    }
                    else 
                    {
                        System.out.println("Well! Sorry to say, but you are incurring a loss of Rs."+(cap_copy-cap));
                        System.out.println("");
                        System.out.println("");
                        System.out.println("Press any key to return to main page...");
                        return_to_main=sc.next();
                        System.out.println('\f');
                    }
                    System.out.println("");
                    System.out.println("");
                    System.out.println("");
                    if(bal_amt!=0)
                    {
                        System.out.println("Do you want to transfer this amount(INR "+bal_amt+" ) to "+bank_nm+" ? (y/n)");
                        String ans=sc.next();
                        if (ans.equalsIgnoreCase("y"))
                        { 
                            System.out.println("Configuring details... ");
                            System.out.println(".");
                            System.out.println(".");
                            System.out.println(".");

                            System.out.println('\f');
                            System.out.println("\t\tTRANSACTION BILL");
                            System.out.println("_______________________________________________________________+tear here");
                            System.out.println("");
                            System.out.println("\t"+bank_nm+" Bank \t Date : "+d1);
                            System.out.println("*************************************************************************");
                            System.out.println("Broker name : __StockWatch Corp.__        Transaction no. : 24Q4R56");
                            System.out.println("Withdrawn\tTransferable Amt.");
                            System.out.println("INR "+cap_copy+" | INR "+bal_amt);
                            System.out.println("SHARES TRADED - ");
                            for(ch=0;ch<comp_n1.length;ch++)
                            {
                                if(comp_n1[ch]!=null )
                                {
                                    System.out.println((ch+1)+") "+comp_n1[ch]+"  "+comp_p1[ch]+"   No of shares - "+no_sh[ch]);           
                                }
                            }
                            System.out.println("Dividend earned : Rs "+dividend);
                            System.out.println("Brokerage: Rs "+(bal_amt*10/100));
                            System.out.println("#Total money transfered#  "+(bal_amt+dividend-bal_amt*10/100));
                            System.out.println("Name: "+name+"\t\tBank A/c no. "+bank_acc);
                            System.out.println("Contact no. - 2505-6455");
                            System.out.println("");
                            System.out.println("Thank you!");
                            System.out.println("");
                            System.out.println("*************************************************************************");
                            System.out.println("_______________________________________________________________+tear here");
                            System.out.println("");
                            System.out.println("");
                            System.out.println("Press any key to return to main page...");
                            return_to_main=sc.next();
                            System.out.println('\f');

                        }

                    }
                }
            } 

            else
                System.out.println("You must have made some error");

        }

        else  if(mem_ch.equalsIgnoreCase("No"))   
        {
            System.out.println("Ok.Redirecting you...");
            UserRegisIn();

        }
    }

    public static void b_s_Share()
    {
        System.out.println("Hello!");
        boolean q;//For checking the do while loop
        System.out.println(name+" how much initial capital do you wish to invest?(Enter in digits)");
        System.out.println("                         (must be less than 10 Lakhs)");
        cap=sc.nextInt();
        cap_copy=cap;
        do{
            System.out.println("1.Buy SHARES\n2.Sell SHARES\n3.Back to main page");
            ch=sc.nextInt();
            if(ch==1)
            {
                System.out.println("Displaying the stocks........please wait......");
                for(ch=-1000000;ch<=10000000;ch++)
                {}
                for(int i=0;i<comp_nm.length;i++)
                {
                    System.out.println((i+1)+") "+comp_nm[i]+"   "+comp_pr[i]);
                }
                System.out.println("Select the stock you want to buy(Enter number displayed)");
                st_num=sc.nextInt();
                System.out.println("Enter number of shares to buy...");
                sh_valb=sc.nextInt();
                sh_price=sh_valb*comp_pr[st_num-1]; //Calculates the total price of the transaction
                if(sh_price>cap)
                {
                    System.out.println("Error.You have tried to invest an invalid amount!");
                    sh_price=0;
                    System.out.println("Press any key to return to main page...");
                    return_to_main=sc.next();
                    System.out.println('\f');
                    break;
                }
                else
                {
                    System.out.println(sh_valb+" shares of "+comp_nm[st_num-1]+" company have been bought successfully.");
                    System.out.println("Shares worth "+sh_price+" have been bought.");
                    System.out.println("");
                    System.out.println("Deducting from your capital....");
                    cap=cap-sh_price;
                    System.out.println("");
                    System.out.println("Your total capital is now Rs. "+cap);
                    comp_n1[st_num-1]=comp_nm[st_num-1]; //Accumulates the shares whuch are bought
                    comp_p1[st_num-1]=comp_pr[st_num-1];
                    no_sh[st_num-1]=sh_valb;
                }
            }
            else if(ch==2)
            {
                System.out.println("^^^^^^^^^^^^^^^^^^S E L L  S H A R E S^^^^^^^^^^^^^^^^^^^");
                System.out.println("This is your current capital -  Rs"+cap);
                System.out.println("");
                System.out.println("Showing the list of shares you have bought - ");
                for(ch=0;ch<comp_n1.length;ch++)
                {
                    if(comp_n1[ch]!=null && no_sh[ch]!=0 )
                    {
                        System.out.println((ch+1)+") "+comp_n1[ch]+"  "+comp_p1[ch]+"   No of shares - "+no_sh[ch]);           
                    }
                }
                System.out.println("Enter the number of whose company's shares you want to sell ");
                System.out.println("");
                st_num=sc.nextInt();
                System.out.println("");
                System.out.println("Enter number of shares to sell...");
                System.out.println("");
                sh_vals=sc.nextInt();
                sh_price=sh_vals*comp_p1[st_num-1];
                if(sh_price>cap || sh_vals>no_sh[st_num-1])//To ensure the user doesn't try to cheat
                {
                    System.out.println("Error.You have tried to invest an invalid amount!");
                    System.out.println("");
                    System.out.println("");
                    System.out.println("");
                    sh_price=0;
                    System.out.println("Press any key...");
                    return_to_main=sc.next();
                }
                else
                {
                    System.out.println("");
                    System.out.println("C O M P L E T I N G   T R A N S A C T I O N  . . . . . . . . . . .$$$");
                    System.out.println("");
                    System.out.println("");
                    System.out.println("@  @  @  @  @  @  @  @  @  @  @  @  @  @");
                    System.out.println("");
                    System.out.println("P.....R.......O........C........E.....S.......S......I........N........G......");
                    System.out.println("");
                    for(double i=-99999999;i<=999999999;i=i+0.5)
                    {}
                    System.out.println("Transaction complete! Shares sold successfully");
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                    System.out.println("");
                    int choi2=(int)Math.rint(Math.random()*10);
                    double prof_loss=(choi2+10)*125*sh_vals;//Generating a random market value
                    if(choi2==1||choi2==4||choi2==5||choi2==7||choi2==9)
                    {
                        System.out.println("YOU EARNED PROFIT ON YOUR SHARES!!");
                        System.out.println("Profit earned - "+prof_loss);
                        cap=cap+prof_loss;//Adding the profit to the total capital
                        System.out.println("");
                        System.out.println("Your total capital now stands at Rs."+cap);
                        System.out.println("");
                        System.out.println("");
                        System.out.println("");
                    }
                    else
                    {
                        System.out.println("SORRY...THE MARKET IS DOWN :(");
                        System.out.println("Loss incurred - "+prof_loss);
                        cap=cap-prof_loss;//SUbtracting the loss from the total capital
                        System.out.println("");
                        System.out.println("Your total capital now stands at Rs."+cap);
                        System.out.println("Invest wisely next time !");
                        System.out.println("");
                        System.out.println("");
                    }
                    no_sh[st_num-1]=no_sh[st_num-1]-sh_vals;
                }
            }
            else if (ch==3)
            {
                System.out.println('\f');
                MainPage();
            }
        }while(q=true);
    }

    public static void checkMarVal()
    {
        System.out.println("Displaying today's Sensex and Nifty's value....(as updated 20 minutes ago)");
        double nif1,sens1;
        nif1=Math.random()*30000;//Stimulates Nifty
        sens1=Math.random()*35000;//Stimulates Sensex
        int nif=(int)nif1;
        int sens=(int)sens1;
        System.out.println("Nifty(NSE) - "+nif);
        System.out.println("Sensex(BSE) - "+sens);
        if(nif<9000 || sens<11000)
        {
            System.out.println("");
            System.out.println("|||||||||||||||||||||||||||||||||||||||");
            System.out.println("Bear market :( ....");
            System.out.println("Invest with care today...");
            System.out.println("|||||||||||||||||||||||||||||||||||||||");
            System.out.println("");
            System.out.println("");
            System.out.println("");
        }
        else if(nif<10500 || sens<12500)
        {
            System.out.println("");
            System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
            System.out.println("Market is stagnant....You may want to hold onto your shares.");
            System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
            System.out.println("");
            System.out.println("");
            System.out.println("");
        }
        else 
        {
            System.out.println("");
            System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
            System.out.println("Bull Market!");
            System.out.println("We strongly advise you to try selling your shares today...Quick!!");
            System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
            System.out.println("");
            System.out.println("");
            System.out.println("");
        }
        System.out.println("Press any key to return to main page...");
        return_to_main=sc.next();
        System.out.println('\f');
    }

}
