import java.util.*;
class Hobby_Printer
{
    Scanner sc = new Scanner(System.in);
    String name[] = {"Anurag","Jash","Tirth","Sarthak","Aditya"};
    String hobby[] = new String[name.length];
    void main()
    {
        for(int i = 0 ; i < name.length ; i++)
        {
            System.out.print("Enter "+name[i]+"'s Hobby : ");
            hobby[i] = sc.nextLine();
        }
        for(int i = 0 ; i < name.length ; i++)
        {
            System.out.println(name[i]+"'s Hobby is "+hobby[i]);
        }
    }
}
