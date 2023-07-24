import java.util.*;
class Day_in_November
{
    Scanner sc = new Scanner (System.in);
    void main()
    { 
        System.out.println("It is April !");
        System.out.print("Enter a Date to find out what day it is : ");
        int date = sc.nextInt();
        if(date>0 && date < 31)
        {
            switch(date)
            {
               case 1: 
               case 8:
               case 15:
               case 22:
               case 29:
               System.out.println("It is Saturday !");
               break;
               case 2:
               case 9:
               case 16:
               case 23:
               case 30:
               System.out.println("It is Sunday !");
               break;
               case 3:
               case 10:
               case 17:
               case 24:
               System.out.println("It is Monday !");
               break;
               case 4:
               case 11:
               case 18:
               case 25:
               System.out.println("It is Tuesday !");
               break;
               case 5:
               case 12:
               case 19:
               case 26:
               System.out.println("It is Wednesday !");
               break;
               case 6:
               case 13:
               case 20:
               case 27:
               System.out.println("It is Thursday !");
               break;
               case 7:
               case 14:
               case 21:
               case 28:
               System.out.println("It is Friday !");
               break;
            }
        }
            else if ( date == 31)
                System.out.println("November has only 30 days");
            else
                System.out.println("There is no such date");
    }
}