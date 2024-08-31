import java.util.* ;
public class ReverseNumber {
    Scanner sc = new Scanner(System.in);

        void Reverse_Number()
        {
        System.out.print("Enter the Number that has to be reversed_num : ");
        int num = sc.nextInt();
        int reversed_num = 0;

        while(num != 0) {
            int digit = num % 10;
            reversed_num = reversed_num * 10 + digit;
            num /= 10;
        }

        System.out.println("Reversed Number: " + reversed_num);
    }
}