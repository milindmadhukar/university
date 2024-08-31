import java.util.*;
class Linear_Search
{
Scanner sc = new Scanner(System.in);
int arr[] = {2,4,6,8,13,5,223333,61,7};
void main()
{
    for(int i = 0 ; i < arr.length ; i++)
    System.out.print(arr[i] + " , ");
    System.out.print("\n");
    System.out.print("Enter Number to Find : ");
    int n = sc.nextInt();
    boolean flag = false;
    int i = 0;
    for( i = 0 ; i < arr.length ; i++)
    {
        if(arr[i] == n)
        {
            flag = true;
            break;
        }
    }
    if(flag == true)
    System.out.println("Number Found at " + (i+1));
    else
    System.out.println("Error 404");
}
}