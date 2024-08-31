import java.util.* ;
class Volume_NoParameter_NoReturn
{
    Scanner sc = new Scanner(System.in);        
    void main()
    {
        CubeV();
        CuboidV();
    }
    void CubeV ()
    {
      int side;
      System.out.println("Enter the side of the Cube : ") ;
      side = sc.nextInt();
      double Volume = Math.pow(side,3);
      System.out.println("The Volume of the Cube is  : " +Volume+ " Cubic Units") ;
    }
    void CuboidV ()
    {
        int length, breadth, height;
        System.out.println("Enter the Length of the cuboid : ") ;
        length = sc.nextInt();
        System.out.println("Enter the Breadth of the cuboid : ") ;
        breadth = sc.nextInt();
        System.out.println("Enter the Height of the cuboid : ") ;
        height = sc.nextInt();
        double Volume = length*breadth*height ;
        System.out.println("The Volume of the Cuboid is  : " +Volume+ " Cubic Units") ;
    }
}