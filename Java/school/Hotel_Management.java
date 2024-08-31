
import java.util.* ;
class Hotel_Management
{
    Scanner sc = new Scanner(System.in);
    int i = 0,j = 0,k= 0,pos,m,p,q; 
    int small,large,tmp,mon_num_in[] = new int[100],mon_num_out[] = new int[100],date_in[] = new int[100],date_out[] = new int[100];
    int choice = -1, ch = -1,fchoice,hotel_choice,rate_choice;
    String name[] = new String[100];
    String email[] = new String[100];
    String pass[] = new String[100];   
    long cost;
    String cho;
    char character;
    boolean disc = false;
    String p_codes[] = {"NEWCUSTOMER","LUCKY20","ELONMUSK","SUB2PEWDS","DISC20"};
    String promo_code = "";
    String repass[] = new String[100];   
    String location[] = new String[100];
    String filterz[] = {"Air Conditioning","WiFi in rooms","Swimming Pool","Free BreakFast","Spa","Parking"};
    String hotel_name[] = new String[4];
    int total[] = new int[100];
    int adults[] = new int[100];
    int children[] = new int[100];   
    long days_of_stay[] = new long[100];
    int yatra[] = new int[100];   
    int base;
    int agoda[] = new int[100];
    int hotels[] = new int[100];
    int goibibo[] = new int[100];
    int cleartrip[] = new int[100];
    int room_type_rate[] = new int[3];   
    String Website[] = new String [5]; 
    int fprice[] = new int[5];
    String Method_of_Payment[] = new String[100];
    boolean flag[][] = new boolean[100][7]; 
    boolean day_31_in,day_31_out;
    double gst,net,discount,discount_val;
    Date currentDate = new Date();   
    String bill[] = new String[100];
    String cIn_year[] = new String[100];
    String cOut_year[] = new String[100],mon,mon_val_in[] = new String[100],mon_val_out[] = new String[100],dt,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16;
    Calendar c = Calendar.getInstance();
    int date = c.get(Calendar.DATE);
    int month = c.get(Calendar.MONTH)+1;
    int year = c.get(Calendar.YEAR);
    Hotel_Management()
    {
        i = 0;j = 0; k= 0; pos = 0; m = 0; p = 0; 
        small = 0; large = 0; tmp = 0; 
        choice = -1;  ch = -1; fchoice = 0; hotel_choice = 0; rate_choice = 0; cost = 0;
        cho =""; character = ' ';
        disc = false; day_31_in = false ; day_31_out = false;
        gst = 0.0D; net = 0.0D; discount = 0.0D; discount_val = 0.0D;
        cIn_year[i] = ""; cOut_year[i] = ""; mon = ""; mon_val_in[i] = ""; mon_val_out[i] = ""; dt = ""; l1 = ""; 
        l2 = ""; l3 = ""; l4 = ""; l5 = ""; l6 = ""; l7 = ""; l8 = ""; l9 = ""; l10 = ""; l11 = ""; 
        l12 = ""; l13 = ""; l14 = ""; l15 = ""; l16 = "";base = 2001;
        promo_code = "";
        IntegerL:
        for(k = 0 ; k < 100 ; k++)
        {
            total[k] = 0 ;
            adults[k] = 0 ;
            children[k] = 0 ;
            days_of_stay[k] = 0 ;
            yatra[k] = 0 ; 
            agoda[k] = 0 ;
            hotels[k] = 0 ;
            goibibo[k] = 0 ;
            cleartrip[k] = 0 ;
            mon_num_in[k] = 0;
            mon_num_out[k] = 0 ;
            date_in[k] = 0; 
            date_out[k] = 0;
        }
        for(k = 0 ; k < 100 ; k++)
        {
            name[k] = "" ;
            email[k] = "" ;
            pass[k] = "" ;
            repass[k] = "" ;   
            location[k] = "" ;
             Method_of_Payment[k] = "" ;
        }
    }
    void main()
    {
        System.out.println("Welcome To TryVago™\nWe help you find the best hotel for the best Price");
        System.out.println("LOG IN to Proceed Further ");
        q = 0;
        if(i == 0 )
        {
            System.out.print("Enter Your Name : ");
            name[i] = sc.nextLine();
        }
        if(i != 0 )
        {
            System.out.print("Enter Your Name : ");
            sc.nextLine();
            name[i] = sc.nextLine();
        }
        if(name[i].equals("IAmDeveloper"))
        Developer();
        while(q != -1)
        {
            System.out.print("Enter Your Email(For Sending A Copy Of The Bill Generated) : ");
            Email:
            while(true)
            {
                email[i] = sc.next();
                if(email[i].indexOf('@') == -1 || email[i].lastIndexOf('.') == -1)
                System.out.println("Incorrect Email Entered !!\nPlease Enter Correct Email");
                else
                break Email;
            }
            sc.nextLine();//skips one line
            Password:
            while(true)
            {
                System.out.print("Set Password(Less than 12 characters) : ");
                pass[i] = sc.nextLine();
                System.out.print("Confirm Password : ");
                repass[i] = sc.nextLine();
                if(pass[i].equals(repass[i]) && pass[i].length() <= 12)
                {
                    break Password;
                }
                else
                {
                    System.out.println("Try Again\nPassword Exceeds 12 Characters or Passwords Don't Match\n ");
                }
            }
            System.out.println("\fHello "+name[i]);
            p=0;
            Location_Input();
        } 
    }
    void Location_Input()
    {
        System.out.print("Which Place Are You Looking a Hotel For ?");
        location[i] = sc.nextLine();
        Amenities();
    }
    void Amenities()
    {
        BooleanL:
        for(k = 0 ; k < 7 ;k++)
        {
            for(m = 0 ; m < 100 ; m++)
            flag[m][k] = false;
        }
        System.out.println("Options for required Amenities(Charges may apply): ");
        System.out.println("1]\tAir Conditioning");
        System.out.println("2]\tWiFi in rooms");
        System.out.println("3]\tSwimming Pool");
        System.out.println("4]\tFree BreakFast");
        System.out.println("5]\tSpa");
        System.out.println("6]\tParking");
        System.out.println("0]\tExit Filters ");
        j = 0 ;
        loop:
        while(choice != 0 && ch != 0)
        {   
            j++;
            if(p == -1)
            break loop;
            if(j == 1)
            {
                System.out.print("Enter your Choice : ");
                choice = sc.nextInt();
            }
            else if(j != -1 && j > 1)
            {
                System.out.print("Anything Else ?: ");
                choice = sc.nextInt();
                ch = choice;
            }
            if(choice >= 1 && choice <= 6)
            {
                if(flag[choice - 1][i] == false && choice != 0)
                {
                    switch(choice)
                    {
                        case 1:
                        total[i] += 500;
                        flag[choice - 1 ][i] = true;
                        break;
                        case 2: total[i] += 200;
                        flag[choice - 1][i] = true;
                        break;     
                        case 3: total[i] += 300;
                        flag[choice - 1][i] = true;
                        break;
                        case 4: total[i] += 200;
                        flag[choice - 1][i] = true;
                        break;
                        case 5: total[i] += 300; 
                        flag[choice - 1][i] = true;
                        break;
                        case 6: total[i] += 75; 
                        flag[choice - 1][i] = true;
                        break;
                    }
                }
                else
                System.out.println("You have Selected the Option Before !");
            }
            else if (choice == 0)
            hotel_name();
            else
            {
                System.out.println("Please Enter Correct Choice !!");
            }
        }
    }
    void hotel_name()
    {
        System.out.println("\fThese are the Places we found in and near "+location[i] +" : ");
        System.out.println("1]\tHotel "+location[i]+" Luxury ");
        System.out.println("2]\tHotel Premium "+location[i]);     
        System.out.println("3]\t"+location[i]+" Star Hotel ");
        System.out.println("4]\tMariott - "+location[i]);
        Hotel_Choice();
    }
    void Hotel_Choice()
    {
        System.out.print("\nEnter your Choice to Know Further Details About your Hotel: ");
        choice = sc.nextInt();
        if(choice >= 1 && choice <= 4)
        {
            hotel_name[0] = "Hotel "+location[i]+" Luxury ";
            hotel_name[1] = "Hotel Premium "+location[i]; 
            hotel_name[2] = location[i]+" Star Hotel ";
            hotel_name[3] = "Trident - "+location[i];
            switch(choice)
            {
                case 1:
                case 2:
                case 3:
                case 4:
                hotel_choice = choice - 1;
                break;
            }
            Guest_Info();
        }
        else
        {
            System.out.println("Please Enter Correct Option ");
            Hotel_Choice();
        }
    }
    void Guest_Info()
    {
        System.out.print("Enter Number of Adults : ");
        adults[i] = sc.nextInt();
        System.out.print("Enter Number of Childern(0 if none) : ");
        children[i] = sc.nextInt();
        System.out.println("\f");
        CheckIn();
    }
    void CheckIn()
    {
        Year_Check:
        while(true)
        {
            System.out.print("Enter Year Of CheckIn : ");
            cIn_year[i] = sc.next();
            if(Integer.parseInt(cIn_year[i]) >= year && Integer.parseInt(cIn_year[i]) <= year + 2)
            break Year_Check;
            else if(Integer.parseInt(cIn_year[i]) < year)
            System.out.println("That year has Passed !!\nPlease Try Another year");
            else if(Integer.parseInt(cIn_year[i]) > year + 2)
            System.out.println("Bookings Unavailable !!\nPlease Try Another year ");
        }
        Month_Check:
        while(true)
        {
            System.out.print("Enter the Month of Check In (Month Number or In Words): ");
            mon = sc.next();
            if(mon.length() >= 1 && mon.length() <= 2)
            {
                mon_num_in[i] = Integer.parseInt(mon);
                switch(mon_num_in[i])
                {
                    case 1:
                    mon_val_in[i] = "January";
                    day_31_in = true;
                    break Month_Check;
                    case 2:
                    mon_val_in[i] = "February";
                    break Month_Check;
                    case 3:
                    mon_val_in[i] = "March";
                    day_31_in = true;
                    break Month_Check;
                    case 4:
                    mon_val_in[i] = "April";
                    break Month_Check;
                    case 5:
                    mon_val_in[i] = "May";
                    day_31_in = true;
                    break Month_Check;
                    case 6:
                    mon_val_in[i] = "June";
                    break Month_Check;
                    case 7:
                    mon_val_in[i] = "July";
                    day_31_in = true;
                    break Month_Check;
                    case 8:
                    mon_val_in[i] = "August";
                    day_31_in = true;
                    break Month_Check;
                    case 9:
                    mon_val_in[i] = "September";
                    break Month_Check;
                    case 10:
                    mon_val_in[i] = "October";
                    day_31_in = true;
                    break Month_Check;
                    case 11:
                    mon_val_in[i] = "November";
                    break Month_Check;
                    case 12:
                    mon_val_in[i] = "December";
                    mon_num_in[i] = 12;
                    day_31_in = true;
                    break Month_Check;
                    default:
                    System.out.println("Inappropiate Month Entered !!\nPlease Try Again \n");
                }
            }
            else if(mon.length() > 2)
            {
                if(mon.equalsIgnoreCase("january"))
                {
                    mon_val_in[i] = "January";
                    mon_num_in[i] = 1;
                    day_31_in = true;
                    break Month_Check;
                }
                else if(mon.equalsIgnoreCase("february"))
                {
                    mon_val_in[i] = "February";
                    mon_num_in[i] = 2;
                    break Month_Check;
                }
                else if(mon.equalsIgnoreCase("march"))
                {
                    mon_val_in[i] = "March";
                    mon_num_in[i] = 3;
                    day_31_in = true;
                    break Month_Check;
                }
                else if(mon.equalsIgnoreCase("april"))
                {
                    mon_val_in[i] = "April";
                    mon_num_in[i] = 4;
                    break Month_Check;
                }
                else if(mon.equalsIgnoreCase("may"))
                {
                    mon_val_in[i] = "May";
                    mon_num_in[i] = 5;
                    day_31_in = true;
                    break Month_Check;
                }
                else if(mon.equalsIgnoreCase("june"))
                {
                    mon_val_in[i] = "June";
                    mon_num_in[i] = 6;
                    break Month_Check;
                }
                else if(mon.equalsIgnoreCase("july"))
                {
                    mon_val_in[i] = "July";
                    mon_num_in[i] = 7;
                    day_31_in = true;
                    break Month_Check;
                }
                else if(mon.equalsIgnoreCase("august"))
                {
                    mon_val_in[i] = "August";
                    mon_num_in[i] = 8;
                    day_31_in = true;
                    break Month_Check;
                }
                else if(mon.equalsIgnoreCase("september"))
                {
                    mon_val_in[i] = "September";
                    mon_num_in[i] = 9;
                    break Month_Check;
                }
                else if(mon.equalsIgnoreCase("october"))
                {
                    mon_val_in[i] = "October";
                    mon_num_in[i] = 10;
                    day_31_in = true;
                    break Month_Check;
                }
                else if(mon.equalsIgnoreCase("november"))
                {
                    mon_val_in[i] = "November";
                    mon_num_in[i] = 11;
                    break Month_Check;
                }
                else if(mon.equalsIgnoreCase("december"))
                {
                    mon_val_in[i] = "December";
                    mon_num_in[i] = 12;
                    day_31_in = true;
                    break Month_Check;
                }
                else
                System.out.println("Inappropiate Month Entered !!\nPlease Try Again\n ");
            }
        }
        if(Integer.parseInt(cIn_year[i]) == year && mon_num_in[i] < month)
            {
                System.out.print("That Month has Passed !\nPlease Try Again\n");
                CheckIn();
            }
        Date_Check:
        while(true && q != -1)
        {
            System.out.print("Enter Date of Check In : ");
            date_in[i] = sc.nextInt();
            System.out.println();
            if(date_in[i] >= 1 && date_in[i] <= 31 && mon_num_in[i] != 2)
            {
                if(date_in[i] != 31)
                break Date_Check;
                else
                {
                    if(day_31_in)
                    break Date_Check;
                    else 
                    System.out.println(mon_val_in[i] + " does not have 31 days !\nPlease try Again");
                }
            }
            else if(mon_num_in[i] == 2)
            {
                if(date_in[i] >= 1 && date_in[i] <= 28 && Integer.parseInt(cIn_year[i]) % 4 != 0)
                break Date_Check;
                else if(date_in[i] >= 1 && date_in[i] <= 29 && Integer.parseInt(cIn_year[i]) % 4 == 0)
                break Date_Check;
                else
                System.out.println("That date_ine does not exist in February "+ cIn_year[i] +" !!\nPlease Try Again");
            }
            else
            System.out.println("Inappropiate date_ine Entered !!\nPlease Try Again");
        }
        if(Integer.parseInt(cIn_year[i]) == year && mon_num_in[i] == month && date_in[i] < date)
        {
            System.out.print("That Month has Passed !\nPlease Try Again\n");
            CheckIn();
        }
        CheckOut();
    }
        void CheckOut()
    {
        Year_Check:
        while(true && q != -1)
        {
            System.out.print("Enter Year Of Check Out : ");
            cOut_year[i] = sc.next();
            if(Integer.parseInt(cOut_year[i]) >= Integer.parseInt(cIn_year[i]) && Integer.parseInt(cOut_year[i]) <= year + 2)
            break Year_Check;
            else if(Integer.parseInt(cOut_year[i]) < Integer.parseInt(cIn_year[i]))
            System.out.println("CheckOut Cannot be Before CheckIn !! ");
            else
            System.out.println("Bookings Unavailable !! Please Try Again \n");
        }
        Month_Check:
        while(true)
        {
            System.out.print("Enter the Month of Check Out (Month Number or In Words): ");
            mon = sc.next();
            if(mon.length() >= 1 && mon.length() <= 2)
            {
                mon_num_out[i] = Integer.parseInt(mon);
                switch(mon_num_out[i])
                {
                    case 1:
                    mon_val_out[i]= "January";
                    day_31_out = true;
                    break Month_Check;
                    case 2:
                    mon_val_out[i] = "February";
                    break Month_Check;
                    case 3:
                    mon_val_out[i] = "March";
                    day_31_out = true;
                    break Month_Check;
                    case 4:
                    mon_val_out[i] = "April";
                    break Month_Check;
                    case 5:
                    mon_val_out[i] = "May";
                    day_31_out = true;
                    break Month_Check;
                    case 6:
                    mon_val_out[i] = "June";
                    break Month_Check;
                    case 7:
                    mon_val_out[i] = "July";
                    day_31_out = true;
                    break Month_Check;
                    case 8:
                    mon_val_out[i] = "August";
                    day_31_out = true;
                    break Month_Check;
                    case 9:
                    mon_val_out[i] = "September";
                    break Month_Check;
                    case 10:
                    mon_val_out[i] = "October";
                    day_31_out = true;
                    break Month_Check;
                    case 11:
                    mon_val_out[i] = "November";
                    break Month_Check;
                    case 12:
                    mon_val_out[i] = "December";
                    day_31_out = true;
                    break Month_Check;
                    default:
                    System.out.println("Inappropiate Month Entered !!\nPlease Try Again \n");
                }
            }
            else if(mon.length() > 2)
            {
                if(mon.equalsIgnoreCase("january"))
                {
                    mon_val_out[i] = "January";
                    mon_num_out[i] = 1;
                    day_31_out = true;
                    break Month_Check;
                }
                else if(mon.equalsIgnoreCase("february"))
                {
                    mon_val_out[i] = "February";
                    mon_num_out[i] = 2;
                    break Month_Check;
                }
                else if(mon.equalsIgnoreCase("march"))
                {
                    mon_val_out[i] = "March";
                    mon_num_out[i] = 3;
                    day_31_out = true;
                    break Month_Check;
                }
                else if(mon.equalsIgnoreCase("april"))
                {
                    mon_val_out[i] = "April";
                    mon_num_out[i] = 4;
                    break Month_Check;
                }
                else if(mon.equalsIgnoreCase("may"))
                {
                    mon_val_out[i] = "May";
                    mon_num_out[i] = 5;
                    day_31_out = true;
                    break Month_Check;
                }
                else if(mon.equalsIgnoreCase("june"))
                {
                    mon_val_out[i] = "June";
                    mon_num_out[i] = 6;
                    break Month_Check;
                }
                else if(mon.equalsIgnoreCase("july"))
                {
                    mon_val_out[i] = "July";
                    mon_num_out[i] = 7;
                    day_31_out = true;
                    break Month_Check;
                }
                else if(mon.equalsIgnoreCase("august"))
                {
                    mon_val_out[i] = "August";
                    mon_num_out[i] = 8;
                    day_31_out = true;
                    break Month_Check;
                }
                else if(mon.equalsIgnoreCase("september"))
                {
                    mon_val_out[i] = "September";
                    mon_num_out[i] = 9;
                    break Month_Check;
                }
                else if(mon.equalsIgnoreCase("october"))
                {
                    mon_val_out[i] = "October";
                    mon_num_out[i] = 10;
                    day_31_out = true;
                    break Month_Check;
                }
                else if(mon.equalsIgnoreCase("november"))
                {
                    mon_val_out[i] = "November";
                    mon_num_out[i] = 11;
                    break Month_Check;
                }
                else if(mon.equalsIgnoreCase("december"))
                {
                    mon_val_out[i] = "December";
                    mon_num_out[i] = 12;
                    day_31_out = true;
                    break Month_Check;
                }
                else
                System.out.println("Inappropiate Month Entered !!\nPlease Try Again\n ");
            }
        }
        if(cIn_year[i].equals(cOut_year[i]) && mon_num_in[i] > mon_num_out[i])
        {
            System.out.print("CheckOut Cannot be Before CheckIn !! \n\n");
            CheckOut();
        }
        Date_Check:
        while(true && q != -1)
        {
            System.out.print("Enter Date of Check Out : ");
            date_out[i] = sc.nextInt();
            if(date_out[i] >= 1 && date_out[i] <= 31 && mon_num_out[i] != 2)
            {
                if(date_out[i] != 31)
                break Date_Check;
                else
                {
                    if(day_31_out)
                    break Date_Check;
                    else 
                    System.out.println(mon_val_out[i] + " does not have 31 days !\nPlease try Again");
                }
            }
            else if(mon_num_out[i] == 2)
            {
                if(date_out[i] >= 1 && date_out[i] <= 28 && Integer.parseInt(cOut_year[i]) % 4 != 0)
                break Date_Check;
                else if(date_out[i] >= 1 && date_out[i] <= 29 && Integer.parseInt(cOut_year[i]) % 4 == 0)
                break Date_Check;
                else
                System.out.println("That Date does not exist in February "+ cOut_year[i] +" !!\nPlease Try Again");
            }
            else
            System.out.println("Inappropiate Date Entered !!\nPlease Try Again");
        }
        if(cIn_year[i].equals(cOut_year[i]) && mon_val_in[i].equals(mon_val_out[i]) && date_in[i] > date_out[i])
        {
            System.out.print("CheckOut Cannot be Before CheckIn !! \n\n");
            CheckOut();
        }
        if(cIn_year[i].equals(cOut_year[i]) && mon_val_in[i].equals(mon_val_out[i]) && date_in[i] == date_out[i])
        {
            System.out.print("You can book for a Minimum of 2 days \n");
            CheckOut();
        }
        Days_Count();
    }
    void Days_Count()
    {
        int cpy_date_in = date_in[i] , cpy_mon_num_in = mon_num_in[i] , cpy_cIn_year = Integer.parseInt(cIn_year[i]);
        int cpy_date_out = date_out[i] , cpy_mon_num_out = mon_num_out[i] , cpy_cOut_year =Integer.parseInt(cOut_year[i]);
        days_of_stay[i] = 0;
        while(true)
        {
            days_of_stay[i]++;
            cpy_date_in ++;
            if(day_31_in == false && cpy_date_in >= 31 && cpy_mon_num_in != 12)
            {
                cpy_mon_num_in++;
                cpy_date_in = 1;
                days_of_stay[i]--;
            }
            if(day_31_in == true && cpy_date_in >= 32 && cpy_mon_num_in != 12)
            {
                cpy_mon_num_in++;
                cpy_date_in = 1;
            }
            if(day_31_in == true && cpy_date_in >= 32 && cpy_mon_num_in == 12)
            {
                cpy_cIn_year++;
                cpy_mon_num_in = 1;
                cpy_date_in = 1;
            }
            if(cpy_date_in == cpy_date_out && cpy_mon_num_in == cpy_mon_num_out && cpy_cIn_year == cpy_cOut_year)
            break;
        }
        days_of_stay[i]++;
        Price_Websites();
    }
    void Price_Websites()
    {
        System.out.println("Enter the Kind of Room Required : ");
        System.out.println("1]\tSingle Room");
        System.out.println("2]\tDouble Room");
        System.out.println("3]\tFamily Room");
        System.out.print("Enter your choice : ");
        choice = sc.nextInt();
        if(choice >= 1 && choice <= 3)
        {
            room_type_rate[0] = 1;
            room_type_rate[1] = 2;
            room_type_rate[2] = 3;
            switch(choice)
            {
                case 1:
                case 2:
                case 3:
                rate_choice = choice - 1 ;
            }
            cost = base*days_of_stay[i]*(int)(adults[i]+(0.5*children[i])*room_type_rate[rate_choice]);
            Value_Checker:
            while(true)
            {
                yatra[i] = (int)(Math.random()*cost+total[i]);
                agoda[i] = (int)(Math.random()*cost+total[i]);
                goibibo[i] = (int)(Math.random()*cost+total[i]);
                cleartrip[i] = (int)(Math.random()*cost+total[i]);
                hotels[i] = (int)(Math.random()*cost+total[i]);
                Array_Sort();
                if((large - small) < 1800)
                break Value_Checker;
                else
                continue;
            }
            System.out.println("\fList of Websites available for booking : ");
            if(yatra[i] == small)
                System.out.println("1]\tYatra.com -\t Rs."+(yatra[i])+"  <--- TryVago Recommendation");
            else
            	System.out.println("2]\tYatra -\t\t Rs."+(yatra[i]));	
            if(agoda[i] == small)
            System.out.println("2]\tAgoda.com -\t Rs."+(agoda[i])+"  <--- TryVago Recommendation");
            else 
            	System.out.println("2]\tAgoda.com -\t Rs."+(agoda[i]));
            if(goibibo[i] == small)
            System.out.println("3]\tGoIbibo.com -\t Rs."+(goibibo[i])+"  <--- TryVago Recommendation");
            else
            	System.out.println("5]\tGoIbibo.com -\t Rs."+(goibibo[i]));
            if(cleartrip[i] == small)
            System.out.println("4]\tClearTrip.com -\t Rs."+(cleartrip[i])+"   <--- TryVago Recommendation");
            else
            	System.out.println("5]\tClearTrip.com -\t Rs."+(cleartrip[i]));
           if(hotels[i] == small) 	
            System.out.println("5]\tHotels.com -\t Rs."+(hotels[i])+"   <--- TryVago Recommendation");
           else
        	   System.out.println("5]\tHotels.com -\t Rs."+(hotels[i]));
        }
        else
        {
            System.out.println("Please Enter Correct Choice  ");
            Price_Websites();  
        }
        Website_Selector();
    }
    void Array_Sort()
    {
            int arr[] = {yatra[i],agoda[i],goibibo[i],cleartrip[i],hotels[i]};
            for(k = 0 ; k < arr.length ; k++)
            {
                small = arr[k];
                pos = k;
                for(j = k+1 ; j < arr.length ; j++)
                {
                    if(arr[j] < small)
                    {
                        small = arr[j]; 
                        pos = j ;
                    }
                }
                tmp = arr[k];
                arr[k] = arr[pos];
                arr[pos] = tmp;
            }
            small = arr[0];
            large = arr[arr.length - 1];
    }
    void Website_Selector()
    {
        System.out.print("Enter your choice of Website : ");
        choice = sc.nextInt();
        if(choice >= 1 && choice <=5)
        {
            fprice[0] = yatra[i];
            Website[0] = "Yatra.com";
            fprice[1] = agoda[i];
            Website[1] = "Agoda.com";
            fprice[2] = goibibo[i];
            Website[2] = "GoIbibo.com";
            fprice[3] = cleartrip[i];
            Website[3] = "ClearTrip.com";
            fprice[4] = hotels[i];
            Website[4] = "Hotels.com";
            switch(choice)
            {
                case 1 :
                case 2 :
                case 3 :
                case 4 :
                case 5 : 
                fchoice = choice - 1;
                break;
            }
        }
        else
        {
            System.out.println("Please Enter Correct Choice ");
            Website_Selector();
        }
        Final_Choice();
    }
    void Final_Choice()
    {
        System.out.println("1]\tProceed to Checkout ");
        System.out.println("2]\tCancel Bookings ");
        Method_of_Payment();
    }
    void Method_of_Payment()
    {
        Payment:
        while(true)
        {
            System.out.print("Enter your Choice : ");
            choice = sc.nextInt();
            if(choice == 1 || ch == 2)
            {
                switch(choice)
                {
                    case 1 :    
                    for(int j = 0; j <= 100000000L;j++)
                    {
                        if(j == 50000000)
                        System.out.println("\f");
                        if(j == 100000000 )
                        System.out.print("Redirecting you to "+ Website[fchoice]+" ");
                    }
                    for(int j = 0; j < 60000000L;j++)
                    {
                        if(j%20000000 == 0)
                        System.out.print(".");
                    }
                    System.out.println("\nWelcome "+name[i]+" to "+Website[fchoice]);
                    System.out.println("Final Price is "+Math.round(1.18*fprice[fchoice])+" (Inclusice of Taxes)");
                    System.out.println("Methods of Payment are : ");
                    System.out.println("1]\tCredit / Debit Card");
                    System.out.println("2]\tNet Banking");
                    System.out.println("3]\tMobile Wallet-PayTM");
                    System.out.println("4]\tCash at Checkout");
                    System.out.print("Enter your Choice of Payment : ");
                    choice = sc.nextInt();
                    Method:
                    while(true)
                    {
                        if(choice >= 1 && choice <= 4)
                        {
                            switch(choice)
                            {
                                case 1:
                                Card_Payment();
                                break Method;
                                case 2 :
                                Net_Payment();
                                break Method ;
                                case 3:
                                Mobile_Payment();
                                break Method;
                                case 4:
                                Checkout_Payment();
                                break Method ;
                            }
                        }
                        else
                        {
                            System.out.println("\nPlease Enter Correct Choice !");
                            System.out.println("Enter Your Choice : ");
                            choice = sc.nextInt();
                        }
                    }
                    break Payment;
                    case 2 :
                    System.out.println("\fThank You For Nothing ");
                    choice = 0 ;
                    break Payment;
                }
            }
            else
            {
                System.out.println("\nPlease Enter Correct Choice !");
            }
        }
    }
    void Card_Payment()
    {
        Promo_Code();
        System.out.println("Enter Card Details : ");
        System.out.print("Enter Card Number : ");
        long card_num = sc.nextLong();
        sc.nextLine();//skips one line
        System.out.print("Enter Name on Card : ");
        String name_card = sc.nextLine();
        System.out.print("Enter PIN : ");
        int pin = sc.nextInt();
        Method_of_Payment[i] = "Debit/Credit Card";
        System.out.print("Proceeding Your Transaction ");
        for(j = 0 ; j < 200000001*5 + 50000000; j++)
        {
            if(j == 100000000*5)
            System.out.print(". ");
            if(j == 150000000*5)
            System.out.print(". ");
            if(j == 200000000*5)
            System.out.print(". ");
            if(j ==  200000000*5 + 50000000 ){}
        }
        Bill();
    }
    void Net_Payment()
    {
        Promo_Code();
        System.out.print("Enter Bank Account Number : ");
        long bank_acc_num = sc.nextLong();
        System.out.print("Enter Pass to Proceed Transaction : ");
        String bank_pass = sc.nextLine();
        sc.nextLine();
        Method_of_Payment[i] = "Net Banking";
        System.out.print("Proceeding Your Transaction ");
        for(j = 0 ; j < 200000001*5 + 50000000; j++)
        {
            if(j == 100000000*5)
            System.out.print(". ");
            if(j == 150000000*5)
            System.out.print(". ");
            if(j == 200000000*5)
            System.out.print(". ");
            if(j ==  200000000*5 + 50000000 ){}
        }
        Bill();
    }
    void Mobile_Payment()
    {
        Promo_Code();
        System.out.print("Enter Mobile Wallet Number : ");
        long m_wallet_num = sc.nextLong();
        if(m_wallet_num >10E8 && m_wallet_num < 9999999999.0D)
        {
            System.out.print("Proceeding Your Transaction ");
            for(j = 0 ; j < 200000001*5 + 50000000; j++)
            {
                if(j == 100000000*5)
                System.out.print(". ");
                if(j == 150000000*5)
                System.out.print(". ");
                if(j == 200000000*5)
                System.out.print(". ");
                if(j ==  200000000*5 + 50000000 ){}
            }
            Method_of_Payment[i] = "Mobile Wallet";
            Bill();
        }
        else
        {
            System.out.println("Enter Correct Mobile Details ! ");
            Mobile_Payment();  
        }
    }
    void Checkout_Payment()
    {
        Promo_Code();
        System.out.print("Pay at Checkout Selected\nYou can pay at the Hotel Reception\nPrinting Bill ");
        for(j = 0 ; j < 200000001*5 + 50000000; j++)
        {
            if(j == 100000000*5)
            System.out.print(". ");
            if(j == 150000000*5)
            System.out.print(". ");
            if(j == 200000000*5)
            System.out.print(". ");
            if(j ==  200000000*5 + 50000000 ){}
        }
        Method_of_Payment[i] = "Pay At CheckOut";
        Bill();
    }
    void Promo_Code()
    {
        System.out.print("Do you have Promo Code / Discount Coupon ? ");
        cho = sc.next();
        cho = cho.toLowerCase();
        character = cho.charAt(0);
        Promo_Code_Accept();
    }
    void Promo_Code_Accept()
    {
        Promo:
        while(true)
        {
            if(character =='y' ||character =='Y'||character == '1')
            {
                System.out.print("Enter Promo Code / Discount Coupon : ");
                promo_code = sc.next().toUpperCase().trim();
                for(j = 0 ; j < p_codes.length ; j++)
                {
                    if(promo_code.equalsIgnoreCase(p_codes[j]))
                    {
                        disc = true;
                        System.out.println("Promo code/Discount Voucher Applied\n20% Discount Availed\n");
                        break Promo;
                    }
                }
                if(!disc)
                {
                    System.out.println("Wrong Code Used ! ");
                    System.out.print("Do you want to enter again ?\nEnter your Choice : ");
                    cho = sc.next();
                    character = cho.charAt(0);
                    if(character =='y' ||character =='Y'||character == '1')
                    {
                        continue;
                    }
                    else
                    {
                        break Promo;
                     }
                    }
            }
            else
            break Promo;
        }
        GST_Discount();
        return;
     }
    void GST_Discount()
    {
        if(disc)
        {
              discount = 0.2 * fprice[fchoice];
              discount_val = fprice[fchoice] - discount ;
              gst = 0.18 * discount_val;
              net = discount_val + gst;
        }   
        else
        {
            discount_val = fprice[fchoice];
            gst = 0.18 * discount_val;
            net = discount_val + gst;
        }
        return;
    }
    void Bill()
    {
        for(int j = 0; j <= 35000000L;j++)
        {
            if(j == 35000000)
            System.out.println("\f");
        }
        System.out.println();
        String l = "\t\t__________________________________________________________________________\n";//74
        String s = "                                                                          ";//74
        String ln ="\t\t==========================================================================\n";//74
        System.out.print(ln);            
        System.out.print("\t\t|                               TryVago™                                 |\n");
        System.out.print(l);
        System.out.print("\t\t|                                 Bill                                   |\n");
        System.out.print(l);
        dt = DateAlign("DATE : "+ date+"/"+month+"/"+year);
        System.out.print(dt);
        System.out.print(l);
        l1 = align("NAME : "+ name[i]);
        System.out.print(l1);
        l2 = align("EMAIL : "+ email[i]);
        System.out.print(l2);
        System.out.print(l);
        l3 = align("DETAILS : ");
        System.out.print(l3);
        l4 = align("NUMBER OF ADULTS : "+adults[i]);
        System.out.print(l4);
        l5 = align("NUMBER OF CHILDREN : "+children[i]);
        System.out.print(l5);
        l6 = align("CHECK IN DATE  : "+date_in[i]+" " + mon_val_in[i]+ " " + cIn_year[i]) ;
        System.out.print(l6);
        l7 = align("CHECK OUT DATE : "+date_out[i] +" "+ mon_val_out[i]+ " " + cOut_year[i]) ;
        System.out.print(l7);
        l8 = align("DAYS OF STAY : "+days_of_stay[i]) ;
        System.out.print(l8);
        System.out.print(l);
        l9 = align("HOTEL : "+hotel_name[hotel_choice]);
        System.out.print(l9);
        l10 = align("WEBSITE MERCHANT : "+Website[fchoice]);
        System.out.print(l10);
        System.out.print(ln);
        l11 = align("AMOUNT  : "+fprice[fchoice]);
        System.out.print(l11);
        l12 = align("PAYMENT METHOD : "+ Method_of_Payment[i]);
        System.out.print(l12);
        if(disc)
        {
            l13 = align("DISCOUNT - 20% : "+ Math.round(discount));
            System.out.print(l13);
        }
        l14 = align("GST - 18% : "+ Math.round(gst));
        System.out.print(l14);
        l15 = align("NET AMOUNT  : "+ Math.round(net));
        System.out.print(l15);
        System.out.print(l);
        l16 = align("Thank You for using Tryvago");
        System.out.print(l16);
        System.out.print(ln);
        bill[i] = ln+"\t\t|                               TryVago™                                 |\n"+l+"\t\t|                                 Bill                                   |\n"+l+dt+l+l1+l2+l+l3+l4+l5+l6+l7+l8+l+l9+l10+ln+l11+l12+l13+l14+l15+l+l16+ln;
        i++;
        ch = -1;
        choice = -1;
        p = -1;
        q = -1;
        disc = false;
    }
    String align(String aligner)
    {
        aligner = aligner.trim();
        aligner = "| "+aligner;
        int left = 74 - aligner.length();
        for(int k = 1 ; k <= left - 1 ; k++)
        aligner = aligner + " ";
        aligner = aligner+"|";
        aligner = "\t\t"+aligner+"\n";
        return aligner;
    }
    String DateAlign(String aligner)
    {
        aligner = aligner.trim();
        while(aligner.length() <=69)
        aligner =" " + aligner;
        aligner = "| "+ aligner+" |";
        aligner = "\t\t"+aligner+"\n";
        return aligner;
    }
    void Developer()
    {
        System.out.print("Enter Passkey : ");
        String passkey  = sc.next();
        System.out.println("\f");
        if(passkey.equals("PewDiePie"))
        {
            choice = 0 ;
            System.out.println("Hello Administrator !");
            Admin();
        }
        else
        {
            System.out.println("Wrong Password !");
            Developer();
        }
    }
    void Admin()
    {
        while(choice != 4)
        {
            System.out.println("What Operation to Execute ?\n1] Change Base Price\n2] Change Promo Codes\n3] Check Sales\n4] Exit");
            System.out.print("Enter your Choice : ");
            choice = sc.nextInt();
            if(choice >= 1 && choice <= 4)
            {
                switch(choice)
                {
                    case 1:
                    ChangeBasePrice();
                    break;
                    case 2:
                    ChangePromoCodes();
                    break;
                    case 3:
                    CheckSales();
                    break;
                    case 4:
                    q = -1;
                }
            }
            else
            System.out.println("Enter Correct Choice!");
        }
    }
    void ChangeBasePrice()
    {
        System.out.println("The Current Base Price is : "+base);
        System.out.println("Do you want to change it ?");
        cho = sc.next();
        character = cho.charAt(0);
        if(character =='y' ||character =='Y'||character == '1')
        {
            System.out.print("Enter the New Value of Base Price : ");
            base = sc.nextInt();
            System.out.println("Base Price Changed ! \n");
        }
        Admin();
    }
    void ChangePromoCodes()
    {
        
        System.out.println("The Promo Codes are as follows : ");
        for(k = 0 ; k < p_codes.length ; k++)
        {
            System.out.println((k+1)+"] "+ p_codes[k]);
        }
        System.out.println("Do you want to Change Promo Codes ?");
        cho = sc.next();
        character = cho.charAt(0);
        if(character =='y' ||character =='Y'||character == '1')
        {
            while(true)
            {
                System.out.print("Which Promo Code to Change ?\nEnter your Choice : ");
                choice = sc.nextInt();
                if(choice >= 1 && choice <= p_codes.length)
                {
                    System.out.print("Enter the New Promo Code : ");
                    p_codes[choice-1] = sc.next().trim().toUpperCase();
                    System.out.print("The Code Has been Replaced by "+p_codes[choice-1]+"\n ");
                    break;
                }
                else
                System.out.println("Enter Correct Choice !");
            }
        }
        Admin();
    }
    void CheckSales()
    {
         if(i == 0)
            System.out.println("No Sales Have been made Yet!");
         else
         {
             System.out.println((i) + " Booking(s) have been made !\nThe Customers are as follows : ");
             for(k = 0 ; k < i ; k++)
             {
                 System.out.println((k+1) + "] "+name[k]);
             }
             System.out.print("Do you want to Check any Bills ?");
             cho = sc.next();
             character = cho.charAt(0);
             if(character =='y' ||character =='Y'||character == '1')
             {
                 Bill:
                 while(true)
                 {
                     System.out.print("Enter Which Customer's Bill to Examine : ");
                     choice = sc.nextInt();
                     if(choice >= 1 && choice <= (i+1))
                     {
                         System.out.print(name[choice -1 ]+"'s Bill is as Follows");
                         for(j = 0 ; j < 200000001*5 + 50000000; j++)
                         {
                             if(j == 100000000*5)
                                System.out.print(". ");
                             if(j == 150000000*5)
                                System.out.print(". ");
                             if(j == 200000000*5)
                                System.out.print(". \n");
                             if(j ==  200000000*5 + 50000000 ){}
                            }
                            System.out.println(bill[choice -1]);
                            break Bill;
                     }
                     else
                    {
                     System.out.println("Wrong Choice Entered \nPlease Try Again ! ");
                    }
                 }
             }
         }
    }
}
