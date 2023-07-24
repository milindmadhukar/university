import java.util.* ;
class Sum_Loop
{
    Scanner sc = new Scanner(System.in);
    void main()
    {
        System.out.println("Enter a number for sum of natural numbers : ");
        int num = sc.nextInt();
        int sum = 0;
        for(int i = 1;i <= num; i++)
        {
            sum = sum + i;
        }
        System.out.print(sum);
    }
}