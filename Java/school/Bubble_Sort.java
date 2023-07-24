import java.util.*;
class Bubble_Sort
{
   
   Scanner sc = new Scanner(System.in);
   int i , j ,tmp = 0;
   void Smain(int a[])
   {
       System.out.println("Orginal array: ");
       for(i = 0 ; i < a.length ; i++)
       System.out.print(a[i] + " , ");
       for(i = 0 ; i < a.length ; i++)
       {
           for(j = 0 ; j < a.length - i - 1 ; j++)
           {
               if(a[j] > a[j+1])
               {
                   tmp  = a[j];
                   a[j] = a[j+1];
                   a[j+1] = tmp;
                }
            }
        }
       System.out.println("\nArray is Ascending Order: ");
       for(i = 0 ; i < a.length ; i++)
       System.out.print(a[i] + " , ");
     }
   }
