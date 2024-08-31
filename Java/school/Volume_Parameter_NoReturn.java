import java.util.* ;
class Volume_Parameter_NoReturn
{
    Scanner sc = new Scanner(System.in);
    void main()
    {
        int side, length, breadth, height;
        System.out.println("Enter the side of the Cube : ") ;
        side = sc.nextInt();
        System.out.println("Enter the Length of the cuboid : ") ;
        length = sc.nextInt();
        System.out.println("Enter the Breadth of the cuboid : ") ;
        breadth = sc.nextInt();
        System.out.println("Enter the Height of the cuboid : ") ;
        height = sc.nextInt();
        CubeV(side);
        CuboidV(length,breadth,height);
    }
    void CubeV (int S)
    {
      double Volume = Math.pow(S,3);
      System.out.println("The Volume of the Cube is  : " +Volume+ " Cubic Units") ;
    }
    void CuboidV (int l, int b ,int h)
    {
        double Volume = l*b*h ;
        System.out.println("The Volume of the Cuboid is  : " +Volume+ " Cubic Units") ;
    }
}