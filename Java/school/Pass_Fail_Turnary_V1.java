import java.util.* ;
class Pass_Fail_Turnary_V1
{
    Scanner sc = new Scanner(System.in);
    void main()
    {
        System.out.print("Enter your Marks : ");
        int marks = sc.nextInt();
        System.out.println(marks>60 ? "PASS":"FAIL");
    }
}