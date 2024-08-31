import java.util.* ;
class Largest_Number_Ternary
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
      largest(x,y,z);
    }
    void largest(int a ,int b, int c)
    {
      int max = (a>b)?((a>c)?a:c):((b>c)?b:c);
      System.out.println("Largest Number is : "+max);
    }
}