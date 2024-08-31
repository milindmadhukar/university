import java.util.* ;
class Volume_NoParameter_Return
{
    Scanner sc = new Scanner(System.in);        
    void main()
    {
        double cube,cuboid ;
        cube = CubeV();
        System.out.println("The Volume of the Cube is  : " +cube+ " Cubic Units") ;
        cuboid = CuboidV();
        System.out.println("The Volume of the Cube is  : " +cuboid+ " Cubic Units") ;
    }
    double CubeV ()
    {
      int side;
      System.out.println("Enter the side of the Cube : ") ;
      side = sc.nextInt();
      double Volume = Math.pow(side , 3) ;
      return Volume ;
    }
    double CuboidV ()
    {
        int length, breadth, height;
        System.out.println("Enter the Length of the cuboid : ") ;
        length = sc.nextInt();
        System.out.println("Enter the Breadth of the cuboid : ") ;
        breadth = sc.nextInt();
        System.out.println("Enter the Height of the cuboid : ") ;
        height = sc.nextInt();
        double Volume = length*breadth*height ;
        return Volume ;
    }
}