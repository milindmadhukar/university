class Triangle_Pattern
{
    int i,j,r,c,c1,k = 1;
    int a[][] = new int [5][5];
    void main()
    {
        for(i = 0 ; i < 5 ; i++)
        {
            for(j = 0 ; j < 5 ; j++)
            {
                a[i][j] = k;
                k++;
            }
        }
        System.out.println(" \nOrignial Array :");
        for(i = 0 ; i < 5 ; i++)
        {
            for(j = 0 ; j < 5 ; j++)
            {
                System.out.print(a[i][j]+"\t");
            }
            System.out.println();
        }
        System.out.println("\nPattern : ");
        for(r = 0 ; r < 5 ; r++)
        {
            for(c1 = r ; c1 > 0 ; c1--)
            {  
                System.out.print("  \t");
            }
            for(c = r ; c < 5 ; c++)
            {
                System.out.print(a[r][c] + "\t");
            }
            System.out.println();
        }
    }
}