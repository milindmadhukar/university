import java.util.* ;
class Volume_Parameter_Return
{
    Scanner sc = new Scanner(System.in);
    void main()
    {
        int side, length, breadth, height;
        double cube,cuboid ; 
        System.out.println("Enter the side of the Cube : ") ;
        side = sc.nextInt();
        System.out.println("Enter the Length of the cuboid : ") ;
        length = sc.nextInt();
        System.out.println("Enter the Breadth of the cuboid : ") ;
        breadth = sc.nextInt();
        System.out.println("Enter the Height of the cuboid : ") ;
        height = sc.nextInt();
        cube = CubeV(side);
        System.out.println("The Volume of the Cube is  : " +cube+ " Cubic Units") ;
        cuboid = CuboidV(length,breadth,height);
        System.out.println("The Volume of the Cuboid is  : " +cuboid+ " Cubic Units") ;
    }
    double CubeV (int S)
    {
      double Volume = Math.pow(S,3);
      return Volume ;
    }
    double CuboidV (int l, int b ,int h)
    {
        double Volume = l*b*h ;
        return Volume ;
    }
}