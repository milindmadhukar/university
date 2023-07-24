import java.util.* ;
class Pass_Fail_Turnary_V3
{
    Scanner sc = new Scanner(System.in);
    void main()
    {
        System.out.print("Enter your Percentage : ");
        int per = sc.nextInt();
        if (per>100)
        {
            System.out.println("This cannot be your Percentage,Dont Try to fool my Program :)");
        }
        else
        {
        if(per>60)
        {
            System.out.println("You Passsed");
        }
        else
        {
           System.out.println("You Passsed"); 
        }
        
        }
    }
}