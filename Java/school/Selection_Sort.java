import java.util.*;
class Selection_Sort extends Bubble_Sort
{
Scanner sc = new Scanner(System.in);
int i , j , pos ,small , tmp=0 ; 
int arr[] = {23,43,53,12,2,33,78,1,108,97};
void main()
{
    System.out.println("Orginal array: ");
    for(i = 0 ; i < arr.length ; i++)
    System.out.print(arr[i] + " , ");




    for( i = 0 ; i < arr.length ; i ++)
    {
        small = arr[i];
        pos = i ;
        for(j = i+1 ; j < arr.length ; j++)
        {
            if(arr[j] > small)
            {
                small = arr[j];
                pos = j;
            }
        }
        tmp = arr[i];
        arr[i] = arr[pos];
        arr[pos] = tmp;
    }
    System.out.println("\nArray in descending order : ");
    for(i = 0 ; i < arr.length ; i++)
    {
        System.out.print(arr[i] + " , ");
    }
}
}
