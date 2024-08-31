import java.util.* ;
class Area_of_Square_Rectangle_Circle{    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        double side, length, breadth, radius ;
        System.out.println("Enter the Side of the Square : ") ;
        side = sc.nextDouble();
        System.out.println("Enter the Length of the Rectangle : ") ;
        length = sc.nextDouble();
        System.out.println("Enter the Breadth of the Rectangle : ") ;
        breadth = sc.nextDouble();
        System.out.println("Enter the Radius of the Circle : ") ;
        radius = sc.nextDouble();
        Area_of_Square_Rectangle_Circle obj = new Area_of_Square_Rectangle_Circle();
        obj.AreaSquare(side);
        obj.AreaRectangle(length,breadth);
        obj.AreaCircle(radius);
        sc.close();
    }
    void AreaSquare (double side){
      double Area = Math.pow(side,2);
      System.out.println("The Area of the Square is : " +Area+ " Square Units") ;
    }
    void AreaRectangle (double length,double breadth){
        double Area = length * breadth ;
        System.out.println("The Area of the Rectangle is : " +Area+ " Square Units") ;
    }
     void AreaCircle (double radius){
        double Area = Math.PI * Math.pow(radius,2) ;
        System.out.println("The Area of the Circle is : " +Area+ " Square Units") ;
    }
}