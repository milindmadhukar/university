import java.util.*;
class Polygon
{
    Scanner sc = new Scanner(System.in);
    void main()
    {
        System.out.print("Enter Number of Sides : ");
        int sides = sc.nextInt();
        if(sides > 2 && sides<11)
        {
            switch(sides)
            {
              case 3:
              System.out.println("The Shape is a Triangle");
              break ;
              case 4:
              System.out.println("The Shape is a Rectangle");
              break ;
              case 5:
              System.out.println("The Shape is a Pentagon");
              break ;
              case 6:
              System.out.println("The Shape is a Hexagon");
              break ;
              case 7:
              System.out.println("The Shape is a Septagon");
              break ;
              case 8:
              System.out.println("The Shape is a Octagon");
              break ;
              case 9:
              System.out.println("The Shape is a Nanogon");
              break ;
              case 10:
              System.out.println("The Shape is a Decagon");
              break ;
            }
        }
        else
        {
            if(sides < 3 && sides > 0)
            {
                if(sides == 2)
                System.out.println("It is a Straight Line");
                if (sides == 1)
                System.out.println("It is a Point");
            }
            else
            {
                if (sides > 10)
                System.out.println("The Polygon does not have any name ");
                if(sides < 1)
                System.out.println("There is no such Polygon");
                
            }
            
        }
    }
}