import java.util.Scanner;
class Largest_Number
{
   Scanner sc = new Scanner(System.in);
   void main()
   {
      int x, y, z;
      System.out.println("Enter X ");
      x = sc.nextInt();
      System.out.println("Enter Y ");
      y = sc.nextInt();
      System.out.println("Enter Z ");
      z = sc.nextInt();
      if (x > y && x > z)
         System.out.println("X is largest.");
      else if (y > x && y > z)
         System.out.println("Y is largest.");
      else if(z > x && z > y)
         System.out.println("Z is largest.");
      else  
         System.out.println("The numbers are not distinct or are equal ");
   }
}