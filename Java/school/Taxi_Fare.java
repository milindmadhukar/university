import java.util.*;
class Taxi_Fare
{
    Scanner sc = new Scanner(System.in);
    void main()
    {
        System.out.print("Enter the distance travelled in kms: ");
        double cost = 0 ;
        double dis = sc.nextDouble();
        if(dis <= 1)
           cost = 18;
        else if(dis <= 5)
               cost = 18 + (20 * (dis - 1 ));
        else if(dis <= 10)
               cost = 18 + 80+ (25 * (dis - 5 ));
        else
               cost = 18 + 100 + 125 + (30 * (dis - 10 ));
               
        System.out.println("Your Fare is : "+Math.round(cost));
    }
}