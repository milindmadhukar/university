import java.util.* ;
class NoOfNotes
{
    Scanner sc = new Scanner (System.in);
    void main()
    {
        System.out.println("Enter the amount : ");
        int amt = sc.nextInt();
        int r2000,r500,r200,r100,r50,r20,r10,r5,r2,r1 ;
        int bal = amt ;
        r2000=bal/2000;
        bal = bal%2000;
        r500=bal/500;
        bal = bal%500;
        r200=bal/200;
        bal = bal%200;
        r100=bal/100;
        bal = bal%100;
        r50=bal/50;
        bal = bal%500;
        r20=bal/20;
        bal = bal%20;
        r10=bal/10;
        bal = bal%10;
        r5=bal/5;
        bal = bal%5;
        r2=bal/2;
        bal = bal%2;
        r1=bal/1;
        bal = bal%1;
        System.out.println("No. of 2000 notes : "+r2000);
        System.out.println("No. of 500 notes : "+r500);
        System.out.println("No. of 200 notes : "+r200);
        System.out.println("No. of 100 notes : "+r100);
        System.out.println("No. of 50 notes : "+r50);
        System.out.println("No. of 20 notes : "+r20);
        System.out.println("No. of 10 notes : "+r10);
        System.out.println("No. of 5 notes : "+r5);
        System.out.println("No. of 2 notes : "+r2);
        System.out.println("No. of 1 notes : "+r1);
    }
}