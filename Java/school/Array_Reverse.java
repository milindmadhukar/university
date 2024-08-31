import java.util.*;
class Array_Reverse{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Length of Array : ");
        int n = sc.nextInt();
        int a[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            System.out.print("Enter Number "+(i+1)+" : ");
            a[i] = sc.nextInt();
        }
        sc.close();
        for(int item: a){
            System.out.print(item+", ");
        }
        System.out.println("\nNew Array");
        int temp = 0;
        int len = a.length - 1;
        for(int i = 0; i < (a.length/2) ; i++){
            temp = a[i];
            a[i] = a[len-i];
            a[len-i] = temp;
        }
        for(int item: a){
            System.out.print(item+", ");
        }
    }
}