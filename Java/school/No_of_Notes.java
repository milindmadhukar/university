import java.util.* ;
class No_of_Notes
{
    Scanner sc = new Scanner(System.in);
    void main()
    {
     System.out.print("Enter the Amount : "); 
     int amount = sc.nextInt();
     int r2000,r500,r200,r100,r50,r20,r10,r5,r2,r1;
     int bal = amount ;
     r2000 = bal/2000;
     bal %= 2000;
     r500 = bal/500;
     bal %= 500;
     r200 = bal/200;
     bal %= 200;
     r100 = bal/100;
     bal %= 100;
     r50 = bal/50;
     bal %= 50;
     r20 = bal/20;
     bal %= 20;
     r10 = bal/10;
     bal %= 10;
     r5 = bal/5;
     bal %= 5;
     r2 = bal/2;
     bal %= 2;
     r1 = bal/1;
     bal %= 1;
     System.out.println("No of 2000rs note :" + r2000);
     System.out.println("No of 500rs note :" + r500);
     System.out.println("No of 200rs note :" + r200);
     System.out.println("No of 100rs note :" + r100);
     System.out.println("No of 50rs note :" + r50);
     System.out.println("No of 20rs note :" + r20);
     System.out.println("No of 10rs note :" + r10);
     System.out.println("No of 5rs note :" + r5);
     System.out.println("No of 2rs note :" + r2);
     System.out.println("No of 1re note :" + r1);
    }
}
