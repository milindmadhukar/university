import java.util.Scanner;

class Pascal_Triangle
{
    void main()
	{
	    int r, i, k, number=1, j;
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Number of Rows : ");
		r = sc.nextInt();
	
		       for(i=0;i<r;i++)
		        {
			for(k=r; k>i; k--)
			{
				System.out.print(" ");
			}
                        number = 1;
			for(j=0;j<=i;j++)
			{
				 System.out.print(number+ " ");
                         number = number * (i - j) / (j + 1);
			}
			System.out.println();
		}
}
}
