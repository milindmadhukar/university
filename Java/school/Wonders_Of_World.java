import java.util.*;
class Wonders_Of_World
{
    Scanner sc = new Scanner(System.in);
    String country[] = new String[7];
    String wonder[] = new String[7];
    int i = 0 ;
    boolean flag = false;
    void main()
    {
        for(i = 0; i < 7 ; i++)
        {
            System.out.println("Enter Location and Name of Wonders of The World "+(i+1)+" : ");
            System.out.print("Enter Location of Wonder of World : ");
            country[i] = sc.next();
            sc.nextLine();
            System.out.print("Enter Name of Wonder of World : ");
            wonder[i] = sc.nextLine();
            System.out.println();
        }
        System.out.print("Enter Country Name : ");
        String country_name = sc.next();
        for(i = 0 ; i < 7 ; i++)
        {
            if(country_name.equalsIgnoreCase(country[i]))
            {
                flag = true;
                break;
            }
        }
        if(flag)
        System.out.println("Country\t-\tWonder\n"+country[i]+"\t-\t"+wonder[i]);
        else
        System.out.println("Sorry ! Not Found !");
    }
}