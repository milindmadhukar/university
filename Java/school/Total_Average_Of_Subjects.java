import java.util.* ;
class Total_Average_Of_Subjects
{
    String name = "MILIND MADHUKAR" ;
    double roll_no = 9131 ;
    Scanner sc = new Scanner (System.in);
    void main()
    {
        double english,maths,science ;
        System.out.println("Enter your English Marks : ") ;
        english = sc.nextDouble();
        System.out.println("Enter your Maths Marks : ") ;
        maths = sc.nextDouble();
        System.out.println("Enter your Science Marks : ") ;
        science = sc.nextDouble();
        Calc(english,maths,science);
    }
    void Calc(double eng,double math,double sci)
    {
        double total = eng + math + sci ;
        double average = total / 3 ;
        System.out.println("The Total is : " + total) ;
        System.out.println("");
        System.out.println("The Total is : " + total) ;
        System.out.println("The Average is : " + average) ;
    }
}