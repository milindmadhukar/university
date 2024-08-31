import java.util.* ;
class Pallindrome
{
    Scanner sc = new Scanner(System.in);
    void main()
    {
        System.out.print("Enter a Number to check whether its Pallindrome or not : ");
        int num = sc.nextInt();
        int New_num = num ;
        int reversed = 0;
        while(New_num != 0)
        {
            int digit = New_num % 10;
            reversed = reversed * 10 + digit;
            New_num /= 10;
        }
        System.out.println("Reverse of the entered number is : " + reversed);
        if (num == reversed)
        System.out.println("The number is a Pallindrome");
        else
        System.out.println("The number is not a Pallindrome");
    }
}