class Transpose
{
    int k = 1,r,c ; 
    int a[][] = new int [3][2];
    int a_transpose[][] = new int [2][3];
    void main()
    {
        System.out.println("Orignal Array : ");
        for(r = 0 ; r < 3;r++)
        {
            for(c =  0 ; c < 2 ; c++,k++)
            {
                a[r][c] = k;
                System.out.print(a[r][c]+"\t");
            }
            System.out.println();
        }
        System.out.println("\nTranspose Array : ");
        for(r = 0 ; r < 2;r++)
        {
            for(c =  0 ; c < 3 ; c++)
            {
                a_transpose[r][c] = a[c][r];
                System.out.print(a[c][r]+"\t");
            }
            System.out.println();
        }
    }
}