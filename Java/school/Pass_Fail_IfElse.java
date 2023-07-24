import java.util.* ;
class Pass_Fail_IfElse
{
    Scanner sc = new Scanner(System.in);
    void main()
    {
        System.out.print("Enter your Percentage : ");
        int per = sc.nextInt();
        if(per>60)
        {
            System.out.print("You Passed");
        }
        else
        {
            System.out.print("You Failed");
        }
    }
}