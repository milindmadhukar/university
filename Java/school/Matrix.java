import java.util.*;
class Matrix
{
    Scanner sc = new Scanner(System.in);
    int a[][] = new int [4][4];
    void main()
    {
        int c = 1;
        int sum = 0;
        for(int i = 0 ; i < 4 ; i++)
        {
            for(int j = 0 ; j < 4 ; j++)
            {
                System.out.print("TECHIE :) \n Enter number " + c +" : ");
                c++;
                a[i][j] = sc.nextInt();
                sum += a[i][j];
            }
        }
        for(int i = 0 ; i < 4 ; i++)
        {
            for(int j = 0 ; j < 4 ; j++)
            {
                System.out.print(a[i][j]+"\t");
            }
            System.out.println();
        }
        int large = a[0][0];
        int posx = 0 , posy = 0;
        for(int i = 0 ; i < 4 ; i++)
        {
            for(int j = 0 ; j < 4 ; j++)
            {
                if(a[i][j] > large)
                {
                    large = a[i][j];
                    posx = i;
                    posy = j;
                }
            }
        }
        System.out.println("Sum of Array is : "+sum);
        System.out.println("Largest Number : "+large+ " found at ("+posx+","+posy+") index numbers");
    }
}