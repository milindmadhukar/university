import java.util.* ; 
class Square_Cube
{
    Scanner sc = new Scanner ( System.in ) ;
    void main()
    {
        System.out.println("Enter a number : ");
        int number = sc.nextInt();
        double sq = square (number);
        System.out.println("The Square of the number is : "+sq);
        double cube = cube(sq);
        System.out.println("The Cube of the Square is : "+cube);
    }
    double square(int number)
    {
        double sq = Math.pow(number,2);
        return sq ;
    }
    double cube (double number)
    {
        double cube = Math.pow(number,3);
        return cube ;
    }
}